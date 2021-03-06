package outputOrganization;

import java.io.File;
import java.text.DecimalFormat;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import secondEvaluation.AppraisalDimension;
import secondEvaluation.LinguisticTerm;
import secondEvaluation.EmotionDimension;
import userInput.ActionInputSignal;
import userInput.EnvEventInputSignal;
import userInput.ObjectInputSignal;



public class CognitiveOutputXML {

	private String typeInput;
	DecimalFormat df = new DecimalFormat("#.##");

	public void generateXML(OutputSignal o){



		if(o.getInput() instanceof ActionInputSignal)
			typeInput = "Action";
		if(o.getInput() instanceof EnvEventInputSignal)
			typeInput = "Environmental Event";
		if(o.getInput() instanceof ObjectInputSignal)
			typeInput = "Object"; 

		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.newDocument();

			Element rootElement = doc.createElement("parameters");
			doc.appendChild(rootElement);

			Element evaluationTheory = doc.createElement("evaluationTheory");
			evaluationTheory.appendChild(doc.createTextNode(o.getEvaluationTheory()));
			rootElement.appendChild(evaluationTheory);

			Element emotionsTheory = doc.createElement("emotionsTheory");
			emotionsTheory.appendChild(doc.createTextNode(o.getEmotionGenerationTheory()));
			rootElement.appendChild(emotionsTheory);

			Element input = doc.createElement("input");
			rootElement.appendChild(input);

			Element id = doc.createElement("id");
			id.appendChild(doc.createTextNode(o.getInputId()));
			input.appendChild(id);

			Element type = doc.createElement("type");
			type.appendChild(doc.createTextNode(typeInput));
			input.appendChild(type);
			
			Element exceedsThreshold = doc.createElement("exceedsThreshold");
			exceedsThreshold.appendChild(doc.createTextNode(o.isExceedsThreshold()+""));
			input.appendChild(exceedsThreshold);

			Element intrinsic_significance = doc.createElement("intrinsic_significance");
			intrinsic_significance.appendChild(doc.createTextNode(df.format(o.getIntrinsicEmoValue())));
			input.appendChild(intrinsic_significance);

			Element cognitive_significance = doc.createElement("cognitive_significance");
			cognitive_significance.appendChild(doc.createTextNode(df.format(o.getCognitiveEmoValue())));
			input.appendChild(cognitive_significance);

			// Emotional significance based on input dimensions
			Element emotional_significance = doc.createElement("emotional_significance");
			input.appendChild(emotional_significance);

			for(AppraisalDimension i: o.getAppraisalVariables()){

				Element dimension = doc.createElement("dimension");
				emotional_significance.appendChild(dimension);

				Element dimensionId = doc.createElement("id");
				dimensionId.appendChild(doc.createTextNode(i.getName()));
				dimension.appendChild(dimensionId);

				Element dimensionCrispValue = doc.createElement("crisp_value");
				dimensionCrispValue.appendChild(doc.createTextNode(df.format(i.getCrispValue())));
				dimension.appendChild(dimensionCrispValue);

				for(LinguisticTerm t: i.getLinguisticTerms()){
					if(t.getMembershipValue() != 0){
						Element linguistic_term = doc.createElement("linguistic_term");
						dimension.appendChild(linguistic_term);

						Element lt_name = doc.createElement("id");
						lt_name.appendChild(doc.createTextNode(t.getName()));
						linguistic_term.appendChild(lt_name);

						Element mship_value = doc.createElement("mship_value");
						mship_value.appendChild(doc.createTextNode(df.format(t.getMembershipValue())));
						linguistic_term.appendChild(mship_value);
					}
				}

			}

			// Emotions generated by the input
			Element elicited_emotions = doc.createElement("elicited_emotions");
			input.appendChild(elicited_emotions);

			for(EmotionDimension i: o.getEmotionsList()){
				if(i.getDeffuzifiedValue() != 0){
					Element emotion = doc.createElement("emotion");
					elicited_emotions.appendChild(emotion);

					Element emotionId = doc.createElement("id");
					emotionId.appendChild(doc.createTextNode(i.getName()));
					emotion.appendChild(emotionId);

					Element emotionDeffuzifiedValue = doc.createElement("deffuzified_value");
					emotionDeffuzifiedValue.appendChild(doc.createTextNode(df.format(i.getDeffuzifiedValue())));
					emotion.appendChild(emotionDeffuzifiedValue);

					for(LinguisticTerm t: i.getLinguisticTerms()){
						if(t.getMembershipValue() != 0){
							Element linguistic_term = doc.createElement("intensity");
							emotion.appendChild(linguistic_term);

							Element lt_name = doc.createElement("id");
							lt_name.appendChild(doc.createTextNode(t.getName()));
							linguistic_term.appendChild(lt_name);

							Element mship_value = doc.createElement("mship_value");
							mship_value.appendChild(doc.createTextNode(df.format(t.getMembershipValue())));
							linguistic_term.appendChild(mship_value);
						}
					}
				}
			}

			Element agent_status = doc.createElement("agent_status");
			rootElement.appendChild(agent_status);

			Element current_emotion = doc.createElement("current_emotion");
			current_emotion.appendChild(doc.createTextNode(o.getEmoState().getEmotion()));
			agent_status.appendChild(current_emotion);

			Element emotion_intensity = doc.createElement("emotion_intensity");
			emotion_intensity.appendChild(doc.createTextNode(o.getEmoState().getIntensity()));
			agent_status.appendChild(emotion_intensity);


			Element current_mood = doc.createElement("current_mood");
			current_mood.appendChild(doc.createTextNode(o.getMoodState()));
			agent_status.appendChild(current_mood);

			Element action_tendency = doc.createElement("action_tendency");
			action_tendency.appendChild(doc.createTextNode(o.getActionTendency()));
			agent_status.appendChild(action_tendency);

			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File("xml_output/cognitiveOutput.xml"));
			transformer.transform(source, result);


		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
