package outputOrganization;

import java.awt.Color;
import java.awt.Font;
import java.text.DecimalFormat;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import secondEvaluation.AppraisalDimension;
import secondEvaluation.LinguisticTerm;
import secondEvaluation.EmotionDimension;
import userInput.ActionInputSignal;
import userInput.EnvEventInputSignal;
import userInput.ObjectInputSignal;

/*
 * Shows the system output
 */

public class OutputGUI{


	public void showGUI(OutputSignal outputEmoSignal){

		JFrame frame = new JFrame("System Output");
		frame.getContentPane().setLayout(null);
		//Border blackline = BorderFactory.createLineBorder(Color.black);

		DecimalFormat df = new DecimalFormat("#.##");

		/*
		 * 
		 * LEFT PANEL: DIMENSIONS
		 * 
		 */

		JPanel panelLeft = new JPanel();	
		panelLeft.setLayout(null);
		panelLeft.setBackground(Color.WHITE);
		panelLeft.setBounds(10, 10, 380, 555);
		panelLeft.setBorder(BorderFactory.createLineBorder(Color.black));
		frame.getContentPane().add(panelLeft);

		// Input information
		Font font = new Font("Helvetica", Font.BOLD, 14	);
		JLabel inputInfo = new JLabel("Input Info");
		inputInfo.setFont(font);
		inputInfo.setBounds(10, 20, 150, 20);
		panelLeft.add(inputInfo);

		// Input ID
		JLabel inputId = new JLabel("Input ID:");
		inputId.setBounds(10, 40, 100, 20);
		panelLeft.add(inputId);
		JLabel inputIdR = new JLabel(outputEmoSignal.getInputId());
		inputIdR.setBounds(110, 40, 100, 20);
		panelLeft.add(inputIdR);

		// Input Type
		String inputTypeString = null;
		if(outputEmoSignal.getInput() instanceof ActionInputSignal)
			inputTypeString = "Action";
		if(outputEmoSignal.getInput() instanceof EnvEventInputSignal)
			inputTypeString = "Environmental Event";
		if(outputEmoSignal.getInput() instanceof ObjectInputSignal)
			inputTypeString = "Object"; 
		JLabel inputType = new JLabel("Input type:");
		inputType.setBounds(10, 60, 100, 20);
		panelLeft.add(inputType);
		JLabel inputTypeR = new JLabel(inputTypeString);
		inputTypeR.setBounds(110, 60, 150, 20);
		panelLeft.add(inputTypeR);

		// Exceeds threshold
		JLabel exceedsThreshold = new JLabel("Exceeds threshold:");
		exceedsThreshold.setBounds(10, 80, 160, 20);
		panelLeft.add(exceedsThreshold);
		JLabel exceedsThresholdR = new JLabel(outputEmoSignal.isExceedsThreshold()+"");
		exceedsThresholdR.setBounds(180, 80, 100, 20);
		panelLeft.add(exceedsThresholdR);

		// Intrinsic significance
		JLabel intrinsicSig = new JLabel("Intrinsic significance:");
		intrinsicSig.setBounds(10, 100, 160, 20);
		panelLeft.add(intrinsicSig);
		JLabel intrinsicSigR = new JLabel(df.format(outputEmoSignal.getIntrinsicEmoValue()));
		intrinsicSigR.setBounds(180, 100, 100, 20);
		panelLeft.add(intrinsicSigR);

		// Cognitive significance
		JLabel cognitiveSig = new JLabel("Cognitive significance:");
		cognitiveSig.setBounds(10, 120, 160, 20);
		panelLeft.add(cognitiveSig);
		JLabel cognitiveSigR = new JLabel(df.format(outputEmoSignal.getCognitiveEmoValue()));
		cognitiveSigR.setBounds(180, 120, 100, 20);
		panelLeft.add(cognitiveSigR);

		// Appraisal dimensions results
		JLabel emoSignificance = new JLabel("Appraisal Result");
		emoSignificance.setFont(font);
		emoSignificance.setBounds(10, 160, 150, 20);
		panelLeft.add(emoSignificance);

		List<AppraisalDimension> appraisalDimensions = outputEmoSignal.getAppraisalVariables();
		int offset = 180;
		for(AppraisalDimension i: appraisalDimensions){
			JLabel label = new JLabel(i.getName());
			label.setBounds(10, offset, 100, 20);
			JLabel labelR = new JLabel(df.format(i.getCrispValue()));
			labelR.setBounds(110, offset, 50, 20);
			panelLeft.add(label);
			panelLeft.add(labelR);
			offset += 15;
			List<LinguisticTerm> linguisticTermsArray = i.getLinguisticTerms();
			for(LinguisticTerm t: linguisticTermsArray){
				if(t.getMembershipValue() != 0){
					JLabel labelB = new JLabel(t.getName());
					labelB.setBounds(20, offset, 100, 20);
					JLabel labelBR = new JLabel(df.format(t.getMembershipValue()));
					labelBR.setBounds(110, offset, 50, 20);
					panelLeft.add(labelB);
					panelLeft.add(labelBR);
					offset += 15;
				}
			}
			offset += 20;
		}


		// Active emotions
		JLabel emoDerived = new JLabel("Active Emotions");
		emoDerived.setFont(font);
		emoDerived.setBounds(210, 160, 150, 20);
		panelLeft.add(emoDerived);

		List<EmotionDimension> emotionDimensions = outputEmoSignal.getEmotionsList();

		offset = 180;
		for(EmotionDimension i: emotionDimensions){
			if(i.getDeffuzifiedValue() != 0){
				JLabel label = new JLabel(i.getName());
				label.setBounds(210, offset, 100, 20);
				JLabel labelR = new JLabel(df.format(i.getDeffuzifiedValue()));
				labelR.setBounds(310, offset, 50, 20);
				panelLeft.add(label);
				panelLeft.add(labelR);
				offset += 15;
				List<LinguisticTerm> linguisticTermsArray = i.getLinguisticTerms();
				for(LinguisticTerm t: linguisticTermsArray){
					if(t.getMembershipValue() != 0){
						JLabel labelB = new JLabel(t.getName());
						labelB.setBounds(220, offset, 100, 20);
						JLabel labelBR = new JLabel(df.format(t.getMembershipValue()));
						labelBR.setBounds(310, offset, 50, 20);
						panelLeft.add(labelB);
						panelLeft.add(labelBR);
						offset += 15;
					}
				}
				offset += 10;
			}
		}






		/*
		 * 
		 * RIGHT PANEL: EXTRA INFORMATION
		 * 
		 */
		JPanel panelRight = new JPanel();	
		panelRight.setLayout(null);
		panelRight.setBounds(405, 10, 280, 555);
		panelRight.setBackground(Color.WHITE);
		panelRight.setBorder(BorderFactory.createLineBorder(Color.black));
		frame.getContentPane().add(panelRight);

		JLabel agentInfo = new JLabel("Agent's affective condition");
		agentInfo.setFont(font);
		agentInfo.setBounds(10, 20, 200, 20);
		panelRight.add(agentInfo);
		
		// Agent's emotional state
		JLabel agentEmo = new JLabel("Agent Emotion:");
		agentEmo.setBounds(10, 40, 250, 20);
		panelRight.add(agentEmo);
		JLabel agentEmoR = new JLabel(outputEmoSignal.getEmoState().getEmotion());
		agentEmoR.setBounds(30, 55, 230, 20);
		panelRight.add(agentEmoR);


		// Agent's mood state
		JLabel agentMood = new JLabel("Agent Mood:");
		agentMood.setBounds(10, 75, 250, 20);
		panelRight.add(agentMood);
		JLabel agentMoodR = new JLabel(outputEmoSignal.getMoodState());
		agentMoodR.setBounds(30, 90, 230, 20);
		panelRight.add(agentMoodR);

		// Agent's action tendency
		JLabel actionTendency = new JLabel("Action tendency:");
		actionTendency.setBounds(10, 110, 250, 20);
		panelRight.add(actionTendency);
		JLabel actionTendencyR = new JLabel(outputEmoSignal.getActionTendency());
		actionTendencyR.setBounds(30, 125, 230, 20);
		panelRight.add(actionTendencyR);

		frame.setSize(700, 600);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);	
	}
}
