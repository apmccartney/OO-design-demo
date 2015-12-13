class test {
    public static void main(String[] args){
	/* Design the survey by specifying a few questions */
	survey.builder mySB = new survey.builder();
	mySB.addQuestion("On a scale from one to five, how would you rate the course material?");
	mySB.addQuestion("On a scale from one to five, how would you rate the course instructor?");
	mySB.addQuestion("On a scale from one to five, how would you rate the course overall?");


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
