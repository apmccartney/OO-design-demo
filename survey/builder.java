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

    /* fields */
    private java.util.List<String> questions;
}
