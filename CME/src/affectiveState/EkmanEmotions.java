package affectiveState;

import outputOrganization.OutputSignal;

public class EkmanEmotions implements EmotionUpdateTheoryInterface {

	@Override
	public EmotionSignal updateEmoState(OutputSignal outputEmoSignal, EmotionSignal currentEmotion) {
		
		EmotionSignal updatedEmotion = new EmotionSignal();
		
		

		updatedEmotion.setEmotion("Happy-Ekman");
		updatedEmotion.setIntensity("low");

		return updatedEmotion;
	}

}
