package affectiveState;

import outputOrganization.OutputSignal;

public class SchererEmotions implements EmotionUpdateTheoryInterface {

	@Override
	public EmotionSignal updateEmoState(OutputSignal outputEmoSignal, EmotionSignal currentEmotion) {
		
		EmotionSignal updatedEmotion = new EmotionSignal();
		
		updatedEmotion.setEmotion("Happy-Scherer");
		updatedEmotion.setIntensity("low");


		return updatedEmotion;
	}
}
