package survey;
public class mutableResult implements result {
    /* constructor */
    mutableResult(int nQuestions){
	this.completed = false;
	this.responses = new int[nQuestions];
    }

    /* methods */
    public boolean wasCompleted(){ 
	return this.completed; 
    }

    public void wasCompleted(boolean completion){ 
	this.completed = completion; 
    }

    public int responseValue(int index){ 
	return this.responses[index]; 
    }

    public void responseValue(int index, int value){
	this.responses[index] = value;
    }

    /* fields */
    private boolean completed;
    private int[] responses;
}
