package internalMemory;


import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AssocLearningParams {

	public static double emo_threshold;
	public static int assoc_threshold;


	public static void showGUI(){

		JTextField emoThres = new JTextField(5);
		JTextField assocThres = new JTextField(5);
		
		emoThres.setText(Double.toString(emo_threshold));
		assocThres.setText(Integer.toString(assoc_threshold));		
		
		JPanel panel = new JPanel(new GridLayout(2,2));
		panel.add(new JLabel("Emotion threshold:"));
		panel.add(emoThres);
		
		panel.add(new JLabel("Association threshold:"));
		panel.add(assocThres);

		int result = JOptionPane.showConfirmDialog(null, panel, 
				"Enter the thresholds", JOptionPane.OK_CANCEL_OPTION);
		
		if (result == JOptionPane.OK_OPTION) {
			emo_threshold = Double.parseDouble(emoThres.getText());
			assoc_threshold = Integer.parseInt(assocThres.getText());
		}
	}


}
