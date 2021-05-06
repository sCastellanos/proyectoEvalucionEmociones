package outputOrganization;

import internalMemory.AssocLearningParams;
import internalMemory.InternalMemory;
import secondEvaluation.AppraisalDimension;

public class EmotionalSignificance {




	/*
	 * Updates cognitive emotional significances to the input 
	 */
	public void updateCognitiveSignificance(OutputSignal outputEmoSignal){

		String theory = outputEmoSignal.getEvaluationTheory();

		for(AppraisalDimension appVariable: outputEmoSignal.getAppraisalVariables()){
			if(theory.equals("PAD") && appVariable.getName().equals("pleasure")){
				outputEmoSignal.setCognitiveEmoValue(appVariable.getCrispValue());
				break;
			}
			if(theory.equals("Scherer") && appVariable.getName().equals("relevance")){
				outputEmoSignal.setCognitiveEmoValue(appVariable.getCrispValue());
				break;
			}
		}
	}


	/*
	 * Updates intrinsic emotional significances to the input
	 */
	public void updateIntrinsicSignificance(OutputSignal outputEmoSignal, InternalMemory inputRecord){

		double intrinsicValue = inputRecord.getIntrinsicValueOfLastInputOccurrence(outputEmoSignal);
		double cognitiveValue = outputEmoSignal.getCognitiveEmoValue();
		double updatedValue=0;

		System.out.println("Entre intrinsic evaluations");

		if(intrinsicValue == 0){
			System.out.println("Entre IF-0");
			outputEmoSignal.setIntrinsicEmoValue(cognitiveValue);
			return;
		}

		if(intrinsicValue < AssocLearningParams.emo_threshold && cognitiveValue < AssocLearningParams.emo_threshold){
			System.out.println("Entre IF-1");
			updatedValue = (intrinsicValue+cognitiveValue)/2;
			outputEmoSignal.setIntrinsicEmoValue(updatedValue);
			return;
		}

		// we add +1 to the average function in order to let the intrinsic_value to reach and surpass the emo_threshold
		if(intrinsicValue < AssocLearningParams.emo_threshold && cognitiveValue >= AssocLearningParams.emo_threshold){
			System.out.println("Entre IF-2");
			if(intrinsicValue <= 0.9) 
				intrinsicValue += 0.1;
			updatedValue = (intrinsicValue+cognitiveValue)/2;
			outputEmoSignal.setIntrinsicEmoValue(updatedValue);
			return;
		}

		// we multiply the intrinsic value by 4 in order to conduct smooth the reduction
		if(intrinsicValue >= AssocLearningParams.emo_threshold && cognitiveValue < AssocLearningParams.emo_threshold){
			System.out.println("Entre IF-3");
			intrinsicValue *= 4;
			updatedValue = (intrinsicValue+cognitiveValue)/5;
			outputEmoSignal.setIntrinsicEmoValue(updatedValue);
			return;
		}

		// we add +1 to the average function to reinforce the highly emotional significance of the input 
		if(intrinsicValue >= AssocLearningParams.emo_threshold && cognitiveValue >= AssocLearningParams.emo_threshold){
			System.out.println("Entre IF-4");
			updatedValue = (intrinsicValue+cognitiveValue)/2;
			outputEmoSignal.setIntrinsicEmoValue(updatedValue);
			return;
		}

	}



}
