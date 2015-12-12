package survey;
public class instance {
    /* constructor */
    instance( String[] questions, survey.mutableStatistics stats, int respondentID ){
	this.answeredQuestions = new java.util.HashSet<Integer>();
	this.questions = questions;
	this.respondentID = respondentID;
	this.result = new survey.mutableResult( this.questions.length );
	this.stats = stats;
        this.in = new java.util.Scanner(System.in);
    }

    /* method */
    void displayQuestion( int questionNumber ){
	System.out.println( this.questions[questionNumber - 1] );
	this.result.responseValue( questionNumber - 1, this.in.nextInt() );
	this.answeredQuestions.add(questionNumber);
    }

    void displayPersonalizedQuestion( int questionNumber, boolean personalize ){
	if (personalize){
	    System.out.println("Respondent " + this.respondentID + ", please answer the following question:");
	}
	this.displayQuestion( questionNumber );
    }

    void submit(){
	if ( this.answeredQuestions.size() == this.questions.length ){
	    this.result.wasCompleted(true);
	}
	this.stats.collect( this.respondentID, this.result );
    };

    public void conduct( boolean personalize ){
	for (int i = 0; i < this.questions.length; ++i){
	    this.displayPersonalizedQuestion(i+1, personalize);
	}
	this.submit();
	System.out.println();
    }

    /* fields */
    String[] questions;
    java.util.Set<Integer> answeredQuestions;
    int respondentID;
    survey.mutableResult result;
    survey.mutableStatistics stats;
    java.util.Scanner in;
}
