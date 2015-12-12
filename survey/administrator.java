package survey;
public class administrator {
    /* constructor */
    public administrator( String [] questions ){
	this.questions = questions;
	this.stats = new survey.mutableStatistics( questions.length );
	this.respondentID = 1;
    }
    /* methods */
    public survey.instance getSurvey(){
	return new survey.instance( questions, this.stats, this.respondentID++ );
    }

    public survey.statistics getStats(){
	return this.stats;
    }

    /* fields */
    private String[] questions;
    private survey.mutableStatistics stats;
    private int respondentID;
}