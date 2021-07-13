package edu.team04.crucible;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This class represents a list of flashcards to be used for the Study Mode & Game Mode Activities.
 */
public class CardList {
    List<Card> cards;


    /** Constructs a CardList with an empty array list*/
    public CardList(){
        this.cards = new ArrayList<>();
    }

    /** Constructs a CardList with a specified list of cards*/
    public CardList(List<Card> cards){
        this.cards = cards;
    }

    /** Constructs a CardList with a specified list of cards from a categoryList*/
    public CardList(CategoryList categoryList){
        if(categoryList != null) {
            cards = new ArrayList<>();
            for (Category category : categoryList.getCategories()) {
                for (Card card : category.getCards()) {
                    cards.add(card);
                }
            }
        }
        else{
            cards = null;
        }
    }
    /**
     * This method returns a list of Card objects belonging to this list.
     * @return The list of Card objects.
     */
    public List<Card> getCards() {
        return cards;
    }

    /**
     * This method populates the CardList with the provided list of cards.
     * @param cards The list of Card objects.
     */
    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    /**
     * This method returns the card matching the provided index.
     * @param index The provided index integer.
     * @return The Card object matching the provided index.
     */
    public Card getCard(int index){
        return this.cards.get(index);
    }

    /**
     * This method adds the specified card to the list.
     * @param card The provided Card object.
     */
    public void addCard(Card card){
        this.cards.add(card);
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
     * This method deletes the Card matching the specified index integer.
     * @param index The provided index integer.
     */
    public void deleteCard(int index){
        this.cards.remove(index);
    }


    /** Return a string representation of this CardList*/
    @Override
    public String toString() {
        return "CardList{" +
                "cards=" + cards +
                '}';
    }
}