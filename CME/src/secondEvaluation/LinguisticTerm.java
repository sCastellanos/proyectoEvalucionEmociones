package secondEvaluation;

public class LinguisticTerm {
	private String name;
	private double membershipValue;
	
	public LinguisticTerm(String name) {
		this.name = name;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the membershipValue
	 */
	public double getMembershipValue() {
		return membershipValue;
	}

	/**
	 * @param membershipValue the membershipValue to set
	 */
	public void setMembershipValue(double membershipValue) {
		this.membershipValue = membershipValue;
	}
	
}
