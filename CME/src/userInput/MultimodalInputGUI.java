package userInput;

import internalMemory.AssocLearningParams;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;


public class MultimodalInputGUI implements Runnable, ActionListener{
	//private JLabel facialExLbl, postureLbl;
	//private JComboBox facialExCombo, postureCombo;
	
	private JLabel objLocationLbl, objAttendedLbl, objAttendedLbl2;
	private JLabel actionHeadLbl, eventHeadLbl, objectHeadLbl;
	private JComboBox actionsCombo, envEventCombo;
	private JButton submitActionButt, submitObjButt, submitEnvEventButt;
	private JButton loadActionButt, loadEventButt, deleteActionButt, deleteEventButt;
	private JButton evaParametersButt, assocLearningButt, emoDynamicsButt, moodDynamicsButt;
	private JRadioButton peripheryRadio, centerRadio;
	private JCheckBox attendPeriCheck;
	private ButtonGroup objsPositionGroup;
	private DrawingPanel drawingPanel;
	
	private JFrame frame;
	private JPanel actionEventPanel, configurePanel, objectPanel;
	
	private IncomingInputInterface input;
	private EvaluationParametersGUI evaluationParameters;
	private ObjectInputSignal objectDrawn;

	//private String[] basicEmotions = { "Anger", "Disgust", "Fear", "Happiness", "Sadness", "Surprise" };

	DefaultComboBoxModel actionsCmbModel = new DefaultComboBoxModel();
	DefaultComboBoxModel envEventsCmbModel = new DefaultComboBoxModel();



	/* Getters and Setters
	 * 
	 */
	public IncomingInputInterface getInput(){
		return input;
	}
	public void setEvent(ActionInputSignal event) {
		actionsCmbModel.addElement(event);
	}
	public void setEvent(EnvEventInputSignal event) {
		envEventsCmbModel.addElement(event);
	}
	
	public MultimodalInputGUI(EvaluationParametersGUI evaluationParameters) {
		this.evaluationParameters = evaluationParameters;
	}
	

	public void run() {
		frame = new JFrame("Incoming Stimuli");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		actionEventPanel = new JPanel();
		actionEventPanel.setLayout(null);
		actionEventPanel.setBounds(0, 0, 280, 150);
		frame.getContentPane().add(actionEventPanel);
		
		JSeparator s = new JSeparator(SwingConstants.HORIZONTAL);
		s.setBackground(Color.WHITE);
		frame.getContentPane().add(s);
		s.setBounds(0, 160, 295, 10);
		
		configurePanel = new JPanel();
		configurePanel.setLayout(null);
		configurePanel.setBounds(0, 170, 280, 170);
		frame.getContentPane().add(configurePanel);
		
		objectPanel = new JPanel();
		objectPanel.setLayout(null);
		objectPanel.setBounds(300, 0, 300, 350);
		frame.getContentPane().add(objectPanel);
		
		JSeparator s2 = new JSeparator(SwingConstants.VERTICAL);
		frame.getContentPane().add(s2);
		s2.setBackground(Color.WHITE);
		s2.setBounds(290, 5, 10, 335);



		


		/*
		 *  BEGIN: ACTIONS INPUT  
		 *  
		 */

		actionHeadLbl = new JLabel("Actions:");
		actionHeadLbl.setFont(new Font("Dialog", Font.BOLD, 14));
		actionEventPanel.add(actionHeadLbl);
		actionHeadLbl.setBounds(10, 10, 200, 22);

		actionsCombo = new JComboBox(actionsCmbModel);
		actionEventPanel.add(actionsCombo);
		actionsCombo.setBounds(10, 40, 120, 22);
		
		submitActionButt = new JButton("Submit");
		actionEventPanel.add(submitActionButt);
		submitActionButt.setBounds(135, 40, 90, 22);
		submitActionButt.addActionListener(this);

		loadActionButt = new JButton("+");
		actionEventPanel.add(loadActionButt);
		loadActionButt.setBounds(235, 40, 20, 22);
		loadActionButt.addActionListener(this);
		
		deleteActionButt = new JButton("-");
		actionEventPanel.add(deleteActionButt);
		deleteActionButt.setBounds(260, 40, 20, 22);
		deleteActionButt.addActionListener(this);


		
		/*
		postureLbl = new JLabel("Posture");
		actionPanel.add(postureLbl);
		postureLbl.setBounds(10, 74, 120, 22);

		postureCombo = new JComboBox(basicEmotions);
		actionPanel.add(postureCombo);
		postureCombo.setBounds(145, 74, 120, 22);
		
		facialExLbl = new JLabel("Facial Expression");
		actionPanel.add(facialExLbl);
		facialExLbl.setBounds(10, 106, 200, 22);

		facialExCombo = new JComboBox(basicEmotions);
		actionPanel.add(facialExCombo);
		facialExCombo.setBounds(145, 106, 120, 22);        
		*/
		

		/*
		 *  BEGIN: EVENTS INPUT  
		 *  
		 */

		eventHeadLbl = new JLabel("Environmental events:");
		eventHeadLbl.setFont(new Font("Dialog", Font.BOLD, 14));
		actionEventPanel.add(eventHeadLbl);
		eventHeadLbl.setBounds(10, 80, 250, 22);

		envEventCombo = new JComboBox(envEventsCmbModel);
		actionEventPanel.add(envEventCombo);
		envEventCombo.setBounds(10, 110, 120, 22);
		
		submitEnvEventButt = new JButton("Submit");
		actionEventPanel.add(submitEnvEventButt);
		submitEnvEventButt.addActionListener(this);
		submitEnvEventButt.setBounds(135, 110, 90, 22);
		
		loadEventButt = new JButton("+");
		actionEventPanel.add(loadEventButt);
		loadEventButt.setBounds(235, 110, 20, 22);
		loadEventButt.addActionListener(this);
		
		deleteEventButt = new JButton("-");
		actionEventPanel.add(deleteEventButt);
		deleteEventButt.setBounds(260, 110, 20, 22);
		deleteEventButt.addActionListener(this);


		/*
		 *  BEGIN: OBJECT INPUT  
		 *  
		 */

		objectHeadLbl = new JLabel("Object in scene:");
		objectHeadLbl.setFont(new Font("Dialog", Font.BOLD, 14));	
		objectPanel.add(objectHeadLbl);
		objectHeadLbl.setBounds(10, 10, 180, 22);

		objLocationLbl = new JLabel("Location:");
		objectPanel.add(objLocationLbl);
		objLocationLbl.setBounds(10, 40, 80, 22);
		centerRadio = new JRadioButton("Center");
		objectPanel.add(centerRadio);
		centerRadio.setBounds(80, 40, 80, 22);
		peripheryRadio = new JRadioButton("Periphery");
		objectPanel.add(peripheryRadio);
		peripheryRadio.setBounds(160, 40, 100, 22);

		objAttendedLbl = new JLabel("Attend Object in periphery if it");
		objectPanel.add(objAttendedLbl);
		objAttendedLbl.setBounds(10, 70, 260, 22);
		objAttendedLbl2 = new JLabel("results highly emotional?");
		objectPanel.add(objAttendedLbl2);
		objAttendedLbl2.setBounds(10, 88, 200, 22);
		attendPeriCheck = new JCheckBox("Yes");
		attendPeriCheck.setSelected(true);
		objectPanel.add(attendPeriCheck);
		attendPeriCheck.setBounds(200, 88, 60, 22);

		objsPositionGroup = new ButtonGroup();
		objsPositionGroup.add(centerRadio);
		objsPositionGroup.add(peripheryRadio);
		centerRadio.setSelected(true);

		drawingPanel = new DrawingPanel();       
		objectPanel.add(drawingPanel);
		drawingPanel.setBounds(15, 120, 250, 170);

		submitObjButt = new JButton("Submit");
		objectPanel.add(submitObjButt);
		submitObjButt.setBounds(145, 300, 120, 22);
		submitObjButt.addActionListener(this);
		
		
		
		/*
		 *  BEGIN: CONFIGURE PANEL  
		 *  
		 */
		
		
		JLabel configure = new JLabel("Configure:");
		configure.setFont(new Font("Dialog", Font.BOLD, 14));
		configurePanel.add(configure);
		configure.setBounds(10, 10, 250, 22);
		
		JLabel evaParameters = new JLabel("Evaluation Parameters");
		configurePanel.add(evaParameters);
		evaParameters.setBounds(30, 40, 250, 22);
		
		evaParametersButt = new JButton("*");
		configurePanel.add(evaParametersButt);
		evaParametersButt.setBounds(10, 44, 15, 14);
		evaParametersButt.addActionListener(this);
		
		JLabel assocLearning = new JLabel("Associative Learning");
		configurePanel.add(assocLearning);
		assocLearning.setBounds(30, 60, 250, 22);
		
		assocLearningButt = new JButton("*");
		configurePanel.add(assocLearningButt);
		assocLearningButt.setBounds(10, 64, 15, 14);
		assocLearningButt.addActionListener(this);
		
		JLabel emoDynamics = new JLabel("Agent's emotional state dynamics");
		configurePanel.add(emoDynamics);
		emoDynamics.setBounds(30, 80, 250, 22);
		
		emoDynamicsButt = new JButton("*");
		configurePanel.add(emoDynamicsButt);
		emoDynamicsButt.setBounds(10, 84, 15, 14);
		emoDynamicsButt.addActionListener(this);

		JLabel moodDynamics = new JLabel("Agent's mood state dynamics");
		configurePanel.add(moodDynamics);
		moodDynamics.setBounds(30, 100, 250, 22);
		
		moodDynamicsButt = new JButton("*");
		configurePanel.add(moodDynamicsButt);
		moodDynamicsButt.setBounds(10, 104, 15, 14);
		moodDynamicsButt.addActionListener(this);
		
		frame.setSize(600, 370);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

	}
	
	
	/*
	 * Button Listeners
	 */
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if((JButton)e.getSource() == submitActionButt){
			input = (IncomingInputInterface) actionsCombo.getSelectedItem();
			synchronized (this) {
				notify();
			}
		}

		if((JButton)e.getSource() == submitEnvEventButt){
			input = (IncomingInputInterface) envEventCombo.getSelectedItem();
			synchronized (this) {
				notify();
			}
		}

		if((JButton)e.getSource() == submitObjButt){
			input = (IncomingInputInterface) objectDrawn;
			synchronized (this) {
				notify();
			}
		}
		
		if((JButton)e.getSource() == loadActionButt){
			new InputConfigurationGUI(this);
		}

		if((JButton)e.getSource() == loadEventButt){
			new InputConfigurationGUI(this);
		}
		
		if((JButton)e.getSource() == evaParametersButt){
			evaluationParameters.showGUI();
		}
		
		if((JButton)e.getSource() == assocLearningButt){
			AssocLearningParams.showGUI();
		}
	}



	/*
	 *  BEGIN: PANEL FOR DRAWING OBJECTS  
	 *  
	 */


	class DrawingPanel extends JPanel {

		private static final long serialVersionUID = 1L;

		private int xi,yi,xf,yf,w,h;		
		private JRadioButton lineRadioB = new JRadioButton("Line");
		private JRadioButton rectangleRadioB = new JRadioButton("Rectangle");
		private JRadioButton circleRadioB = new JRadioButton("Circle");
		private ButtonGroup groupA, groupB;
		private JRadioButton blackRadioB = new JRadioButton("Black");
		private JRadioButton redRadioB = new JRadioButton("Red");
		private JRadioButton blueRadioB = new JRadioButton("Blue");

		public DrawingPanel() {
			setBorder(BorderFactory.createLineBorder(Color.black));

			groupA = new ButtonGroup();
			groupA.add(lineRadioB);
			groupA.add(rectangleRadioB);
			groupA.add(circleRadioB);
			lineRadioB.setSelected(true);

			add(lineRadioB);
			add(rectangleRadioB);
			add(circleRadioB);

			groupB = new ButtonGroup();
			groupB.add(blackRadioB);
			groupB.add(redRadioB);
			groupB.add(blueRadioB);
			blackRadioB.setSelected(true);

			add(blackRadioB);
			add(redRadioB);
			add(blueRadioB);

			addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent e) {
					xi = e.getX();
					yi = e.getY();
				}
			});

			addMouseMotionListener(new MouseAdapter() {
				public void mouseDragged(MouseEvent e) {
					xf = e.getX();
					yf = e.getY();
					repaint();
				}
			});
		}	

		public void paintComponent(Graphics g) {
			super.paintComponent(g);       

			objectDrawn = new ObjectInputSignal();

			int width = xi - xf;
			int height = yi - yf;
			this.w = Math.abs( width );
			this.h = Math.abs( height );

			objectDrawn.setXi(xi);
			objectDrawn.setXf(xf);
			objectDrawn.setYi(yi);
			objectDrawn.setYf(yf);
			objectDrawn.setW(w);
			objectDrawn.setH(h);

			if(blackRadioB.isSelected()){
				objectDrawn.setColor("black");
			}
			if(redRadioB.isSelected()){
				objectDrawn.setColor("red");
				g.setColor(Color.RED);
			}
			if(blueRadioB.isSelected()){
				objectDrawn.setColor("blue");
				g.setColor(Color.BLUE);
			}
			if(lineRadioB.isSelected()){
				objectDrawn.setIdentifier("line");
				g.drawLine(xi, yi, xf, yf);
			}
			if(rectangleRadioB.isSelected()){
				objectDrawn.setIdentifier("rectangle");
				g.drawRect(xi,yi,w,h);
			}
			if(circleRadioB.isSelected()){
				objectDrawn.setIdentifier("circle");
				g.drawOval(xi,yi,w,h);
			}
		}  
	}
	
	

}
