package secondEvaluation;

import java.util.List;

import outputOrganization.OutputSignal;

import net.sourceforge.jFuzzyLogic.FIS;

public class FuzzyInference {
	private FIS fis;

	private String theorySelected;

	public FuzzyInference(String theorySelected) {
		this.theorySelected = theorySelected;

	}

	/*
	 * Fuzzify inputDimensions
	 */
	public void fuzzifyInput(OutputSignal outputEmoSignal){

		List<AppraisalDimension> appraisalVariables = outputEmoSignal.getAppraisalVariables();

		String file = "fcl/" + theorySelected + ".fcl"; 
		fis = FIS.load(file, true);
		if( fis == null ) { 
			System.err.println("Can't load the file");
			return;
		}
		
		/*
		 * get membership values of each linguistic term of each Input Dimension
		 */
		for(AppraisalDimension a: appraisalVariables){
			fis.setVariable(a.getName(), a.getCrispValue());
			for(LinguisticTerm l: a.getLinguisticTerms())
				l.setMembershipValue(fis.getVariable(a.getName()).getMembership(l.getName()));
		}

		// print the charts of appraisal dimensions
		for(AppraisalDimension a: appraisalVariables){
			fis.getVariable(a.getName()).chart(true);
		}

	}

	public void doInferenceAndDefuzzify(OutputSignal outputEmoSignal){

		List<EmotionDimension> arrayEmotions = outputEmoSignal.getEmotionsList();

		fis.evaluate();

		// membership values of linguistic terms of output variables
		for(EmotionDimension a: arrayEmotions)
			for(LinguisticTerm l: a.getLinguisticTerms())
				l.setMembershipValue(fis.getVariable(a.getName()).getMembership(l.getName()));

		// deffuzified values of output variables (emotions)
		for(EmotionDimension a: arrayEmotions)
			a.setDeffuzifiedValue(fis.getVariable(a.getName()).getLatestDefuzzifiedValue());



		// print the charts of output dimensions (emotions)
		for(EmotionDimension a: arrayEmotions){
			if(a.getDeffuzifiedValue() != 0){
				fis.getVariable(a.getName()).chart(true);
				fis.getVariable(a.getName()).chartDefuzzifier(true);
			}
		}
	}
}
