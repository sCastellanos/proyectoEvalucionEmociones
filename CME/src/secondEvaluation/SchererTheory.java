package secondEvaluation;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

import outputOrganization.OutputSignal;


/**
 * @author Luis-Felipe Rodriguez
 * 
 * This class evaluates the input based on the Scherer dimensions.
 * 
 */
public class SchererTheory implements EvaluationTheoryInterface {

	public List<AppraisalDimension> getAppraisaDimensionsCrispValues(OutputSignal outputEmoSignal){

		List<AppraisalDimension> appDimensions = new ArrayList<AppraisalDimension>();

		AppraisalDimension relevance = new AppraisalDimension("relevance");
		relevance.setCrispValue(calculateRelevance());
		appDimensions.add(relevance); 
		
		AppraisalDimension implication = new AppraisalDimension("implication");
		implication.setCrispValue(calculateImplication());
		appDimensions.add(implication);
		
		AppraisalDimension copingPotential = new AppraisalDimension("copingPotential");
		copingPotential.setCrispValue(calculateCopingPotential());
		appDimensions.add(copingPotential); 
		
		AppraisalDimension normativeSignificance = new AppraisalDimension("normativeSignificance");
		normativeSignificance.setCrispValue(calculateNormativeSignificance());
		appDimensions.add(normativeSignificance);


		return appDimensions;

	}

	private double calculateRelevance(){
		String s = (String)JOptionPane.showInputDialog("Relevance value [-1,1]");
		return Double.parseDouble(s);
	}
	private double calculateImplication(){
		String s = (String)JOptionPane.showInputDialog("Implication value [-1,1]");
		return Double.parseDouble(s);
	}
	private double calculateCopingPotential(){
		String s = (String)JOptionPane.showInputDialog("Coping Potential value [-1,1]");
		return Double.parseDouble(s);
	}
	private double calculateNormativeSignificance(){
		String s = (String)JOptionPane.showInputDialog("Normative Significance value [-1,1]");
		return Double.parseDouble(s);
	}

}
