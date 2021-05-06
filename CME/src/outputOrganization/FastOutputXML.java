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
import userInput.ActionInputSignal;
import userInput.EnvEventInputSignal;
import userInput.ObjectInputSignal;



public class FastOutputXML {

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

			Element id = doc.createElement("input_id");
			id.appendChild(doc.createTextNode(o.getInputId()));
			rootElement.appendChild(id);

			Element type = doc.createElement("input_type");
			type.appendChild(doc.createTextNode(typeInput));
			rootElement.appendChild(type);
			
			Element exceedsThreshold = doc.createElement("exceedsThreshold");
			exceedsThreshold.appendChild(doc.createTextNode(o.isExceedsThreshold()+""));
			rootElement.appendChild(exceedsThreshold);
			
			Element action_tendency = doc.createElement("action_tendency");
			action_tendency.appendChild(doc.createTextNode(o.getFastReaction()));
			rootElement.appendChild(action_tendency);

			TransformerFactory transFactory = TransformerFactory.newInstance();
			Transformer trans = transFactory.newTransformer();
			DOMSource s = new DOMSource(doc);
			StreamResult r = new StreamResult(new File("xml_output/fastOutput.xml"));
			trans.transform(s, r);


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
