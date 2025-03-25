package com.poker.poker.WebSocket;

import com.poker.poker.game.actions.ActionType;
import com.poker.poker.game.actions.CommunityCard;
import com.poker.poker.game.actions.HoleCard;
import com.poker.poker.game.actions.OrdinalCard;
import com.poker.poker.game.feedback.GameMessage;
import com.poker.poker.game.model.Card;
import com.poker.poker.game.model.Rank;
import com.poker.poker.game.model.Suit;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.UUID;

@Controller
public class WebSocketController {
    private final WebSocketService webSocketService;

    public WebSocketController(WebSocketService webSocketService) {
        this.webSocketService = webSocketService;
    }

    @MessageMapping("/games/{gameId}")
    public void receive(@DestinationVariable String gameId, @Payload GameMessage message){
        webSocketService.onMessageReceived(gameId, message);
    }

    @GetMapping("/game_test/{gameId}")
    public void testCards(@PathVariable String gameId, @RequestBody CardRequest cardRequest){
        Suit c = null;
        Rank r = null;

        int a = cardRequest.getSuit(), b = cardRequest.getRank();

        for (Suit s : Suit.values()) {
            if (s.ordinal() == a) c = s;
        }

        for (Rank rr : Rank.values()) {
            if (rr.ordinal() == b) r = rr;
        }

        CommunityCard card = new CommunityCard(ActionType.COMMUNITY_CARD, new Card(c, r));

        UUID uuid = UUID.fromString(gameId);

        webSocketService.sendMessageToGame(uuid, card);

        System.out.println("Community card sent");
    }

    @GetMapping("player_test/{playerId}")
    public void testHoleCards(@PathVariable String playerId, @RequestBody CardRequest cardRequest){
        Suit c = null;
        Rank r = null;

        int a = cardRequest.getSuit(), b = cardRequest.getRank();

        for (Suit s : Suit.values()) {
            if (s.ordinal() == a) c = s;
        }

        for (Rank rr : Rank.values()) {
            if (rr.ordinal() == b) r = rr;
        }

        HoleCard card = new HoleCard(ActionType.HOLE_CARD, new Card(c, r));

        UUID uuid = UUID.fromString(playerId);

        webSocketService.sendMessageToPlayer(uuid, card);

        System.out.println("Hole card sent");
    }


}
