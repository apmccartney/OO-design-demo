class test {
    public static void main(String[] args){
	/* Design the survey by specifying a few questions */
	survey.builder mySB = new survey.builder();
	mySB.addQuestion("What is 1+1?");
	mySB.addQuestion("What is 1+2?");
	System.out.println( mySB.numQuestions() + " questions added so far");
	System.out.println("Survey so far:");
	mySB.printQuestions();
	mySB.removeQuestion(2);
	System.out.println("Survey after removing Question 2:");
	mySB.printQuestions();
	System.out.println( mySB.numQuestions() + " questions currently");
	System.out.println();
	mySB.addQuestion("What is 1+3?");
	mySB.addQuestion("What is 1+4?");
	System.out.println("Final draft survey questions:");
	mySB.printQuestions();
	System.out.println( mySB.numQuestions() + " questions in final draft");
	System.out.println();

	/* Once we're done adding questions, 
	 * the builder uses the survey to make a new survey administrator 
	 */
	survey.administrator mySA = mySB.makeSurvey();

	/* The administrator makes three instances of the survey and 
	 * a statistics object to moniter to responses
	 */ 
	survey.instance survey0 = mySA.getSurvey();
	survey.instance survey1 = mySA.getSurvey();
	survey.instance survey2 = mySA.getSurvey();
	survey.statistics mySS = mySA.getStats();

	/* We conduct the first and third instantiated surveys (corresponding to 
	 * respondentID 1 and 3, respectively)
	 */
	survey0.conduct(false);
	survey2.conduct(true);

	/* We examine the survey responses */
	mySS.displayResults();
	mySS.displayQuestionStats(1);
	System.out.println("Highest rated question: " + mySS.highestRatedQuestion());
	System.out.println("Lowest rated question: " + mySS.lowestRatedQuestion());

	System.out.println();

	/* We conduct the second instantiated survey (corresponding to 
	 * respondentID 2) and observe any changes in the displayed statistics
	 */
	survey1.conduct(false);
	mySS.displayResults();
	mySS.displayQuestionStats(1);
	System.out.println("Highest rated question: " + mySS.highestRatedQuestion());
	System.out.println("Lowest rated question: " + mySS.lowestRatedQuestion());

    }
}
