package survey;
public class instance {
    /* constructor */
    instance( String[] questions, 
	      String title, 
	      survey.mutableStatistics stats, 
	      int respondentID ){
	this.answeredQuestions = new java.util.HashSet<Integer>();
	this.questions = questions;
	this.title = title;
	this.respondentID = respondentID;
	this.result = new survey.mutableResult( this.questions.length );
	this.stats = stats;
        this.in = new java.util.Scanner(System.in);
    }

    /* method */
    void displayQuestion( int questionNumber ){
	int response;
	while (true){
	    System.out.println( this.questions[questionNumber - 1] );
	    try{
		response = this.in.nextInt();
		if ( response > 0 && response < 6 ){
		    break;
		} 
		System.out.println( "Reponses must be an integer between 1 and 5");
	    } catch (java.util.InputMismatchException e){
		System.out.println("Reponses must be an integer value");
		this.in.next();
	    }
	    System.out.println("Please enter a legal reponse value");
	    System.out.println();
	}
	this.result.responseValue( questionNumber - 1, response );
	this.answeredQuestions.add(questionNumber);
    }

    void displayPersonalizedQuestion( int questionNumber, boolean personalize ){
	if (personalize){
	    System.out.println("Respondent " + this.respondentID + 
			       ", please answer the following question:");
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
	System.out.println(this.title);
	System.out.println(new String(new char[this.title.length()]).replace("\0", "="));

	for (int i = 0; i < this.questions.length; ++i){
	    this.displayPersonalizedQuestion(i+1, personalize);
	}
	this.submit();
	System.out.println();
    }

    /* fields */
    String[] questions;
    String title;
    java.util.Set<Integer> answeredQuestions;
    int respondentID;
    survey.mutableResult result;
    survey.mutableStatistics stats;
    java.util.Scanner in;
}
