package survey;
public class administrator {
    /* constructor */
    public administrator( String [] questions, String title ){
	this.questions = questions;
	this.title = title;
	this.stats = new survey.mutableStatistics( questions.length );
	this.nextRespondentID = 1;
    }
    /* methods */
    public survey.instance getSurvey(){
	return new survey.instance( this.questions, this.title, this.stats, this.nextRespondentID++ );
    }

    public survey.statistics getStats(){
	return this.stats;
    }

    /* fields */
    private String[] questions;
    private String title;
    private survey.mutableStatistics stats;
    private int nextRespondentID;
}
