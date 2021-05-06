package userInput;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.plaf.basic.BasicArrowButton;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import secondEvaluation.AppraisalDimension;
import secondEvaluation.LinguisticTerm;
import secondEvaluation.EmotionDimension;

import net.sourceforge.jFuzzyLogic.FIS;

public class EvaluationParametersGUI {

	private JLabel headParametersLbl;
	private JPanel panelParameters, panelRules;
	private JList inputVarList, inputTermList, inputMShipList;
	private JList outputVarList, outputTermList, outputMShipList;
	private JList rulesList;
	private DefaultListModel inputVarListModel, inputTermListModel, inputMShipListModel;
	private DefaultListModel outputVarListModel, outputTermListModel, outputMShipListModel;
	private DefaultListModel rulesListModel;
	private JScrollPane inputVarListScroll, inputTermListScroll, inputMShipListScroll;
	private JScrollPane outputVarListScroll, outputTermListScroll, outputMShipListScroll;
	private JScrollPane rulesListScroll;
	private JLabel inputVarLbl, inputTermLbl, inputMShipLbl;
	private JLabel outputVarLbl, outputTermLbl, outputMShipLbl;
	private JLabel conditionLbl, conclusionLbl, rulesLbl;
	//private JTextField inputVarTxt, outputVarTxt; 
	private JTextField inputTermTxt, inputMShipTxt, outputTermTxt, outputMShipTxt;
	private JTextField conditionTxt, conclusionTxt;
	//private BasicArrowButton inputVarButtIn, outputVarButtIn;
	//private JButton inputVarButtOut, outputVarButtOut;
	private BasicArrowButton inputTermButtIn, inputMShipButtIn;
	private JButton inputTermButtOut, inputMShipButtOut;
	private BasicArrowButton outputTermButtIn, outputMShipButtIn;
	private JButton outputTermButtOut, outputMShipButtOut;
	private JButton useConditionButt, useConclusionButt, addRuleButt, delRuleButt;
	private JButton andOpCondButt, andOpConcButt, orOpCondButt, orOpConcButt, saveAsXMLButt;
	private JButton saveEvaluationParamsButt, showInputVarChartButt, showOutputVarChartButt, loadXMLEvaluationParamsButt;
	private JComboBox inputVarCmb, inputTermCmb, outputVarCmb, outputTermCmb, isNotCondCmb, isNotConcCmb;
	private JComboBox inputVarCmbIn, outputVarCmbIn;
	
	JFrame frame;

	private String [] isNotArray = {"IS", "IS NOT"};
	private List<DimensionTree> arrayInputVariables = new ArrayList<DimensionTree>();
	private List<DimensionTree> arrayOutputVariables = new ArrayList<DimensionTree>();

	private ButtonListener buttonListener;
	private ComboListener comboListener;
	private ListListener listListener;

	private String evaluationTheory;
	private String emotionGenerationTheory;
	
	private String[] evaluationTheoryArray = {"PAD", "Scherer"}; 
	private String[] emotionGenerationTheoryArray = {"Ekman", "Scherer"};
	
	private List<String> padTheoryDimensions = new ArrayList<String>();
	private List<String> schererTheoryDimensions = new ArrayList<String>();

	private List<String> ekmanTheoryEmotions = new ArrayList<String>();
	private List<String> schererTheoryEmotions = new ArrayList<String>();
	
	List<AppraisalDimension> listAppraisalVariables = new ArrayList<AppraisalDimension>();
	List<EmotionDimension> listEmotions = new ArrayList<EmotionDimension>();
	
	
	/*
	 * Getters Arrays input & output dimensions
	 */
	public List<AppraisalDimension> getListAppraisaVariables(){
		return listAppraisalVariables;
	}

	public List<EmotionDimension> getListEmotions(){
		return listEmotions;
	}

	public String getEvaluationTheory(){
		return evaluationTheory;
	}

	public String getEmotionGenerationTheory(){
		return emotionGenerationTheory;
	}
	
	public void showGUI(){
		frame.setVisible(true);
	}
	
	
	
	

	
	public EvaluationParametersGUI() {

		// Listeners Initialisation
		buttonListener = new ButtonListener();
		comboListener = new ComboListener();
		listListener = new ListListener();

		// Initialisation of evaluation dimensions
		padTheoryDimensions.add("pleasure");
		padTheoryDimensions.add("arousal");
		padTheoryDimensions.add("dominance");

		schererTheoryDimensions.add("relevance");
		schererTheoryDimensions.add("implication");
		schererTheoryDimensions.add("copingPotential");
		schererTheoryDimensions.add("normativeSignificance");

		// Initialisation of emotion labels
		ekmanTheoryEmotions.add("happiness");
		ekmanTheoryEmotions.add("surprise");
		ekmanTheoryEmotions.add("sadness");
		ekmanTheoryEmotions.add("disgust");
		ekmanTheoryEmotions.add("fear");
		ekmanTheoryEmotions.add("angry");

		schererTheoryEmotions.add("happiness");
		schererTheoryEmotions.add("joy");
		schererTheoryEmotions.add("disgust");
		schererTheoryEmotions.add("contemp");
		schererTheoryEmotions.add("sadness");
		schererTheoryEmotions.add("anxiety");
		schererTheoryEmotions.add("irritation");
		schererTheoryEmotions.add("anger");
		schererTheoryEmotions.add("shame");
		schererTheoryEmotions.add("guilt");
		schererTheoryEmotions.add("pride");



		frame = new JFrame("Evaluation Parameters");
		frame.getContentPane().setLayout(null);

		panelParameters = new JPanel();
		panelParameters.setLayout(null);
		panelParameters.setBounds(0, 0, 490, 500);
		frame.getContentPane().add(panelParameters);

		JSeparator s = new JSeparator(SwingConstants.VERTICAL);
		s.setBounds(500, 40, 10, 390);
		s.setBackground(Color.WHITE);
		frame.getContentPane().add(s);

		panelRules = new JPanel();
		panelRules.setLayout(null);
		panelRules.setBounds(510, 0, 380, 500);
		frame.getContentPane().add(panelRules);




		/*
		 * 
		 * 
		 * FIRST PART OF THE FRAME: LINGUISTIC VARS/TERMS AND MShip DEGREES
		 * 
		 * 
		 * 
		 */

		headParametersLbl = new JLabel("Evaluation Parameters:");
		headParametersLbl.setFont(new Font("Dialog", Font.BOLD, 14));
		panelParameters.add(headParametersLbl);
		headParametersLbl.setBounds(10, 10, 200, 22);

		// BEGIN: Input VARIABLE Block

		inputVarLbl = new JLabel("Theory");
		panelParameters.add(inputVarLbl);
		inputVarLbl.setBounds(10, 40, 100, 20);

		/*inputVarTxt = new JTextField();
		frame.getContentPane().add(inputVarTxt);
		inputVarTxt.setBounds(10, 61, 80, 20);

		inputVarButtIn = new BasicArrowButton(BasicArrowButton.SOUTH);
		inputVarButtIn.addActionListener(buttonListener);
		frame.getContentPane().add(inputVarButtIn);
		inputVarButtIn.setBounds(90, 60, 20, 20);*/

		inputVarCmbIn = new JComboBox(evaluationTheoryArray);
		panelParameters.add(inputVarCmbIn);
		inputVarCmbIn.addActionListener(comboListener);
		inputVarCmbIn.setBounds(10, 60, 100, 20);

		inputVarListModel = new DefaultListModel();
		inputVarList = new JList(inputVarListModel);
		inputVarList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		inputVarList.setLayoutOrientation(JList.VERTICAL);
		inputVarList.setVisibleRowCount(5);
		inputVarList.addListSelectionListener(listListener);
		inputVarListScroll = new JScrollPane(inputVarList);
		panelParameters.add(inputVarListScroll);
		inputVarListScroll.setBounds(10, 85, 100, 100);

		showInputVarChartButt = new JButton("Chart");
		showInputVarChartButt.addActionListener(buttonListener);
		panelParameters.add(showInputVarChartButt);
		showInputVarChartButt.setBounds(10, 190, 100, 20);

		/*inputVarButtOut = new JButton("Remove");
		inputVarButtOut.addActionListener(buttonListener);
		panelParameters.add(inputVarButtOut);
		inputVarButtOut.setBounds(10, 190, 100, 20);*/

		// END: Input VARIABLE Block


		// BEGIN: Input Variables TERM Block

		inputTermLbl = new JLabel("L. Terms");
		panelParameters.add(inputTermLbl);
		inputTermLbl.setBounds(150, 40, 100, 20);
		inputTermTxt = new JTextField();
		panelParameters.add(inputTermTxt);
		inputTermTxt.setBounds(150, 61, 80, 20);
		inputTermButtIn = new BasicArrowButton(BasicArrowButton.SOUTH);
		inputTermButtIn.addActionListener(buttonListener);
		panelParameters.add(inputTermButtIn);
		inputTermButtIn.setBounds(230, 60, 20, 20);

		inputTermListModel = new DefaultListModel();
		inputTermList = new JList(inputTermListModel);
		inputTermList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		inputTermList.setLayoutOrientation(JList.VERTICAL);
		inputTermList.setVisibleRowCount(5);
		inputTermList.addListSelectionListener(listListener);
		inputTermListScroll = new JScrollPane(inputTermList);
		panelParameters.add(inputTermListScroll);
		inputTermListScroll.setBounds(150, 85, 100, 100);

		inputTermButtOut = new JButton("Remove");
		inputTermButtOut.addActionListener(buttonListener);
		panelParameters.add(inputTermButtOut);
		inputTermButtOut.setBounds(150, 190, 100, 20);

		// END: Input Variables TERM Block

		// BEGIN: Input MShip VALUES Block

		inputMShipLbl = new JLabel("MShip degree");
		panelParameters.add(inputMShipLbl);
		inputMShipLbl.setBounds(290, 40, 130, 20);
		inputMShipTxt = new JTextField();
		panelParameters.add(inputMShipTxt);
		inputMShipTxt.setBounds(290, 61, 180, 20);
		inputMShipButtIn = new BasicArrowButton(BasicArrowButton.SOUTH);
		inputMShipButtIn.addActionListener(buttonListener);
		panelParameters.add(inputMShipButtIn);
		inputMShipButtIn.setBounds(470, 60, 20, 20);

		inputMShipListModel = new DefaultListModel();
		inputMShipList = new JList(inputMShipListModel);
		inputMShipList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		inputMShipList.setLayoutOrientation(JList.VERTICAL);
		inputMShipList.setVisibleRowCount(5);
		inputMShipList.addListSelectionListener(listListener);
		inputMShipListScroll = new JScrollPane(inputMShipList);
		panelParameters.add(inputMShipListScroll);
		inputMShipListScroll.setBounds(290, 85, 200, 100);

		inputMShipButtOut = new JButton("Remove");
		inputMShipButtOut.addActionListener(buttonListener);
		panelParameters.add(inputMShipButtOut);
		inputMShipButtOut.setBounds(290, 190, 200, 20);

		// END: Input MShip VALUES Block



		// BEGIN: Input EMOTION Block

		outputVarLbl = new JLabel("Emotions");
		panelParameters.add(outputVarLbl);
		outputVarLbl.setBounds(10, 230, 100, 20);

		/*outputVarTxt = new JTextField();
		panelParameters.add(outputVarTxt);
		outputVarTxt.setBounds(10, 251, 80, 20);
		outputVarButtIn = new BasicArrowButton(BasicArrowButton.SOUTH);
		outputVarButtIn.addActionListener(buttonListener);
		panelParameters.add(outputVarButtIn);
		outputVarButtIn.setBounds(90, 250, 20, 20);*/

		outputVarCmbIn = new JComboBox(emotionGenerationTheoryArray);
		panelParameters.add(outputVarCmbIn);
		outputVarCmbIn.addActionListener(comboListener);
		outputVarCmbIn.setBounds(10, 250, 100, 20);

		outputVarListModel = new DefaultListModel();
		outputVarList = new JList(outputVarListModel);
		outputVarList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		outputVarList.setLayoutOrientation(JList.VERTICAL);
		outputVarList.setVisibleRowCount(5);
		outputVarList.addListSelectionListener(listListener);
		outputVarListScroll = new JScrollPane(outputVarList);
		panelParameters.add(outputVarListScroll);
		outputVarListScroll.setBounds(10, 275, 100, 100);

		/*outputVarButtOut = new JButton("Remove");
		outputVarButtOut.addActionListener(buttonListener);
		panelParameters.add(outputVarButtOut);
		outputVarButtOut.setBounds(10, 380, 100, 20);*/


		showOutputVarChartButt = new JButton("Chart");
		showOutputVarChartButt.addActionListener(buttonListener);
		panelParameters.add(showOutputVarChartButt);
		showOutputVarChartButt.setBounds(10, 380, 100, 20);

		// END: Input EMOTION Block


		// BEGIN: Input EMOTION-TERM Block

		outputTermLbl = new JLabel("Intensity");
		panelParameters.add(outputTermLbl);
		outputTermLbl.setBounds(150, 230, 130, 20);
		outputTermTxt = new JTextField();
		panelParameters.add(outputTermTxt);
		outputTermTxt.setBounds(150, 251, 80, 20);
		outputTermButtIn = new BasicArrowButton(BasicArrowButton.SOUTH);
		outputTermButtIn.addActionListener(buttonListener);
		panelParameters.add(outputTermButtIn);
		outputTermButtIn.setBounds(230, 250, 20, 20);

		outputTermListModel = new DefaultListModel();
		outputTermList = new JList(outputTermListModel);
		outputTermList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		outputTermList.setLayoutOrientation(JList.VERTICAL);
		outputTermList.setVisibleRowCount(5);
		outputTermList.addListSelectionListener(listListener);
		outputTermListScroll = new JScrollPane(outputTermList);
		panelParameters.add(outputTermListScroll);
		outputTermListScroll.setBounds(150, 275, 100, 100);

		outputTermButtOut = new JButton("Remove");
		outputTermButtOut.addActionListener(buttonListener);
		panelParameters.add(outputTermButtOut);
		outputTermButtOut.setBounds(150, 380, 100, 20);

		// END: Input EMOTION-TERM Block


		// BEGIN: Input EMOTION-TERM-Values Block

		outputMShipLbl = new JLabel("MShip degree");
		panelParameters.add(outputMShipLbl);
		outputMShipLbl.setBounds(290, 230, 130, 20);
		outputMShipTxt = new JTextField();
		panelParameters.add(outputMShipTxt);
		outputMShipTxt.setBounds(290, 251, 180, 20);

		outputMShipButtIn = new BasicArrowButton(BasicArrowButton.SOUTH);
		outputMShipButtIn.addActionListener(buttonListener);
		panelParameters.add(outputMShipButtIn);
		outputMShipButtIn.setBounds(470, 250, 20, 20);

		outputMShipListModel = new DefaultListModel();
		outputMShipList = new JList(outputMShipListModel);
		outputMShipList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		outputMShipList.setLayoutOrientation(JList.VERTICAL);
		outputMShipList.setVisibleRowCount(5);
		outputMShipList.addListSelectionListener(listListener);
		outputMShipListScroll = new JScrollPane(outputMShipList);
		panelParameters.add(outputMShipListScroll);
		outputMShipListScroll.setBounds(290, 275, 200, 100);

		outputMShipButtOut = new JButton("Remove");
		outputMShipButtOut.addActionListener(buttonListener);
		panelParameters.add(outputMShipButtOut);
		outputMShipButtOut.setBounds(290, 380, 200, 20);

		// END: Input EMOTION-TERM-Values Block





		/*
		 * 
		 * 
		 * SECOND PART OF THE FRAME: RULE BLOCK
		 * 
		 * 
		 * 
		 */

		// BEGIN: CONDITION part

		conditionLbl = new JLabel("Condition");
		panelRules.add(conditionLbl);
		conditionLbl.setBounds(30, 40, 100, 20);

		andOpCondButt = new JButton("&");
		panelRules.add(andOpCondButt);
		andOpCondButt.addActionListener(buttonListener);
		andOpCondButt.setBounds(275, 36, 45, 20);

		orOpCondButt = new JButton("||");
		panelRules.add(orOpCondButt);
		orOpCondButt.addActionListener(buttonListener);
		orOpCondButt.setBounds(325, 36, 45, 20);

		conditionTxt = new JTextField();
		panelRules.add(conditionTxt);
		conditionTxt.setBounds(30, 60, 340, 22);

		inputVarCmb = new JComboBox();
		panelRules.add(inputVarCmb);
		inputVarCmb.addActionListener(comboListener);
		inputVarCmb.setBounds(30, 88, 100, 20);

		isNotCondCmb = new JComboBox(isNotArray);
		panelRules.add(isNotCondCmb);
		isNotCondCmb.setBounds(132, 88, 71, 20);

		inputTermCmb = new JComboBox();
		panelRules.add(inputTermCmb);
		inputTermCmb.setBounds(205, 88, 100, 20);

		useConditionButt = new JButton("use");
		panelRules.add(useConditionButt);
		useConditionButt.addActionListener(buttonListener);
		useConditionButt.setBounds(310, 88, 60, 20);



		// END: CONDITION part


		// BEGIN: CONCLUSION part

		conclusionLbl = new JLabel("Conclusion");
		panelRules.add(conclusionLbl);
		conclusionLbl.setBounds(30, 135, 100, 20);

		conclusionTxt = new JTextField();
		panelRules.add(conclusionTxt);
		conclusionTxt.setBounds(30, 155, 340, 22);

		andOpConcButt = new JButton("&");
		panelRules.add(andOpConcButt);
		andOpConcButt.addActionListener(buttonListener);
		andOpConcButt.setBounds(275, 131, 45, 20);

		orOpConcButt = new JButton("||");
		panelRules.add(orOpConcButt);
		orOpConcButt.addActionListener(buttonListener);
		orOpConcButt.setBounds(325, 131, 45, 20);

		outputVarCmb = new JComboBox();
		panelRules.add(outputVarCmb);
		outputVarCmb.addActionListener(comboListener);
		outputVarCmb.setBounds(30, 183, 100, 20);

		isNotConcCmb = new JComboBox(isNotArray);
		panelRules.add(isNotConcCmb);
		isNotConcCmb.setBounds(132, 183, 71, 20);

		outputTermCmb = new JComboBox();
		panelRules.add(outputTermCmb);
		outputTermCmb.setBounds(205, 183, 100, 20);

		useConclusionButt = new JButton("use");
		panelRules.add(useConclusionButt);
		useConclusionButt.addActionListener(buttonListener);
		useConclusionButt.setBounds(310, 183, 60, 20);

		// END: CONCLUSION part


		// BEGIN: RULES part

		rulesLbl = new JLabel("Rules");
		panelRules.add(rulesLbl);
		rulesLbl.setBounds(10, 230, 100, 20);

		delRuleButt = new JButton("Del");
		panelRules.add(delRuleButt);
		delRuleButt.addActionListener(buttonListener);
		delRuleButt.setBounds(200, 226, 80, 20);

		addRuleButt = new JButton("Add");
		panelRules.add(addRuleButt);
		addRuleButt.addActionListener(buttonListener);
		addRuleButt.setBounds(290, 226, 80, 20);

		rulesListModel = new DefaultListModel();
		rulesList = new JList(rulesListModel);
		rulesList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		rulesList.setLayoutOrientation(JList.VERTICAL);
		rulesList.setVisibleRowCount(10);
		rulesList.addListSelectionListener(listListener);
		rulesListScroll = new JScrollPane(rulesList);
		panelRules.add(rulesListScroll);
		rulesListScroll.setBounds(10, 250, 360, 150);

		// END: RULES part



		// BUTTONS
		loadXMLEvaluationParamsButt = new JButton("Load XML");
		loadXMLEvaluationParamsButt.addActionListener(buttonListener);
		panelRules.add(loadXMLEvaluationParamsButt);
		loadXMLEvaluationParamsButt.setBounds(60, 415, 150, 30);
		
		saveAsXMLButt = new JButton("Save as XML");
		saveAsXMLButt.addActionListener(buttonListener);
		panelRules.add(saveAsXMLButt);
		saveAsXMLButt.setBounds(60, 440, 150, 30);

		saveEvaluationParamsButt = new JButton("Save Parameters");
		panelRules.add(saveEvaluationParamsButt);
		saveEvaluationParamsButt.addActionListener(buttonListener);
		saveEvaluationParamsButt.setBounds(215, 415, 155, 30);




		frame.setSize(900, 500);
		frame.setLocationRelativeTo(null);
		//frame.setVisible(true);

		// this makes the input var JList get dimensions from the selected theory
		inputVarCmbIn.setSelectedIndex(0);
		outputVarCmbIn.setSelectedIndex(0);
	}



	class ButtonListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {

			/*
			 * Loads a xml profiles of evaluation parameters and rules
			 */

			if((JButton)e.getSource() == loadXMLEvaluationParamsButt &&  inputVarList.getSelectedIndex() != -1){

				// Ask user for the xml file
				File path = new File("xml_ev");
				Object[] possibleValues = path.list();

				Object selectedValue = JOptionPane.showInputDialog(null,
						"Choose one file", "Evaluation Parameters",
						JOptionPane.PLAIN_MESSAGE, null,
						possibleValues, possibleValues[0]);

				if(selectedValue!=null){

					String file = "xml_ev/" + selectedValue.toString();

					try {

						File xmlFile = new File(file);
						DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
						DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
						Document doc = dBuilder.parse(xmlFile);
						doc.getDocumentElement().normalize();

						// Get selected evaluation and emotion theory 
						Node evaTheoryNode = doc.getElementsByTagName("evaluationTheory").item(0);  
						Node emoTheoryNode =  doc.getElementsByTagName("emotionsTheory").item(0);
						evaluationTheory = evaTheoryNode.getTextContent();
						emotionGenerationTheory = emoTheoryNode.getTextContent();

						// when we select an item from the input or output JComboBox, everything in the GUI is restored 
						// according to the selected (evaluation and emotion generation) theory (except the rule lists)
						// in addition, arrayInputVariables y arrayOutputVariables are filled
						inputVarCmbIn.setSelectedItem(evaluationTheory);
						outputVarCmbIn.setSelectedItem(emotionGenerationTheory);
						rulesListModel.clear();
						arrayInputVariables.clear();
						arrayOutputVariables.clear();

						// Get inputDimensions data, its term and memberships
						NodeList dimensionNodeList = doc.getElementsByTagName("dimension");
						for(int i=0; i < dimensionNodeList.getLength(); i++){

							Element dimensionElement = (Element) dimensionNodeList.item(i);	
							String dimension = dimensionElement.getAttribute("id");

							// Add element in arrayDimensionTree
							DimensionTree dimensionTree = new DimensionTree(dimension); 
							arrayInputVariables.add(dimensionTree);

							// terms
							NodeList termsNodeList = dimensionElement.getElementsByTagName("linguistic_term");
							for(int l=0; l < termsNodeList.getLength(); l++){

								Element termElement = (Element) termsNodeList.item(l);
								String term = termElement.getElementsByTagName("name").item(0).getTextContent();
								String mship = termElement.getElementsByTagName("mship_values").item(0).getTextContent();

								// Add term to the added dimension
								DimensionTree termTree = new DimensionTree(term); 
								dimensionTree.addChild(termTree);
								// Add membership to the added term
								DimensionTree mshipTree = new DimensionTree(mship); 
								termTree.addChild(mshipTree);

							}
						}

						// Get outputDimensions data
						NodeList emotionNodeList = doc.getElementsByTagName("emotion");
						for(int i=0; i < emotionNodeList.getLength(); i++){

							Element emotionElement = (Element) emotionNodeList.item(i);
							String emotion = emotionElement.getAttribute("id");
							// Add element in arrayDimensionTree
							DimensionTree emotionTree = new DimensionTree(emotion); 
							arrayOutputVariables.add(emotionTree);

							// terms
							NodeList termsNodeList = emotionElement.getElementsByTagName("intensity");
							for(int l=0; l < termsNodeList.getLength(); l++){

								Element termElement = (Element) termsNodeList.item(l);
								String term = termElement.getElementsByTagName("name").item(0).getTextContent();
								String mship = termElement.getElementsByTagName("mship_values").item(0).getTextContent();
								// Add term to the added dimension
								DimensionTree termTree = new DimensionTree(term); 
								emotionTree.addChild(termTree);
								// Add membership to the added term
								DimensionTree mshipTree = new DimensionTree(mship); 
								termTree.addChild(mshipTree);
							}
						}


						// Get rules
						NodeList ruleNodeList = doc.getElementsByTagName("rule");
						for(int i=0; i < ruleNodeList.getLength(); i++){
							// dimension ID
							Element ruleElement = (Element) ruleNodeList.item(i);
							String rule = ruleElement.getTextContent();
							rulesListModel.addElement(rule);

						}

					} catch (Exception ex) {
						ex.printStackTrace();
					}

					// Set the theories used in the combo in order to display the values in the GUI
					inputVarList.setSelectedIndex(1);
					inputTermList.setSelectedIndex(1);
					outputVarList.setSelectedIndex(1);
					outputTermList.setSelectedIndex(1);
					inputVarList.setSelectedIndex(0);
					inputTermList.setSelectedIndex(0);
					outputVarList.setSelectedIndex(0);
					outputTermList.setSelectedIndex(0);

					inputVarCmb.setSelectedIndex(0);
					outputVarCmb.setSelectedIndex(0);

					rulesList.setSelectedIndex(0);

				}
			}

			/*
			 * 
			 * 
			 * This PART corresponds to the INPUT VARIABLES
			 * 
			 * 
			 * 
			 */

			/*if((JButton)e.getSource() == inputVarButtIn){
				// Add element in the JList
				String dimension = inputVarTxt.getText();
				inputVarListModel.addElement(dimension);
				inputVarList.setSelectedIndex(inputVarListModel.getSize()-1);
				inputVarList.ensureIndexIsVisible(inputVarListModel.getSize()-1);
				inputVarTxt.setText("");
				// Add element in the arrayDimensionTree
				arrayInputVariables.add(new DimensionTree(null, dimension));
				// Add element in RuleConstruction Components
				inputVarCmb.addItem(dimension);
			}*/

			if((JButton)e.getSource() == showInputVarChartButt &&  inputVarList.getSelectedIndex() != -1){

				try {
					File file = new File("fcl/temp.fcl");
					file.createNewFile();
					PrintWriter pw = new PrintWriter(file);
					pw.println("FUNCTION_BLOCK PAD \n");

					pw.println("VAR_INPUT");
					pw.println(inputVarList.getSelectedValue() + " : REAL;");
					pw.println("END_VAR \n");

					for(DimensionTree d: arrayInputVariables){
						if(inputVarList.getSelectedValue().equals(d.getIdentifier())){
							pw.println("FUZZIFY " + d.getIdentifier());
							for(DimensionTree t: d.getChildren()){
								String memberShipFunc = t.getChildren().get(0).toString();
								pw.println("\t TERM " + t.getIdentifier() + " := " + memberShipFunc + ";");
							}
							pw.println("END_FUZZIFY \n");
						}
					}

					pw.println("END_FUNCTION_BLOCK");

					pw.flush();
					pw.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				FIS fis;
				fis = FIS.load("fcl/temp.fcl", true);
				if( fis == null ) { 
					System.err.println("Can't load the file");
					return;
				}
				fis.getVariable(inputVarList.getSelectedValue().toString()).chart(true);
			}

			if((JButton)e.getSource() == inputTermButtIn && !inputTermTxt.getText().trim().isEmpty()){
				// Add element in the JList
				String term = inputTermTxt.getText();
				inputTermListModel.addElement(term);
				inputTermList.setSelectedIndex(inputTermListModel.getSize()-1);
				inputTermList.ensureIndexIsVisible(inputTermListModel.getSize()-1);
				inputTermTxt.setText("");
				// Add element in the arrayDimensionTree
				String variable = (String) inputVarList.getSelectedValue();
				for(DimensionTree d: arrayInputVariables){
					if(d.getIdentifier().equals(variable)){
						d.addChild(new DimensionTree(term));
						break;
					}
				}
				// update elements in RuleConstruction Components
				inputVarCmb.setSelectedIndex(inputVarCmb.getSelectedIndex());
			}

			// inputMShipListModel can have only one item: the values for the membership function
			if((JButton)e.getSource() == inputMShipButtIn && inputMShipListModel.getSize() == 0 && !inputMShipTxt.getText().trim().isEmpty()){
				// Add element in the JList
				String values = inputMShipTxt.getText();
				inputMShipListModel.addElement(values);
				inputMShipTxt.setText("");
				inputMShipList.setSelectedIndex(inputMShipListModel.getSize()-1);
				inputMShipList.ensureIndexIsVisible(inputMShipListModel.getSize()-1);
				// Add element in the arrayDimensionTree
				String variable = (String) inputVarList.getSelectedValue();
				String term = (String) inputTermList.getSelectedValue();
				search: for(DimensionTree d: arrayInputVariables){
					if(d.getIdentifier().equals(variable)){
						for(DimensionTree t: d.getChildren()){
							if(t.getIdentifier().equals(term)){
								t.addChild(new DimensionTree(values));
								break search;
							}
						}
					}
				}

				// This block prints the input data
				for(DimensionTree d: arrayInputVariables){
					System.out.println(d.toString());
					if(d.getChildren().size()>0)
						for(DimensionTree d1: d.getChildren())
							System.out.println(d1.toString() +  d1.getChildren().toString());
				}
			}

			/*if((JButton)e.getSource() == inputVarButtOut && inputVarList.getSelectedIndex() != -1){
				// Remove from JList
				int index = inputVarList.getSelectedIndex();
				String variable = (String) inputVarList.getSelectedValue();
				inputVarListModel.remove(index);
				if(inputVarListModel.getSize()==0){
					inputTermListModel.clear();
					inputMShipListModel.clear();
				}
				if(index==0){
					inputVarList.setSelectedIndex(index);
					inputVarList.ensureIndexIsVisible(index);
				}else{
					inputVarList.setSelectedIndex(index-1);
					inputVarList.ensureIndexIsVisible(index-1);
				}
				// Remove from arrayDimensionTree 
				for(DimensionTree d: arrayInputVariables){
					if(d.getIdentifier().equals(variable)){
						arrayInputVariables.remove(d);
						break;
					}
				}
				// Remove element from RuleConstruction Components
				inputVarCmb.removeItem(variable);
				if(inputVarListModel.getSize() == 0)
					inputTermCmb.removeAllItems();
			}*/

			if((JButton)e.getSource() == inputTermButtOut && inputTermList.getSelectedIndex() != -1){
				// Remove from JList
				int index = inputTermList.getSelectedIndex();
				String variable = (String) inputVarList.getSelectedValue();
				String term = (String) inputTermList.getSelectedValue();
				inputTermListModel.remove(index);
				if(inputTermListModel.getSize()==0){
					inputMShipListModel.clear();
				}
				if(index==0){
					inputTermList.setSelectedIndex(index);
					inputTermList.ensureIndexIsVisible(index);
				}else{
					inputTermList.setSelectedIndex(index-1);
					inputTermList.ensureIndexIsVisible(index-1);
				}
				// Remove from arrayDimensionTree 
				search: for(DimensionTree d: arrayInputVariables){
					if(d.getIdentifier().equals(variable)){
						for(DimensionTree t: d.getChildren()){
							if(t.getIdentifier().equals(term)){
								d.getChildren().remove(t);
								break search;
							}
						}
					}
				}
				// update elements in RuleConstruction Components
				inputVarCmb.setSelectedIndex(inputVarCmb.getSelectedIndex());
			}
			if((JButton)e.getSource() == inputMShipButtOut && inputMShipList.getSelectedIndex() != -1){
				// Remove from JList
				int index = inputMShipList.getSelectedIndex();
				String variable = (String) inputVarList.getSelectedValue();
				String term = (String) inputTermList.getSelectedValue();
				inputMShipListModel.remove(index);
				// Remove from arrayDimensionTree 
				search: for(DimensionTree d: arrayInputVariables){
					if(d.getIdentifier().equals(variable)){
						for(DimensionTree t: d.getChildren()){
							if(t.getIdentifier().equals(term)){
								t.getChildren().clear();
								break search;
							}
						}
					}
				}
			}


			/*
			 * 
			 * 
			 * This PART corresponds to the OUTPUT VARIABLES
			 * 
			 * 
			 * 
			 */

			if((JButton)e.getSource() == showOutputVarChartButt &&  outputVarList.getSelectedIndex() != -1){

				try {
					File file = new File("fcl/temp.fcl");
					file.createNewFile();
					PrintWriter pw = new PrintWriter(file);
					pw.println("FUNCTION_BLOCK PAD \n");

					pw.println("VAR_INPUT");
					pw.println(outputVarList.getSelectedValue() + " : REAL;");
					pw.println("END_VAR \n");

					for(DimensionTree d: arrayOutputVariables){
						if(outputVarList.getSelectedValue().equals(d.getIdentifier())){
							pw.println("FUZZIFY " + d.getIdentifier());
							for(DimensionTree t: d.getChildren()){
								String memberShipFunc = t.getChildren().get(0).toString();
								pw.println("\t TERM " + t.getIdentifier() + " := " + memberShipFunc + ";");
							}
							pw.println("END_FUZZIFY \n");
						}
					}

					pw.println("END_FUNCTION_BLOCK");

					pw.flush();
					pw.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				FIS fis;
				fis = FIS.load("fcl/temp.fcl", true);

				if( fis == null ) { 
					System.err.println("Can't load the file");
					return;
				}

				fis.getVariable(outputVarList.getSelectedValue().toString()).chart(true);

			}

			/*if((JButton)e.getSource() == outputVarButtIn){
				// Add element in the JList
				String dimension = outputVarTxt.getText();
				outputVarListModel.addElement(dimension);
				outputVarList.setSelectedIndex(outputVarListModel.getSize()-1);
				outputVarList.ensureIndexIsVisible(outputVarListModel.getSize()-1);
				outputVarTxt.setText("");
				// Add element in the arrayDimensionTree
				arrayOutputVariables.add(new DimensionTree(dimension));
				// Add element in RuleConstruction Components
				outputVarCmb.addItem(dimension);
			}*/

			if((JButton)e.getSource() == outputTermButtIn && !outputTermTxt.getText().trim().isEmpty()){
				// Add element in the JList
				String term = outputTermTxt.getText();
				outputTermListModel.addElement(term);
				outputTermList.setSelectedIndex(outputTermListModel.getSize()-1);
				outputTermList.ensureIndexIsVisible(outputTermListModel.getSize()-1);
				outputTermTxt.setText("");

				// Add element in the arrayDimensionTree
				String variable =  (String) outputVarList.getSelectedValue();
				for(DimensionTree d: arrayOutputVariables){
					if(d.getIdentifier().equals(variable)){
						d.addChild(new DimensionTree(term));
						break;
					}
				}
				// update elements in RuleConstruction Components
				outputVarCmb.setSelectedIndex(outputVarCmb.getSelectedIndex());
			}

			// inputMShipListModel can have only one item: the values for the membership function
			if((JButton)e.getSource() == outputMShipButtIn && outputMShipListModel.getSize() == 0 && !outputMShipTxt.getText().trim().isEmpty()){
				// Add element in the JList
				String values = outputMShipTxt.getText();
				outputMShipListModel.addElement(values);
				outputMShipTxt.setText("");
				outputMShipList.setSelectedIndex(outputMShipListModel.getSize()-1);
				outputMShipList.ensureIndexIsVisible(outputMShipListModel.getSize()-1);

				// Add element in the arrayDimensionTree
				String variable = (String) outputVarList.getSelectedValue();
				String term = (String) outputTermList.getSelectedValue();
				search: for(DimensionTree d: arrayOutputVariables){
					if(d.getIdentifier().equals(variable)){
						for(DimensionTree t: d.getChildren()){
							if(t.getIdentifier().equals(term)){
								t.addChild(new DimensionTree(values));
								break search;
							}
						}
					}
				}

				// This block prints the input data
				for(DimensionTree d: arrayOutputVariables){
					System.out.println(d.toString());
					if(d.getChildren().size()>0)
						for(DimensionTree d1: d.getChildren())
							System.out.println(d1.toString() +  d1.getChildren().toString());
				}
			}

			/*if((JButton)e.getSource() == outputVarButtOut && outputVarList.getSelectedIndex() != -1){
				// Remove from JList
				int index = outputVarList.getSelectedIndex();
				String variable = (String) outputVarList.getSelectedValue();
				outputVarListModel.remove(index);
				if(outputVarListModel.getSize()==0){
					outputTermListModel.clear();
					outputMShipListModel.clear();
				}
				if(index==0){
					outputVarList.setSelectedIndex(index);
					outputVarList.ensureIndexIsVisible(index);
				}else{
					outputVarList.setSelectedIndex(index-1);
					outputVarList.ensureIndexIsVisible(index-1);
				}
				// Remove from arrayDimensionTree 
				for(DimensionTree d: arrayOutputVariables){
					if(d.getIdentifier().equals(variable)){
						arrayOutputVariables.remove(d);
						break;
					}
				}
				// Remove element from RuleConstruction Components
				outputVarCmb.removeItem(variable);
				if(outputVarListModel.getSize() == 0)
					outputTermCmb.removeAllItems();
			}*/
			if((JButton)e.getSource() == outputTermButtOut && outputTermList.getSelectedIndex() != -1){
				// Remove from JList
				int index = outputTermList.getSelectedIndex();
				String variable = (String) outputVarList.getSelectedValue();
				String term = (String) outputTermList.getSelectedValue();
				outputTermListModel.remove(index);
				if(outputTermListModel.getSize()==0){
					outputMShipListModel.clear();
				}
				if(index==0){
					outputTermList.setSelectedIndex(index);
					outputTermList.ensureIndexIsVisible(index);
				}else{
					outputTermList.setSelectedIndex(index-1);
					outputTermList.ensureIndexIsVisible(index-1);
				}
				// Remove from arrayDimensionTree 
				search: for(DimensionTree d: arrayOutputVariables){
					if(d.getIdentifier().equals(variable)){
						for(DimensionTree t: d.getChildren()){
							if(t.getIdentifier().equals(term)){
								d.getChildren().remove(t);
								break search;
							}
						}
					}
				}
				// update elements in RuleConstruction Components
				outputVarCmb.setSelectedIndex(outputVarCmb.getSelectedIndex());
			}
			if((JButton)e.getSource() == outputMShipButtOut && outputMShipList.getSelectedIndex() != -1){
				// Remove from JList
				int index = outputMShipList.getSelectedIndex();
				String variable = (String) outputVarList.getSelectedValue();
				String term = (String) outputTermList.getSelectedValue();
				outputMShipListModel.remove(index);
				// Remove from arrayDimensionTree 
				search: for(DimensionTree d: arrayOutputVariables){
					if(d.getIdentifier().equals(variable)){
						for(DimensionTree t: d.getChildren()){
							if(t.getIdentifier().equals(term)){
								t.getChildren().clear();
								break search;
							}
						}
					}
				}
			}

			/*
			 * 
			 * 
			 * This PART corresponds to the RULE PART COMPONENTS
			 * 
			 * 
			 * 
			 */

			if((JButton)e.getSource() == andOpCondButt){
				conditionTxt.setText(conditionTxt.getText() + " AND ");
			}

			if((JButton)e.getSource() == orOpCondButt){
				conditionTxt.setText(conditionTxt.getText() + " OR ");
			}

			if((JButton)e.getSource() == andOpConcButt){
				conclusionTxt.setText(conclusionTxt.getText() + " AND ");
			}

			if((JButton)e.getSource() == orOpConcButt){
				conclusionTxt.setText(conclusionTxt.getText() + " OR ");
			}

			if((JButton)e.getSource() == useConditionButt){
				conditionTxt.setText(conditionTxt.getText() + inputVarCmb.getSelectedItem() + " " + 
						isNotCondCmb.getSelectedItem() + " " + inputTermCmb.getSelectedItem());
			}

			if((JButton)e.getSource() == useConclusionButt){
				conclusionTxt.setText(conclusionTxt.getText() + outputVarCmb.getSelectedItem() + " " + 
						isNotConcCmb.getSelectedItem() + " " + outputTermCmb.getSelectedItem());
			}

			if((JButton)e.getSource() == addRuleButt){
				String condition =  conditionTxt.getText().replaceAll("\\s+", " ");
				String conclusion = conclusionTxt.getText().replaceAll("\\s+", " ");
				String rule = "IF " + condition + " THEN " + conclusion;
				rulesListModel.addElement(rule);
				conditionTxt.setText("");
				conclusionTxt.setText("");
				rulesList.setSelectedIndex(rulesListModel.getSize()-1);
			}

			if((JButton)e.getSource() == delRuleButt && rulesList.getSelectedIndex() != -1){
				int index = rulesList.getSelectedIndex();
				rulesListModel.remove(index);
				if(index==0){
					rulesList.setSelectedIndex(index);
					rulesList.ensureIndexIsVisible(index);
				}else{
					rulesList.setSelectedIndex(index-1);
					rulesList.ensureIndexIsVisible(index-1);
				}
			}

			/*
			 * 
			 * 
			 * This PART corresponds to the SAVE ALL PARAMETERS BUTTON
			 * 
			 * 
			 * 
			 */

			if((JButton)e.getSource() == saveEvaluationParamsButt){
				System.out.println("Saving Everything");
				
				/*
				 * First create the .FCL file
				 */
				
				try {
					String filefcl = null;
					if(evaluationTheory.equals("PAD"))
						filefcl = "fcl/PAD.fcl";
					if(evaluationTheory.equals("Scherer"))
						filefcl = "fcl/Scherer.fcl";
					File file = new File(filefcl);
					file.createNewFile();
					PrintWriter pw = new PrintWriter(file);
					pw.println("FUNCTION_BLOCK PAD \n");

					pw.println("VAR_INPUT");
					for(DimensionTree d: arrayInputVariables)
						pw.println("\t" + d.getIdentifier() + " : REAL;");
					pw.println("END_VAR \n");

					pw.println("VAR_OUTPUT");
					for(DimensionTree d: arrayOutputVariables)
						pw.println("\t" + d.getIdentifier() + " : REAL;");
					pw.println("END_VAR \n");

					for(DimensionTree d: arrayInputVariables){
						pw.println("FUZZIFY " + d.getIdentifier());
						for(DimensionTree t: d.getChildren()){
							String memberShipFunc = t.getChildren().get(0).toString();
							pw.println("\t TERM " + t.getIdentifier() + " := " + memberShipFunc + ";");
						}
						pw.println("END_FUZZIFY \n");
					}

					for(DimensionTree d: arrayOutputVariables){
						pw.println("DEFUZZIFY " + d.getIdentifier());
						for(DimensionTree t: d.getChildren()){
							String memberShipFunc = t.getChildren().get(0).toString();
							pw.println("\t TERM " + t.getIdentifier() + " := " + memberShipFunc + ";");
						}
						pw.println("\t METHOD : COG;");
						pw.println("\t DEFAULT := 0;");
						pw.println("END_DEFUZZIFY \n");
					}

					pw.println("RULEBLOCK No1");
					pw.println("\t AND : MIN;");
					pw.println("\t ACT : MIN;");
					pw.println("\t ACCU : MAX;");
					for(int i=0; i< rulesListModel.getSize(); i++)
						pw.println("\t RULE " + i + ":  " + rulesListModel.getElementAt(i) + ";");					
					pw.println("END_RULEBLOCK \n");

					pw.println("END_FUNCTION_BLOCK");

					pw.flush();
					pw.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				/*
				 * Save the input and output variables
				 */
				
				
				for(DimensionTree d: arrayInputVariables){
					AppraisalDimension temp = new AppraisalDimension(d.getIdentifier());
					listAppraisalVariables.add(temp);
					for(DimensionTree t: d.getChildren()){
						temp.addLinguisticTerm(new LinguisticTerm(t.getIdentifier()));
					}
				}
				
				for(DimensionTree d: arrayOutputVariables){
					EmotionDimension temp = new EmotionDimension(d.getIdentifier());
					listEmotions.add(temp);
					for(DimensionTree t: d.getChildren()){
						temp.addLinguisticTerm(new LinguisticTerm(t.getIdentifier()));
					}
				}
				
				
			}

		}




	}	//---------------------------END CLASS BUTTON LISTENER



	class ComboListener implements ActionListener {


		@Override
		public void actionPerformed(ActionEvent e) {

			/*
			 * 
			 * THIS CORRESPONDS TO RULE PANEL
			 * 
			 */

			if((JComboBox)e.getSource() == inputVarCmbIn){

				// Remove all elements in all JLists
				inputVarListModel.clear();
				inputTermListModel.clear();
				inputMShipListModel.clear();

				// Clear arrayDimensionTree
				arrayInputVariables.clear();

				// Remove all elements from RuleConstruction Components
				inputVarCmb.removeAllItems();
				inputTermCmb.removeAllItems();

				// Selected theory
				evaluationTheory = (String) inputVarCmbIn.getSelectedItem();

				// Add elements in the JList according to selected theory
				List<String> temp = null;
				if(evaluationTheory.equals("PAD"))
					temp = padTheoryDimensions;
				if(evaluationTheory.equals("Scherer"))
					temp = schererTheoryDimensions;

				for(String s: temp){
					// Add element in JList
					inputVarListModel.addElement(s);
					// Add element in arrayDimensionTree
					arrayInputVariables.add(new DimensionTree(s));
					// Add element in RuleConstruction Components
					inputVarCmb.addItem(s);

				}

				inputVarList.setSelectedIndex(0);

			}

			if((JComboBox)e.getSource() == outputVarCmbIn){

				// Remove all elements in all JLists
				outputVarListModel.clear();
				outputTermListModel.clear();
				outputMShipListModel.clear();

				// Clear arrayDimensionTree
				arrayOutputVariables.clear();

				// Remove all elements from RuleConstruction Components
				outputVarCmb.removeAllItems();
				outputTermCmb.removeAllItems();

				// Selected theory
				emotionGenerationTheory = (String) outputVarCmbIn.getSelectedItem();

				// Add elements in the JList according to selected theory
				List<String> temp = null;
				if(emotionGenerationTheory.equals("Ekman"))
					temp = ekmanTheoryEmotions;
				if(emotionGenerationTheory.equals("Scherer"))
					temp = schererTheoryEmotions;
				for(String s: temp){
					// Add element in JList
					outputVarListModel.addElement(s);
					// Add element in arrayDimensionTree
					arrayOutputVariables.add(new DimensionTree(s));
					// Add element in RuleConstruction Components
					outputVarCmb.addItem(s);
				}

				outputVarList.setSelectedIndex(0);

			}





			/*
			 * 
			 * THIS CORRESPONDS TO RULE PANEL
			 * 
			 */

			if((JComboBox)e.getSource() == inputVarCmb){
				String item = (String) inputVarCmb.getSelectedItem();
				for(DimensionTree d: arrayInputVariables){
					if(d.getIdentifier().equals(item)){
						inputTermCmb.removeAllItems();
						for(DimensionTree t: d.getChildren()){
							inputTermCmb.addItem(t.getIdentifier());
						}
						break;
					}
				}
			}

			if((JComboBox)e.getSource() == outputVarCmb){
				String item = (String) outputVarCmb.getSelectedItem();				
				for(DimensionTree d: arrayOutputVariables){
					if(d.getIdentifier().equals(item)){
						outputTermCmb.removeAllItems();
						for(DimensionTree t: d.getChildren()){
							outputTermCmb.addItem(t.getIdentifier());
						}
						break;
					}
				}	
			}


		}

	} //-------- END OF CLASS COMBO LISTENER



	class ListListener implements ListSelectionListener{

		@Override
		public void valueChanged(ListSelectionEvent e) {
			/*
			 * 
			 * 
			 * The first part of this method correspond to the INPUT VARIABLES
			 * 
			 * 
			 * 
			 */

			if ((JList)e.getSource()==inputVarList && inputVarList.getSelectedIndex() != -1){
				String variable = (String) inputVarList.getSelectedValue();
				inputTermListModel.clear();
				inputMShipListModel.clear();
				search: for(DimensionTree d: arrayInputVariables){
					if(d.getIdentifier().equals(variable)){
						for(DimensionTree t: d.getChildren())
							inputTermListModel.addElement(t.getIdentifier());
						break search;
					}
				}
				inputTermList.setSelectedIndex(0);
			}

			if ((JList)e.getSource()==inputTermList && inputTermList.getSelectedIndex() != -1){
				String variable = (String) inputVarList.getSelectedValue();
				String term = (String) inputTermList.getSelectedValue();
				inputMShipListModel.clear();
				search: for(DimensionTree d: arrayInputVariables){
					if(d.getIdentifier().equals(variable)){
						for(DimensionTree t: d.getChildren()){
							if(t.getIdentifier().equals(term)){
								for(DimensionTree z: t.getChildren())
									inputMShipListModel.addElement(z.getIdentifier());
								break search;
							}
						}
					}
				}
				inputMShipList.setSelectedIndex(0);
			}

			/*
			 * 
			 * 
			 * The remainder of this method correspond to the OUTPUT VARIABLES
			 * 
			 * 
			 * 
			 */

			if ((JList)e.getSource()==outputVarList && outputVarList.getSelectedIndex() != -1){
				String variable = (String) outputVarList.getSelectedValue();
				outputTermListModel.clear();
				outputMShipListModel.clear();
				search: for(DimensionTree d: arrayOutputVariables){
					if(d.getIdentifier().equals(variable)){
						for(DimensionTree t: d.getChildren())
							outputTermListModel.addElement(t.getIdentifier());
						break search;
					}
				}
				outputTermList.setSelectedIndex(0);
			}

			if ((JList)e.getSource()==outputTermList && outputTermList.getSelectedIndex() != -1){
				String variable = (String) outputVarList.getSelectedValue();
				String term = (String) outputTermList.getSelectedValue();
				outputMShipListModel.clear();
				search: for(DimensionTree d: arrayOutputVariables){
					if(d.getIdentifier().equals(variable)){
						for(DimensionTree t: d.getChildren()){
							if(t.getIdentifier().equals(term)){
								for(DimensionTree z: t.getChildren())
									outputMShipListModel.addElement(z.getIdentifier());
								break search;
							}
						}
					}
				}
				outputMShipList.setSelectedIndex(0);
			}

		}



	} //-------- END OF CLASS COMBO LISTENER
} //---------------------END OF GUI CLASS 