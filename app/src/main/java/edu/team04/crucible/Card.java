package edu.team04.crucible;

public class Card extends Selectable {

    private String category;
    private String question;
    private String answer;

    public Card(String category, String question, String answer){
        this.category = category;
        this.question = question;
        this.answer = answer;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

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

    @Override
    public String toString() {
        return String.format("Category: %s%nQuestion: %s%nAnswer: %s%n",
                this.category, this.question, this.answer);
    }
}