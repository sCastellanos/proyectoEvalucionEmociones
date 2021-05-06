package secondEvaluation;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

import outputOrganization.OutputSignal;

/**
 * @author Luis-Felipe Rodriguez
 * 
 * This class evaluates the input based on the PAD dimensions.
 * 
 */
public class PADTheory implements EvaluationTheoryInterface {
	
	public List<AppraisalDimension> getAppraisaDimensionsCrispValues(OutputSignal outputEmoSignal){
		
		List<AppraisalDimension> appDimensions = new ArrayList<AppraisalDimension>();
		
		AppraisalDimension pleasure = new AppraisalDimension("pleasure");
		pleasure.setCrispValue(calculatePleasure());
		appDimensions.add(pleasure); 
		
		AppraisalDimension arousal = new AppraisalDimension("arousal");
		arousal.setCrispValue(calculateArousal());
		appDimensions.add(arousal); 
		
		AppraisalDimension dominance = new AppraisalDimension("dominance");
		dominance.setCrispValue(calculateDominance());
		appDimensions.add(dominance); 
		
		return appDimensions;
		
	}

	private double calculatePleasure(){
		String s = (String)JOptionPane.showInputDialog("Pleasure value [-1,1]");
		return Double.parseDouble(s);
	}
	
	private double calculateArousal(){
		String s = (String)JOptionPane.showInputDialog("Arousal value [-1,1]");
		return Double.parseDouble(s);
	}
	
	private double calculateDominance(){
		String s = (String)JOptionPane.showInputDialog("Dominance value [-1,1]");
		return Double.parseDouble(s);
	}
	
}
