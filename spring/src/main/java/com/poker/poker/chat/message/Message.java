package com.poker.poker.chat.message;

public class Message {
    private String content;
    private String from;

    public String getFrom() {
        return from;
    }

    // Setter for 'from'
    public void setFrom(String from) {
        this.from = from;
    }

    // Getter for 'content'
    public String getContent() {
        return content;
    }

    // Setter for 'content'
    public void setContent(String content) {
        this.content = content;
    }
}
