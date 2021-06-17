package edu.team04.crucible;

import java.util.ArrayList;
import java.util.List;

public class Category {

    private int id;
    private String name;
    private List<Card> cards;

    public Category(int id, String name){
        this.id = id;
        this.name = name;
        this.cards = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Card> getCards() {
        return cards;
    }

    public Card getCard(int index){
        //returns a specific card by index
        return this.cards.get(index);
    }

    public void replaceCard(int oldCardIndex, Card editedCard){
        //replaces old card with edited version
        this.cards.set(oldCardIndex, editedCard);
    }

    public void addCard(Card card){
        this.cards.add(card);
    }

    public void removeCard(Card card){
        this.cards.remove(card);
    }

}
