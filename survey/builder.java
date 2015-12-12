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
	return new survey.administrator(this.questions.toArray(new String[this.questions.size()]));
    }

    /* fields */
    private java.util.List<String> questions;
}
