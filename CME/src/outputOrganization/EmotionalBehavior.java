package outputOrganization;

import java.util.ArrayList;
import java.util.List;

public class EmotionalBehavior {

	private List<String> fastReactions = new ArrayList<String>();
	private List<String> actionTendencies = new ArrayList<String>();

	public EmotionalBehavior() {
		fastReactions.add("freeze");
		fastReactions.add("protect");

		actionTendencies.add("withdrawal");
		actionTendencies.add("approach");
	}
	
	

	/*
	 * Fast reactions
	 */
	public void calculateFastReaction(OutputSignal outputEmoSignal){

		outputEmoSignal.setFastReaction(fastReactions.get(0));
		
	}


	/*
	 * Action tendencies
	 */
	public void calculateActionTendency(OutputSignal outputEmoSignal){
		outputEmoSignal.setActionTendency(actionTendencies.get(0));
	}

}
