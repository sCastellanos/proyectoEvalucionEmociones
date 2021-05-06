package testing;

import affectiveState.EmotionalState;
import affectiveState.MoodState;
import internalMemory.InternalMemory;
import outputOrganization.EmotionalSignificance;
import outputOrganization.FastOutputXML;
import outputOrganization.OutputGUI;
import outputOrganization.OutputSignal;
import outputOrganization.EmotionalBehavior;
import outputOrganization.CognitiveOutputXML;
import secondEvaluation.AppraisalDimension;
import secondEvaluation.LinguisticTerm;
import secondEvaluation.SecondEvaluation;
import userInput.EvaluationParametersGUI;
import userInput.IncomingInputInterface;
import userInput.MultimodalInputGUI;
import firstEvaluation.FirstEvaluation;


/**
 * Always running and waiting for inputs from the MultiModalInput GUI
 */


public class DataFlow implements Runnable {

	private MultimodalInputGUI multimodalInput;
	private EvaluationParametersGUI evaluationParameters;
	private EmotionalState emotionalState;
	private MoodState moodState;
	private FirstEvaluation firstEvaluation;
	private SecondEvaluation secondEvaluation;
	private EmotionalBehavior emotionalBehavior;
	private OutputGUI outputGUI;
	private CognitiveOutputXML cognitiveOutputXML;
	private FastOutputXML fastOutputXML;
	private OutputSignal outputEmoSignal;
	private EmotionalSignificance emotionalSignificance;
	private IncomingInputInterface input;
	private InternalMemory internalMemory;


	public DataFlow() {

		/*  OUTPUT */
		outputGUI = new OutputGUI();
		cognitiveOutputXML = new CognitiveOutputXML();
		fastOutputXML = new FastOutputXML();

		/*  INPUT */
		evaluationParameters = new EvaluationParametersGUI();
		multimodalInput = new MultimodalInputGUI(evaluationParameters);
		new Thread(multimodalInput).start();

		/*
		 * 	COMPONENTS OF THE CME 
		 */
		firstEvaluation = new FirstEvaluation();
		secondEvaluation = new SecondEvaluation();
		emotionalBehavior = new EmotionalBehavior();
		emotionalSignificance = new EmotionalSignificance();

		emotionalState = new EmotionalState();
		moodState = new MoodState();
		internalMemory = new InternalMemory();

	}

	@Override
	public void run() {
		while(true){
			synchronized (multimodalInput) {
				try {
					multimodalInput.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			dataFlow();
		} 
	}


	private void dataFlow(){

		/*
		 * Retrieve the input
		 */
		input = multimodalInput.getInput();

		/* 
		 * Create outputSignal
		 */ 
		outputEmoSignal = new OutputSignal();
		outputEmoSignal.setInput(input);
		outputEmoSignal.setInputId(input.getIdentifier());
		outputEmoSignal.setEvaluationTheory(evaluationParameters.getEvaluationTheory());
		outputEmoSignal.setEmotionGenerationTheory(evaluationParameters.getEmotionGenerationTheory());
		
		
		for(AppraisalDimension a: evaluationParameters.getListAppraisaVariables()){
			System.out.println("Da: " + a.getName());
			System.out.println("Da: " + a.getCrispValue());
			for(LinguisticTerm t: a.getLinguisticTerms()){
				System.out.println("Da: " + t.getName());
				System.out.println("Da: " + t.getMembershipValue());
			}
				
		}
		
		outputEmoSignal.setAppraisalVariables(evaluationParameters.getListAppraisaVariables());
		outputEmoSignal.setEmotionsList(evaluationParameters.getListEmotions());
		
		/* 
		 * Evaluate intrinsic emotional significance of input
		 */
		outputEmoSignal.setExceedsThreshold(firstEvaluation.isInputHighlyEmotional(outputEmoSignal, internalMemory));
		System.out.println("Is the input highly emotional? " + outputEmoSignal.isExceedsThreshold());

		/* 
		 * If input is highly emotional
		 */
		if(outputEmoSignal.isExceedsThreshold()){		
			emotionalBehavior.calculateFastReaction(outputEmoSignal);
			fastOutputXML.generateXML(outputEmoSignal);
			outputGUI.showGUI(outputEmoSignal);
		} 

		/* 
		 * Whether the input is highly emotional or not, it goes through the second evaluation
		 */
		secondEvaluation.calculateCogntiveEmoValue(outputEmoSignal);


		emotionalState.updateEmoState(outputEmoSignal);
		moodState.updateMoodState(outputEmoSignal);
		emotionalBehavior.calculateActionTendency(outputEmoSignal);
		emotionalSignificance.updateCognitiveSignificance(outputEmoSignal);
		emotionalSignificance.updateIntrinsicSignificance(outputEmoSignal, internalMemory);

		System.out.println("Intrinsic value: " + outputEmoSignal.getIntrinsicEmoValue());
		System.out.println("Cognitive Value: " + outputEmoSignal.getCognitiveEmoValue());


		/*
		 * Final steps (save input, generate outputXML, show results to user)
		 */
		internalMemory.recordInput(outputEmoSignal);
		cognitiveOutputXML.generateXML(outputEmoSignal);
		outputGUI.showGUI(outputEmoSignal);

	}


	public static void main(String[] args) {
		DataFlow dataFlow = new DataFlow();
		new Thread(dataFlow).start();
	}

}








