package secondEvaluation;


import java.util.List;

import outputOrganization.OutputSignal;

public class SecondEvaluation {
	private EvaluationTheoryInterface evaluationTheory;
	private String theorySelected;
	private FuzzyInference fuzzyInference;


	public void calculateCogntiveEmoValue(OutputSignal outputEmoSignal){

		/*
		 * Determine evaluation theory
		 */
		theorySelected = outputEmoSignal.getEvaluationTheory();
		if(theorySelected.equals("PAD"))
			evaluationTheory = new PADTheory();
		if(theorySelected.equals("Scherer"))
			evaluationTheory = new SchererTheory();
		 
		/*
		 * Crisp values
		 */
		List<AppraisalDimension> appDimensions = evaluationTheory.getAppraisaDimensionsCrispValues(outputEmoSignal);
		for(AppraisalDimension a: outputEmoSignal.getAppraisalVariables()){
			for(AppraisalDimension b: appDimensions){
				if(a.getName().equals(b.getName())){
					a.setCrispValue(b.getCrispValue());
					break;
				}
			}
		}
		
		/*
		 * Fuzzy operations
		 */
		fuzzyInference = new FuzzyInference(theorySelected);
		fuzzyInference.fuzzifyInput(outputEmoSignal);
		fuzzyInference.doInferenceAndDefuzzify(outputEmoSignal);

		}
	
}
