package survey;
public class builder{
    /* constructor */
    public builder(){
	this.questions = new java.util.ArrayList<String>();
    }
    /* methods */
    public void addQuestion(String question){
	this.questions.add(question);
    }
    
    public survey.administrator makeSurvey(){
	String [] questionList = this.questions.toArray(new String[this.questions.size()]);
	this.questions = new java.util.ArrayList<String>();
	return new survey.administrator(questionList);
    }

    public int numQuestions(){
	return this.questions.size();
    }

    public void printQuestions(){
	for (int i = 0; i < this.questions.size(); ++i){
	    System.out.println( (i+1) + ". " + this.questions.get(i));
	}
	System.out.println();
    }

    public void removeQuestion(int questionNumber){
	this.questions.remove(questionNumber - 1);
    }

    /* fields */
    private java.util.List<String> questions;
}
