package org.oweis.Lear_ClientAPI.Converter;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.oweis.Lear_ClientAPI.RestAPIClientDesktop;
import org.oweis.Lear_ClientAPI.model.*;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ReadXmlFile2 {
	
	// Input From Home
	static String namePassByUser = "namePassByUser11";
	
	//Input From Connexion(after passing by home of course)
//	static String pathFile = "C:/Files/txtXML.xml";
	

	static String idFamily = "0";
	static String idPartNumber = "0" ;
	static String namePartNumber = "namePartNumber";
	static String nameFixture = "nameFixture";
	static String idFixture = "0";
	
  public static void main(String[] args) {

    try {

	File file = new File("C:/Files/txtXML.xml");
	RestAPIClientDesktop racd = new RestAPIClientDesktop();
		
	DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance()
                             .newDocumentBuilder();
	Document doc = dBuilder.parse(file);

	//System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

	if (doc.hasChildNodes()) {
		printNote(doc.getChildNodes());

	}
  }catch (Exception e){
	System.out.println(e.getMessage());
    }

  }

  private static void printNote(NodeList nodeList) {
	  Balise balise = new Balise();
	  
	  String entityName = null;
    for (int count = 0; count < nodeList.getLength(); count++) {

	Node tempNode = nodeList.item(count);

	// make sure it's element node.
	if (tempNode.getNodeType() == Node.ELEMENT_NODE) {

		String nodeName = tempNode.getNodeName();
		balise.check(nodeName);
		
		//In our xml file we will not need tempNode.getTextContent()(nodeValue)
		//cause every balise type is empty

		if (tempNode.hasAttributes()) {

			// get attributes names and values
			NamedNodeMap nodeMap = tempNode.getAttributes();

			for (int i = 0; i < nodeMap.getLength(); i++) {

				Node node = nodeMap.item(i);
			
				entityName = tempNode.getNodeName(); 
				String attributName = node.getNodeName();
				String attributValue = node.getNodeValue();
				
				setIdsWhenPossible(entityName,attributName,attributValue);
					
			 	balise.getValuesForBalise("namePassByUser", namePassByUser);
				balise.getValuesForBalise("idFamily", idFamily);
				balise.getValuesForBalise("idPartNumber", idPartNumber);
				balise.getValuesForBalise("idFixture",idFixture);
				
			
				balise.getValuesForBalise(attributName,attributValue);

				}	
		}
		balise.showValues();	
		balise.saveBalise();
		
		if (tempNode.hasChildNodes()) {
			// loop again if has child nodes
			printNote(tempNode.getChildNodes());
			}
		}
    }
  }
	public static void setIdsWhenPossible(String entityName,String attributName,String attributValue){		
		RestAPIClientDesktop racd = new RestAPIClientDesktop();
		 	
		if(entityName.equals("PARTNUMBER") & attributName.equals("NAME")){
			Integer idFamilyInt =  racd.getFamily(namePassByUser).getId();
			idFamily = idFamilyInt.toString();
			}
		if(entityName.equals("PN") & attributName.equals("PNname") ){
			namePartNumber = attributValue;
			Integer idPartNumberInt = racd.getPartNumber(Integer.parseInt(idFamily),namePartNumber).getId();
			idPartNumber = idPartNumberInt.toString();
			}
		if(entityName.equals("FIXTURE") & attributName.equals("FIXTUREID")){
			nameFixture = attributValue;
			} 
		if(entityName.equals("PIN")){
			Integer idFixtureInt = racd.getFixture(Integer.parseInt(idFamily), nameFixture).getId();
			idFixture = idFixtureInt.toString();
			}
		}
 
}
