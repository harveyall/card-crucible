package edu.team04.crucible;

import java.util.ArrayList;
import java.util.List;

public class Category {

    private String name;
    private List<Card> cards;

    public Category(String name){
        this.name = name;
        this.cards = new ArrayList<>();
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
        if(this.canAddCards()) {
            this.cards.add(card);
        }
    }

    /** This method returns true if there are less than 50 cards in this category's list of cards and false if not */
    public boolean canAddCards(){
        return this.cards.size() < 50;
    }

    public void removeCard(Card card){
        this.cards.remove(card);
    }

    @Override
    public java.lang.String toString() {
        return "Category{" +
                "name='" + name + '\'' +
                ", cards=" + cards +
                '}';
    }
}
