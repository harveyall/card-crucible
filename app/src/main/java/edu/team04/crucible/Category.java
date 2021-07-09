package edu.team04.crucible;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A Category of flashcards, with a name and a list of cards associated with it.
 */
public class Category extends Selectable {

    private String name;
    private List<Card> cards;

    /**
     * Constructs a Category with a specified name
     * @param name The provided name string.
     */
    public Category(String name){
        this.name = name;
        this.cards = new ArrayList<>();
    }

    /**
     * This method returns the name of the category.
     * @return The category's name string.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of this category to the specified string value
     * @param name The provided name string.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns this category's list of cards
     * @return A list of the Card objects.
     */
    public List<Card> getCards() {
        return cards;
    }

    /** Using a card's index, return that card from this category's list of cards
     * @param index The provided index.
     */
    public Card getCard(int index){
        //returns a specific card by index
        return this.cards.get(index);
    }

    /** This method replaces a card with it's edited version using the index of the original card.
     * @param oldCardIndex The provided index for the old card.
     * @param editedCard The edited Card object.
     */
    public void replaceCard(int oldCardIndex, Card editedCard){
        this.cards.set(oldCardIndex, editedCard);
    }

    /** Add a card for this category's list of cards
     * @param card A Card object.
     * */
    public void addCard(Card card){
        if(this.canAddCards()) {
            this.cards.add(card);
        }
    }

    /**
     * This method returns true if there are less
     * than 50 cards in this category's list of cards and false if not
     * @return True or False.
     */
    public boolean canAddCards(){
        return this.cards.size() < 50;
    }

    /** This method removes a card for this category's list of cards
     * @param card A Card object.
     * */
    public void removeCard(Card card){
        this.cards.remove(card);
    }

    /**
     * This method returns true if the specified card is found within this category.
     * @param card A Card object.
     * @return True or False.
     */
    public boolean containsCard(Card card){
        for(Card cardItem : this.cards) {
            if(cardItem.isEqual(card)){
                return true;
            }
        }
        return false;
    }

    /**
     * This method shuffles the provided List of Cards.
     * @param toRandomize The List which cards are to be shuffled.
     * @return The List after the cards have been shuffled.
     */
    public Category randomizeCards(Category toRandomize) {
        Collections.shuffle(toRandomize.getCards());
        return toRandomize;
    }

    /**
     * Returns a string representing this category
     */
    @Override
    public java.lang.String toString() {
        return "Category{" +
                "name='" + name + '\'' +
                ", cards=" + cards +
                '}';
    }
}