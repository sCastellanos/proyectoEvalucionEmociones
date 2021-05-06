package internalMemory;

import java.util.ArrayList;
import java.util.List;
import outputOrganization.OutputSignal;


/*
 * 	Maintains a record of all inputs perceived by the agent.
 */
public class InternalMemory {

	private List<OutputSignal> inputRecord = new ArrayList<OutputSignal>();
	
	/*
	 * Stores the perceived input in the Records Array
	 */
	public void recordInput(OutputSignal outputEmoSignal){
		inputRecord.add(outputEmoSignal);
		System.out.println("[InputRecord] RecordArray after adding the current input: \n" + inputRecord);
	}


	/*
	 * 
	 * Utility functions
	 * 
	 */

	// Check if the perceived input is in the RecordArray
	public boolean isInputInRecords(OutputSignal o){
		return inputRecord.contains(o);
	}

	// Returns the intrinsic emotional value of last occurrence of input
	public double getIntrinsicValueOfLastInputOccurrence(OutputSignal o){
		int index = inputRecord.lastIndexOf(o);
		if(index > -1)
			return inputRecord.get(index).getIntrinsicEmoValue();
		else
			return 0;
	}
	
	// Returns the number of highly emotional input following the input
	public List<OutputSignal> getElementsFollowingInput(OutputSignal o){
		List<OutputSignal> assocArray = new ArrayList<OutputSignal>();
		for(int i=0; i < inputRecord.size()-1; i++){ 	// we go through the loop inputRecord.size()-1 times because no element follows the last item
			if(o.equals(inputRecord.get(i)))
				assocArray.add(inputRecord.get(i+1));
		}
		return assocArray;
	}

	
	
	
	
	
	
	
	// Returns the records of a given input
	public List<OutputSignal> getRecordOfInput(OutputSignal outputEmoSignal){
		List<OutputSignal> recordOfInput = new ArrayList<OutputSignal>();
		for(OutputSignal o: inputRecord)
			if(outputEmoSignal.equals(o))
				recordOfInput.add(o);
		return recordOfInput;
	}

	// Returns the highest intrinsic emotional value stored in the RecordArray of the input
	public double getHighestIntrinsicEmoValue(OutputSignal outputEmoSignal){
		double emoValue = 0;
		for(OutputSignal o: inputRecord)
			if(outputEmoSignal.equals(o))
				if(o.getIntrinsicEmoValue() > emoValue)
					emoValue = o.getIntrinsicEmoValue();
		return emoValue;
	}
	
	

	/*
	 * Returns all highly emotional stimuli that immediately follows the input
	 */
/*	public List<OutputSignal> getHighlyEmoStimuliFollowingTheInput(OutputSignal o){

		List<OutputSignal> assocArray = new ArrayList<OutputSignal>();
		Iterator<OutputSignal> iterator = inputRecord.iterator();
		OutputSignal pre;
		OutputSignal post;

		while(iterator.hasNext()){
			pre = iterator.next();
			if(pre.equals(o)){
				while(iterator.hasNext()){
					post = iterator.next();
					if(post != pre && post.getIntrinsicEmoValue() >= AssocLearningParams.emo_threshold){
						assocArray.add(post);
						break;
					} else if(post != pre && post.getIntrinsicEmoValue() < AssocLearningParams.emo_threshold){
						break;
					}
				}
			}
		}
		return assocArray;
	}*/





}
