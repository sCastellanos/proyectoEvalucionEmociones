package secondEvaluation;

import java.util.List;

import outputOrganization.OutputSignal;

	/*
	 * All theories used in the second evaluation implement this
	 */

public interface EvaluationTheoryInterface {
	public List<AppraisalDimension> getAppraisaDimensionsCrispValues(OutputSignal outputEmoSignal);
}
