class test {
    public static void main(String[] args){
	String[] questions = new String[2];
	questions[0] = "What 1+1?";
	questions[1] = "What 1+2?";
	survey.administrator mySA = new survey.administrator(questions);
	survey.statistics mySS = mySA.getStats();
	survey.instance survey0 = mySA.getSurvey();
	survey.instance survey1 = mySA.getSurvey();
	survey.instance survey2 = mySA.getSurvey();
	survey0.conduct(false);
	survey2.conduct(true);
	mySS.displayResults();
	mySS.displayQuestionStats(1);
	System.out.println("Highest rated question: " + mySS.highestRatedQuestion());
	System.out.println("Lowest rated question: " + mySS.lowestRatedQuestion());
    }
}
