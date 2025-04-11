package com.poker.poker.game.model;

import com.poker.poker.game.actions.*;
import com.poker.poker.game.feedback.CallMessage;
import com.poker.poker.game.feedback.FoldMessage;
import com.poker.poker.game.feedback.GameMessage;
import com.poker.poker.gamelobby.entity.GameLobby;

import java.util.*;

public class GameState {
    private UUID id;
    private List<PlayerInGame> players;
    private GamePhase phase;
    private Deck deck;
    private int pot;
    private int currentBet;
    private int callCount;
    private int currentPlayer;
    private List<Card> communityCards;
    private WinnerInfo winnerInfo;
    private List<Action> actionList;
    private boolean allIn;

    public GameState(GameLobby gl) {
        this.id = gl.getId();

        this.players = new ArrayList<>();

        List<Player> lobbyList = gl.getPlayers();

        for (Player player : lobbyList) {
            this.players.add(new PlayerInGame(player));
        }
        this.deck = new Deck();
        this.deck.shuffle();
        this.pot = 0;
        this.callCount = 0;
        this.currentBet = 0;
        this.currentPlayer = 0;
        this.communityCards = new ArrayList<>();
        this.winnerInfo = null;
        this.allIn = false;
        this.actionList = new ArrayList<>();
        this.phase = GamePhase.PREFLOP;

        for (PlayerInGame player : this.players) {
            Card c = deck.drawCard(), cc = deck.drawCard();

            player.addCards(c);
            player.addCards(cc);

            HoleCard hc = new HoleCard(player.getPlayer().getId(), c);
            HoleCard hcc = new HoleCard(player.getPlayer().getId(), cc);

            actionList.add(hc);
            actionList.add(hcc);
        }

        actionList.add(new PlayerTurn(players.get(currentPlayer).getPlayer().getId(), 5));
    }

    public UUID getId() {
        return id;
    }

    public List<PlayerInGame> getPlayers() {
        return players;
    }

    public void setPlayers(List<PlayerInGame> players) {
        this.players = players;
    }

    public int getCallCount() {
        return callCount;
    }

    public void setCallCount(int callCount) {
        this.callCount = callCount;
    }

    public int getCurrentBet(){
        return currentBet;
    }

    public void setCurrentBet(int currentBet) {
        this.currentBet = currentBet;
    }

    public Deck getDeck() {
        return deck;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    public PlayerInGame getPlayer(UUID id) {
        for (PlayerInGame player : players) {
            if (player.getPlayer().getId().equals(id)) {
                return player;
            }
        }

        return null;
    }

    public int getPot() {
        return pot;
    }

    public void addToPot(int amount) {
        this.pot += amount;
    }

    public List<Card> getCommunityCards() {
        return communityCards;
    }

    public void addCard(Card card) {
        this.communityCards.add(card);
    }

    public void setWinnerInfo(WinnerInfo winnerInfo) {
        this.winnerInfo = winnerInfo;
    }

    public List<Action> getActionList() {
        return actionList;
    }

    public void emptyActionList() {
        this.actionList.clear();
    }

    public void advanceCurrentPlayer() {
        currentPlayer = (currentPlayer + 1) % players.size();
    }

    public void advancePhase(){
        switch(phase){
            case PREFLOP:
                callCount = 0;
                currentPlayer = 0;

                for (int i = 0; i < 3; i++){
                    Card c = deck.drawCard();

                    addCard(c);

                    actionList.add(new CommunityCard(c));
                }

                /*for (PlayerInGame player : players) {
                    PlayerBestHand pbh = LogicProcessor.processBestHand(player, this);

                    actionList.add(new OrdinalPBS(pbh, player.getPlayer().getId()));
                }*/

                actionList.add(new PlayerTurn(players.get(currentPlayer).getPlayer().getId(), currentBet - (1000 - players.get(currentPlayer).getBalance())));

                phase = GamePhase.FLOP;
                break;

            case FLOP:
                callCount = 0;
                currentPlayer = 0;

                Card c = deck.drawCard();

                addCard(c);

                actionList.add(new CommunityCard(c));

                /*for (PlayerInGame player : players) {
                    PlayerBestHand pbh = LogicProcessor.processBestHand(player, this);

                    actionList.add(new OrdinalPBS(pbh, player.getPlayer().getId()));
                }*/

                actionList.add(new PlayerTurn(players.get(currentPlayer).getPlayer().getId(), currentBet - (1000 - players.get(currentPlayer).getBalance())));

                phase = GamePhase.TURN;
                break;

            case TURN:
                callCount = 0;
                currentPlayer = 0;

                Card cc = deck.drawCard();

                addCard(cc);

                actionList.add(new CommunityCard(cc));

                /*for (PlayerInGame player : players) {
                    PlayerBestHand pbh = LogicProcessor.processBestHand(player, this);

                    actionList.add(new OrdinalPBS(pbh, player.getPlayer().getId()));
                }*/

                actionList.add(new PlayerTurn(players.get(currentPlayer).getPlayer().getId(), currentBet - (1000 - players.get(currentPlayer).getBalance())));

                phase = GamePhase.RIVER;
                break;

            case RIVER:
                for (PlayerInGame player : players) {
                    player.setBestHand(LogicProcessor.processBestHand(player, this));
                }

                System.out.println("RIVER FT YOUNG THUG");

                for (PlayerInGame player : players) {
                    System.out.println(player.getPlayer().getNickname());

                    for (Card card : player.getHand()) {
                        System.out.println(card.getSuit() + " " + card.getRank());
                    }
                }
                System.out.println("COMMUNITY CARDS");
                for (Card card : communityCards) {
                    System.out.println(card.getSuit() + " " + card.getRank());
                }

                WinnerInfo winnerInfo = LogicProcessor.processWinners(this);

                actionList.add(new Winners(winnerInfo));

                System.out.println("WINNER INFO");
                break;
        }
    }

    public void processMessage(GameMessage message) {
        switch (message.getActionType()){
            case 3:
                processCall((CallMessage) message);
                break;
            case 4:
                processFold((FoldMessage) message);
                break;
        }
    }

    private void processCall(CallMessage message) {
        PlayerInGame player = getPlayer(message.getPlayerId());

        int og = player.getBalance();

        player.setBalance(player.getBalance() - message.getAmount());

        pot += message.getAmount();

        if (message.getAmount() + (1000 - og) > currentBet) {
            currentBet = message.getAmount() + (1000 - og);
            callCount = 1;

            if (currentBet == 1000) {
                allIn = true;
            }
        }

        else if (message.getAmount() + (1000 - og) == currentBet) {
            callCount++;
        }

        actionList.add(new PlayerCall(message.getPlayerId(), message.getAmount(), pot));

        if (callCount == players.size()) advancePhase();

        else {
            advanceCurrentPlayer();

            actionList.add(new PlayerTurn(players.get(currentPlayer).getPlayer().getId(), currentBet - (1000 - players.get(currentPlayer).getBalance())));
        }
    }

    private void processFold(FoldMessage message) {
        PlayerInGame player = getPlayer(message.getPlayerId());

        players.remove(player);

        actionList.add(new PlayerFold(message.getPlayerId()));

        callCount++;

        if (callCount == players.size()) advancePhase();

        else {
            advanceCurrentPlayer();

            actionList.add(new PlayerTurn(players.get(currentPlayer).getPlayer().getId(), currentBet - (1000 - players.get(currentPlayer).getBalance())));

        }
    }
}
