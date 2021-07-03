package edu.team04.crucible;

import java.util.ArrayList;
import java.util.List;

public class Category {

    private String name;
    private List<Card> cards;

    /**
     * Constructs a Category with a specified name
     * @param name
     */
    public Category(String name){
        this.name = name;
        this.cards = new ArrayList<>();
    }

    /** Return the name of this category */
    public String getName() {
        return name;
    }

    /** Set the name of this category to the specified string value
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /** Return this category's list of cards */
    public List<Card> getCards() {
        return cards;
    }

    /** Using a card's index, return that card from this category's list of cards
     * @param index
     */
    public Card getCard(int index){
        //returns a specific card by index
        return this.cards.get(index);
    }

    /** Replace an card with it's edited version using the index of the original card
     * @param oldCardIndex
     * @param editedCard
     */
    public void replaceCard(int oldCardIndex, Card editedCard){
        //replaces old card with edited version
        this.cards.set(oldCardIndex, editedCard);
    }

    /** Add a card for this category's list of cards
     * @param card
     * */
    public void addCard(Card card){
        if(this.canAddCards()) {
            this.cards.add(card);
        }
    }

    /** This method returns true if there are less than 50 cards in this category's list of cards and false if not */
    public boolean canAddCards(){
        return this.cards.size() < 50;
    }

    /** Remove a card for this category's list of cards
     * @param card
     * */
    public void removeCard(Card card){
        this.cards.remove(card);
    }

    /** Return a string representing this category*/
    @Override
    public java.lang.String toString() {
        return "Category{" +
                "name='" + name + '\'' +
                ", cards=" + cards +
                '}';
    }
}
