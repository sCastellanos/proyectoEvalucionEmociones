package secondEvaluation;

import java.util.ArrayList;
import java.util.List;


/**
 * @author Luis-Felipe Rodriguez
 * 
 * This class represents an appraisal variable and its properties 
 *
 */
public class AppraisalDimension {
	
	private String name;
	private double crispValue;
	private List<LinguisticTerm> linguisticTerms;

	// Constructor
	public AppraisalDimension(String name) {
		this.name = name;
		linguisticTerms = new ArrayList<LinguisticTerm>();
	}
	
	/**
	 * @return the crispValue
	 */
	public double getCrispValue() {
		return crispValue;
	}
	/**
	 * @param crispValue the crispValue to set
	 */
	public void setCrispValue(double crispValue) {
		this.crispValue = crispValue;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @return the arrayLinguisticTerms
	 */
	public List<LinguisticTerm> getLinguisticTerms() {
		return linguisticTerms;
	}
	/**
	 * @param arrayLinguisticTerms the arrayLinguisticTerms to set
	 */
	public void addLinguisticTerm(LinguisticTerm linguisticTerm) {
		linguisticTerms.add(linguisticTerm);
	}
	
	
	
	@Override
	public boolean equals(Object o) {
		if((o instanceof AppraisalDimension) && (((AppraisalDimension)o).name == name)){
			return true;
		}else{
			return false;
		}
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return name;
	}
	
}
