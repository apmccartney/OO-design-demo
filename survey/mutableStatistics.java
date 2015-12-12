package survey;
class mutableStatistics implements statistics {
    /* constructor */
    mutableStatistics( int nQuestions ){
	this.nQuestions = nQuestions;
	this.results = new java.util.HashMap<Integer, survey.result>();
    }

    /* methods */
    public void collect(int respondentID, survey.result result){
	this.results.put(respondentID, result);
    }

    public void displayResults(){
	System.out.print("RespondentId   ");
	for ( int i = 0; 
	      i < this.nQuestions; 
	      ++i ) {
	    System.out.format( "%5s", "Q" + (i+1) );
	}
	System.out.println();
	for ( java.util.Map.Entry<Integer, survey.result> entry : this.results.entrySet() ){
	    System.out.format( "%12d", entry.getKey() );
	    System.out.print( "   ");
	    for ( int resultIndex = 0;
		  resultIndex < this.nQuestions;
		  ++resultIndex ){
		System.out.format( "%5s", entry.getValue().responseValue(resultIndex) );
	    }
	    System.out.println();
	}
	System.out.println();
    }

    public void displayQuestionStats(int questionNumber){
	if ( (questionNumber < 1) ||
	     (questionNumber > this.nQuestions) ){
	    //throw new java.lang.Exception();
	}
	System.out.print("RespondentId   ");
	System.out.format( "%5s", "Q" + questionNumber );
	System.out.println();
	for ( java.util.Map.Entry<Integer, survey.result> entry : this.results.entrySet() ){
	    System.out.format( "%13d", entry.getKey() );
	    System.out.print( "  ");
	    System.out.format( "%5s", entry.getValue().responseValue(questionNumber - 1) );
	    System.out.println();
	}
	System.out.println();
    }

    public int highestRatedQuestion(){	
	int[] reduction = new int[this.nQuestions];
	for (survey.result result : this.results.values()){
	    for (int i = 0; i < this.nQuestions; ++i){
		reduction[i] += result.responseValue(i);
	    }
	}
	int hrqIndex = -1;
	int lowestReduction = Integer.MIN_VALUE;
	for (int i = 0; i < this.nQuestions; ++i){
	    if ( reduction[i] >= lowestReduction ){
		lowestReduction = reduction[i];
		hrqIndex = i;
	    }
	}
	return hrqIndex + 1;
    }

    public int lowestRatedQuestion(){
	int[] reduction = new int[this.nQuestions];
	for (survey.result result : this.results.values()){
	    for (int i = 0; i < this.nQuestions; ++i){
		reduction[i] += result.responseValue(i);
	    }
	}
	int lrqIndex = -1;
	int lowestReduction = Integer.MAX_VALUE;
	for (int i = 0; i < this.nQuestions; ++i){
	    if ( reduction[i] <= lowestReduction ){
		lowestReduction = reduction[i];
		lrqIndex = i;
	    }
	}
	return lrqIndex + 1;
    }
    
    /* fields */
    private final int nQuestions;
    private java.util.Map<Integer, survey.result> results; 
}
