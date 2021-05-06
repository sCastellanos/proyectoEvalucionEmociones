package secondEvaluation;

import java.util.ArrayList;
import java.util.List;


/**
 * @author Luis-Felipe Rodriguez
 * 
 * This class represents an emotion activated by an input and its properties 
 *
 */
public class EmotionDimension {
	
	private String name;
	private double deffuzifiedValue;
	private List<LinguisticTerm> linguisticTerms;

	
	// Constructor
	public EmotionDimension(String name) {
		this.name = name;
		linguisticTerms = new ArrayList<LinguisticTerm>();
	}
	
	/**
	 * @return the crispValue
	 */
	public double getDeffuzifiedValue() {
		return deffuzifiedValue;
	}
	/**
	 * @param crispValue the crispValue to set
	 */
	public void setDeffuzifiedValue(double deffuzifiedValue) {
		this.deffuzifiedValue = deffuzifiedValue;
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
		if((o instanceof EmotionDimension) && (((EmotionDimension)o).name == name)){
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
