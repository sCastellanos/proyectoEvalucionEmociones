package outputOrganization;

import java.util.List;

import affectiveState.EmotionSignal;
import secondEvaluation.AppraisalDimension;
import secondEvaluation.EmotionDimension;
import userInput.IncomingInputInterface;


public class OutputSignal{

	// Properties regarding the incoming stimuli
	private String inputId;					// Identifier of the trigger
	private IncomingInputInterface input;
	private double intrinsicEmoValue;		// intrinsic emotional value of input
	private double cognitiveEmoValue;		// cognitive emotional value of input
	private boolean exceedsThreshold;		// indicates if the input is highly emotional

	private EmotionSignal emoState;			// Agent's emotional state
	private String moodState;			// Agent's mood state
	private String fastReaction;		// Used when stimuli is highly emotional
	private String actionTendency;		// Action tendencies
	
	private String evaluationTheory;
	private String emotionGenerationTheory;
	private List<AppraisalDimension> appraisalVariables;
	private List<EmotionDimension> emotionsList;
	
	
	
	/**
	 * @return the typeOfInput
	 */
	public IncomingInputInterface getInput() {
		return input;
	}
	/**
	 * @param typeOfInput the typeOfInput to set
	 */
	public void setInput(IncomingInputInterface input) {
		this.input = input;
	}
	/**
	 * @return the triggerId
	 */
	public String getInputId() {
		return inputId;
	}
	/**
	 * @param triggerId the triggerId to set
	 */
	public void setInputId(String inputId) {
		this.inputId = inputId;
	}
	/**
	 * @return the emoValue
	 */
	public double getIntrinsicEmoValue() {
		return intrinsicEmoValue;
	}
	/**
	 * @param emoValue the emoValue to set
	 */
	public void setIntrinsicEmoValue(double emoValue) {
		this.intrinsicEmoValue = emoValue;
	}
	/**
	 * @return the cognitiveEmoValue
	 */
	public double getCognitiveEmoValue() {
		return cognitiveEmoValue;
	}
	/**
	 * @param cognitiveEmoValue the cognitiveEmoValue to set
	 */
	public void setCognitiveEmoValue(double cognitiveEmoValue) {
		this.cognitiveEmoValue = cognitiveEmoValue;
	}
	/**
	 * @return the exceedsThreshold
	 */
	public boolean isExceedsThreshold() {
		return exceedsThreshold;
	}
	/**
	 * @param exceedsThreshold the exceedsThreshold to set
	 */
	public void setExceedsThreshold(boolean exceedsThreshold) {
		this.exceedsThreshold = exceedsThreshold;
	}
	/**
	 * @return the emoState
	 */
	public EmotionSignal getEmoState() {
		return emoState;
	}
	/**
	 * @param emoState the emoState to set
	 */
	public void setEmoState(EmotionSignal emoState) {
		this.emoState = emoState;
	}
	/**
	 * @return the moodState
	 */
	public String getMoodState() {
		return moodState;
	}
	/**
	 * @param moodState the moodState to set
	 */
	public void setMoodState(String moodState) {
		this.moodState = moodState;
	}
	/**
	 * @return the fastReaction
	 */
	public String getFastReaction() {
		return fastReaction;
	}
	/**
	 * @param fastReaction the fastReaction to set
	 */
	public void setFastReaction(String fastReaction) {
		this.fastReaction = fastReaction;
	}
	/**
	 * @return the actionTendency
	 */
	public String getActionTendency() {
		return actionTendency;
	}
	/**
	 * @param actionTendency the actionTendency to set
	 */
	public void setActionTendency(String actionTendency) {
		this.actionTendency = actionTendency;
	}
	/**
	 * @return the evaluationTheoryUsed
	 */
	public String getEvaluationTheory() {
		return evaluationTheory;
	}
	/**
	 * @param evaluationTheoryUsed the evaluationTheoryUsed to set
	 */
	public void setEvaluationTheory(String evaluationTheory) {
		this.evaluationTheory = evaluationTheory;
	}
	/**
	 * @return the emotionGenerationTheory
	 */
	public String getEmotionGenerationTheory() {
		return emotionGenerationTheory;
	}
	/**
	 * @param emotionGenerationTheory the emotionGenerationTheory to set
	 */
	public void setEmotionGenerationTheory(String emotionGenerationTheory) {
		this.emotionGenerationTheory = emotionGenerationTheory;
	}
	/**
	 * @return the inputDimensionsArray
	 */
	public List<AppraisalDimension> getAppraisalVariables() {
		return appraisalVariables;
	}
	/**
	 * @param inputDimensionsArray the inputDimensionsArray to set
	 */
	public void setAppraisalVariables(List<AppraisalDimension> listAppraisalVariables) {
		this.appraisalVariables = listAppraisalVariables;
	}
	/**
	 * @return the outputDimensionsArray
	 */
	public List<EmotionDimension> getEmotionsList() {
		return emotionsList;
	}
	/**
	 * @param outputDimensionsArray the outputDimensionsArray to set
	 */
	public void setEmotionsList(List<EmotionDimension> listEmotions) {
		this.emotionsList = listEmotions;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return inputId;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object o) {
		if((o instanceof OutputSignal) && (((OutputSignal)o).inputId == inputId)){
			return true;
		}else{
			return false;
		}

	}		
}
