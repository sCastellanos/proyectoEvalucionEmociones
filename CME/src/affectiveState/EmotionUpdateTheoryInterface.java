package affectiveState;

import outputOrganization.OutputSignal;


public interface EmotionUpdateTheoryInterface {
	public EmotionSignal updateEmoState(OutputSignal outputEmoSignal, EmotionSignal currentEmotion);

}
