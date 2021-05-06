package userInput;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class InputConfigurationGUI implements ActionListener {

	private MultimodalInputGUI multimodalInputGUI;
	private ActionInputSignal inputSignal;
	private EnvEventInputSignal envEventSignal;

	private JFrame frame;
	private JTextField idActionTxt, idEnvEventTxt;
	private JComboBox tagActionCmb, whoActionCmb, tagEnvEventCmb;
	private JButton submitActionButt, submitEnvEventButt, loadActionsXmlButt, loadEventsXmlButt;
	private JPanel actionPanel, envEventPanel;

	private String[] actionWho = {"friend", "relative", "strange"};
	private String[] actionTag = {"help", "compliment", "attack", "insult", "disturb", "threaten"};

	private String[] envEventTag = {"dangerous", "convenient"};

	public InputConfigurationGUI(MultimodalInputGUI m) {
		multimodalInputGUI = m;
		showGUI();
	}


	public void showGUI() {
		frame = new JFrame("Input Configuration");
		frame.getContentPane().setLayout(null);

		/*JSeparator s1 = new JSeparator(SwingConstants.HORIZONTAL);
		frame.getContentPane().add(s1);
		s1.setBackground(Color.WHITE);
		s1.setBounds(5, 160, 540, 10);*/
		
		actionPanel = new JPanel();
		actionPanel.setLayout(null);
		actionPanel.setBounds(5, 0, 250, 180);
		frame.getContentPane().add(actionPanel);
		
		JSeparator s = new JSeparator(SwingConstants.VERTICAL);
		frame.getContentPane().add(s);
		s.setBackground(Color.WHITE);
		s.setBounds(265, 10, 10, 150);
		
		envEventPanel = new JPanel();
		envEventPanel.setLayout(null);
		envEventPanel.setBounds(280, 0, 250, 180);
		frame.getContentPane().add(envEventPanel);
		
		/*loadXmlPanel = new JPanel();
		loadXmlPanel.setLayout(null);
		loadXmlPanel.setBounds(0, 170, 550, 30);
		frame.getContentPane().add(loadXmlPanel);*/
		
		

		/*
		 * ACTION PANEL
		 */

		

		JLabel headActLbl = new JLabel("Actions:");
		headActLbl.setFont(new Font("Dialog", Font.BOLD, 14));
		actionPanel.add(headActLbl);
		headActLbl.setBounds(5, 5, 200, 22);

		JLabel idLbl = new JLabel("Identifier");
		actionPanel.add(idLbl);
		idLbl.setBounds(5, 40, 80, 22);
		idActionTxt = new JTextField(20);
		actionPanel.add(idActionTxt);
		idActionTxt.setBounds(100, 40, 150, 22);

		JLabel tagLbl = new JLabel("Tag");
		actionPanel.add(tagLbl);
		tagLbl.setBounds(5, 70, 80, 22);
		tagActionCmb = new JComboBox(actionTag);
		actionPanel.add(tagActionCmb);
		tagActionCmb.setBounds(100, 70, 150, 22);

		JLabel typeLbl = new JLabel("Who");
		actionPanel.add(typeLbl);
		typeLbl.setBounds(5, 100, 80, 22);
		whoActionCmb = new JComboBox(actionWho);
		actionPanel.add(whoActionCmb);
		whoActionCmb.setBounds(100, 100, 150, 22);

		submitActionButt = new JButton("Submit");
		actionPanel.add(submitActionButt);
		submitActionButt.setBounds(100, 140, 150, 22);
		submitActionButt.addActionListener(this);
		
		loadActionsXmlButt = new JButton("xml");
		loadActionsXmlButt.addActionListener(this);
		loadActionsXmlButt.setBounds(5, 140, 50, 22);
		actionPanel.add(loadActionsXmlButt);


		/*
		 * ENV-EVENTS PANEL
		 */
	

		JLabel headEnvEventLbl = new JLabel("Environmental Events:");
		headEnvEventLbl.setFont(new Font("Dialog", Font.BOLD, 14));
		envEventPanel.add(headEnvEventLbl);
		headEnvEventLbl.setBounds(5, 5, 200, 22);

		JLabel idEnvEventLbl = new JLabel("Identifier");
		envEventPanel.add(idEnvEventLbl);
		idEnvEventLbl.setBounds(5, 40, 80, 22);
		idEnvEventTxt = new JTextField(20);
		envEventPanel.add(idEnvEventTxt);
		idEnvEventTxt.setBounds(100, 40, 150, 22);

		JLabel tagEnvEventLbl = new JLabel("Tag");
		envEventPanel.add(tagEnvEventLbl);
		tagEnvEventLbl.setBounds(5, 70, 80, 22);
		tagEnvEventCmb = new JComboBox(envEventTag);
		envEventPanel.add(tagEnvEventCmb);
		tagEnvEventCmb.setBounds(100, 70, 150, 22);

		/*JLabel typeEnvEventLbl = new JLabel("Who");
		actionPanel.add(typeEnvEventLbl);
		typeEnvEventLbl.setBounds(5, 70, 80, 22);
		whoActionCmb = new JComboBox(actionWho);
		actionPanel.add(whoActionCmb);
		whoActionCmb.setBounds(100, 70, 150, 22);*/

		submitEnvEventButt = new JButton("Submit");
		envEventPanel.add(submitEnvEventButt);
		submitEnvEventButt.setBounds(100, 140, 150, 22);
		submitEnvEventButt.addActionListener(this);
		
		loadEventsXmlButt = new JButton("xml");
		loadEventsXmlButt.addActionListener(this);
		loadEventsXmlButt.setBounds(5, 140, 50, 22);
		envEventPanel.add(loadEventsXmlButt);

		frame.setSize(550, 200);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {

		if((JButton)e.getSource() == submitActionButt){
			inputSignal = new ActionInputSignal();
			inputSignal.setIdentifier(idActionTxt.getText());
			inputSignal.setTag(tagActionCmb.getSelectedItem().toString());
			inputSignal.setWho(whoActionCmb.getSelectedItem().toString());
			idActionTxt.setText("");
			multimodalInputGUI.setEvent(inputSignal);
		}

		if((JButton)e.getSource() == submitEnvEventButt){
			envEventSignal = new EnvEventInputSignal();
			envEventSignal.setIdentifier(idEnvEventTxt.getText());
			envEventSignal.setTag(tagEnvEventCmb.getSelectedItem().toString());
			idEnvEventTxt.setText("");
			multimodalInputGUI.setEvent(envEventSignal);
		}
		
		if((JButton)e.getSource() == loadActionsXmlButt || (JButton)e.getSource() == loadEventsXmlButt){
			// Ask user for the xml file
			File path = new File("xml_input");
			Object[] possibleValues = path.list();

			Object selectedValue = JOptionPane.showInputDialog(null,
					"Choose one file", "Predefined Inputs",
					JOptionPane.PLAIN_MESSAGE, null,
					possibleValues, possibleValues[0]);

			if(selectedValue!=null){

				String file = "xml_input/" + selectedValue.toString();

				try {

					File xmlFile = new File(file);
					DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
					DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
					Document doc = dBuilder.parse(xmlFile);
					doc.getDocumentElement().normalize();

					// Get actions from XML and add to the comboBox
					NodeList actionNodeList = doc.getElementsByTagName("action");
					for(int i=0; i < actionNodeList.getLength(); i++){
						Element actionElement = (Element) actionNodeList.item(i);	
						inputSignal = new ActionInputSignal();
						inputSignal.setIdentifier(actionElement.getElementsByTagName("id").item(0).getTextContent());
						inputSignal.setTag(actionElement.getElementsByTagName("tag").item(0).getTextContent());
						inputSignal.setWho(actionElement.getElementsByTagName("who").item(0).getTextContent());
						multimodalInputGUI.setEvent(inputSignal);
					}
					
					// Get events from XML and add to the comboBox
					NodeList eventNodeList = doc.getElementsByTagName("event");
					for(int i=0; i < eventNodeList.getLength(); i++){
						Element eventElement = (Element) eventNodeList.item(i);	
						envEventSignal = new EnvEventInputSignal();
						envEventSignal.setIdentifier(eventElement.getElementsByTagName("id").item(0).getTextContent());
						envEventSignal.setTag(eventElement.getElementsByTagName("tag").item(0).getTextContent());
						multimodalInputGUI.setEvent(envEventSignal);
					}
					
					JOptionPane.showMessageDialog(null, "The XML file was loaded.", "Message",
						    JOptionPane.PLAIN_MESSAGE);
					frame.dispose();
				} catch (Exception ex) {
					ex.printStackTrace();
				}		
			}
		}

	}

}
