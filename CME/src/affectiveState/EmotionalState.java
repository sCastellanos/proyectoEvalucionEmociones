package affectiveState;

import outputOrganization.OutputSignal;

public class EmotionalState {



	private EmotionUpdateTheoryInterface emotionUpdateTheory;
	private EmotionSignal currentEmotion;

	public void updateEmoState(OutputSignal outputEmoSignal){

		// Choose the updating theory
		if(outputEmoSignal.getEmotionGenerationTheory().equals("Ekman"))
			emotionUpdateTheory = new EkmanEmotions();
		if(outputEmoSignal.getEmotionGenerationTheory().equals("Scherer"))
			emotionUpdateTheory = new SchererEmotions();

		// update current emoState 
		currentEmotion = emotionUpdateTheory.updateEmoState(outputEmoSignal, currentEmotion);
		outputEmoSignal.setEmoState(currentEmotion);

	}




}
