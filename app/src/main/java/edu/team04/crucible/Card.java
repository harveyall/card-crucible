package edu.team04.crucible;

public class Card extends Selectable {

    private String category;
    private String question;
    private String answer;


    /** Constructs a Card with a specified values for category, question, and answer
     * @param category
     * @param question
     * @param answer
     * */
    public Card(String category, String question, String answer){
        this.category = category;
        this.question = question;
        this.answer = answer;
    }

    /** Returns the name of the category for this Card*/
    public String getCategory() {
        return category;
    }

    /** Sets the name of the category of this Card to a new string value*/
    public void setCategory(String category) {
        this.category = category;
    }

    /** Returns the question for this Card*/
    public String getQuestion() {
        return question;
    }

    /** Sets the question of this Card to a new string value*/
    public void setQuestion(String question) {
        this.question = question;
    }

    /** Returns the answer for this Card*/
    public String getAnswer() {
        return answer;
    }

    /** Sets the answer of this Card to a new string value*/
    public void setAnswer(String answer) {
        this.answer = answer;
    }

    /**
     * Return true if data in this card has the same data as the inputted card.
     * @param card2
     */
    public boolean isEqual(Card card2){
        if(this.category.equals(card2.category) && this.question.equals(card2.question) && this.answer.equals(card2.answer)){
            return true;

        }  else{
            return false;
        }
    }

    /** Return a string representation of this Card*/
    @Override
    public String toString() {
        return String.format("Category: %s%nQuestion: %s%nAnswer: %s%n",
                this.category, this.question, this.answer);
    }
}