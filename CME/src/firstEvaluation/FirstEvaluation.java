package firstEvaluation;

import java.util.List;
import internalMemory.AssocLearningParams;
import internalMemory.InternalMemory;
import outputOrganization.OutputSignal;

/*
 * Determines the intrinsic emotional significance of the input.
 *  
 */

public class FirstEvaluation{

	double emoValue;
	

	public boolean isInputHighlyEmotional(OutputSignal outputEmoSignal, InternalMemory internalMemory){
		
		// Check if input is in records
		if( !internalMemory.isInputInRecords(outputEmoSignal)){
			return false;
		}

		//  check if the input is itself highly emotional
		if(internalMemory.getIntrinsicValueOfLastInputOccurrence(outputEmoSignal) >= AssocLearningParams.emo_threshold){
			return true;
		}

		// If not, check if the input precedes highly emotional stimuli
		int count=0;
		List<OutputSignal> inputRecord = internalMemory.getElementsFollowingInput(outputEmoSignal);
		for(OutputSignal o: inputRecord)
			if( o.getIntrinsicEmoValue() >= AssocLearningParams.emo_threshold)
				count++;
		if(count >= AssocLearningParams.assoc_threshold){
			return true;
		}

		// In case the input is in records but is not highly emotional and does not precede enough highly emotional stimuli
		return false;


	}



}
