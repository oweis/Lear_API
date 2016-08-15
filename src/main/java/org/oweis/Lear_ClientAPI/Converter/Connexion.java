package org.oweis.Lear_ClientAPI.Converter;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.*;

public class Connexion  {

	public static  String fileName = "TestFile";
	
	public static String filePathTST = "C:/Files/txtTST.txt";
	
	public static String filePathXML = "C:/Files/txtXML.xml";

	private static void saveFileFromString(String text) throws FileNotFoundException{
		 PrintWriter out = new PrintWriter(filePathXML);
		    out.println(text);
		    out.close();
		    
	}

	private static String StringToXml(String text){
		
		String replacedString = text
				.replaceAll("0\\]\"", "0\">")
				.replaceAll("1\\]\"", "1\">")
				.replaceAll("2\\]\"", "2\">")
				.replaceAll("3\\]\"", "3\">")
				.replaceAll("4\\]\"", "4\">")
				.replaceAll("5\\]\"", "5\">")
				.replaceAll("6\\]\"", "6\">")
				.replaceAll("7\\]\"", "7\">")
				.replaceAll("8\\]\"", "8\">")
				.replaceAll("9\\]\"", "9\">")
				.replaceAll("\\]\"", " ")
				.replaceAll("\\]\"", " ")
				.replaceFirst("\\[","<")
				.replaceAll("\\[","/><")
				.replaceAll("=","=\"")
				.replaceAll("/><ENDPARTNUMBER","")
				.replaceAll("/><ENDHEADER","")
				.replaceAll("/><CONNECTION","/><CONNECTION>")
				.replaceAll("/><PN=\"", "<PN PNname=\"")
				.replaceAll("/><ENDPN","</PN>")
				.replaceAll("/><ENDWIRE","/>")			
				.replaceAll("/><WIRE","<WIRE")
				.replaceAll("/><ENDCONNECTION", "</CONNECTION>")
				.replaceAll("/><CONNECTOR", "<CONNECTOR>")
				.replaceAll("/><FIXTURE", "<FIXTURE")
				.replaceAll("/><ENDFIXTURE", "</FIXTURE>")
				.replaceAll("/><ENDPIN", "/>")
				.replaceAll("/><PIN", "><PIN")
				.replaceAll("/><SPLICE", "<SPLICE")
				.replaceAll("/><ENDSPLICE", "/>")
				.replaceAll("/><ENDCONNECTOR","</CONNECTOR>");
			
			replacedString = "<LEAR>"+replacedString+"</LEAR>";

		return replacedString;
	}

	private static int CountOccurence(String text,String word)
	{ 
	    Pattern p = Pattern.compile(word);
	    Matcher m = p.matcher(text);
	    int count = 0;
	    while (m.find()){
	    	count +=1;
	    }
	 return count-1;
    }

	private static String FixEndLineProblem(InputStream inputStream) throws IOException{
	    InputStreamReader r = new InputStreamReader(inputStream);
	    BufferedReader bufferedReader = new BufferedReader(r);
		StringBuffer stringBuffer = new StringBuffer();
		String line;
		while ((line = bufferedReader.readLine()) != null) {	
			stringBuffer.append(line);
			stringBuffer.append("\" ");
			stringBuffer.append("\n");
		}
		
		return stringBuffer.toString();
	}

	public static void main(String[] args){
		
  try {
   
	InputStream inputStream = new FileInputStream(filePathTST);

    String text = FixEndLineProblem(inputStream);
    String XMLtext =  StringToXml(text);
    String[] partsINI = XMLtext.split("<SPLICE");
	String[] parts = partsINI[0].split("<FIXTURE");
	
	for(int i=1;i<parts.length;i++)
	{
	String part = parts[i].trim();
	int size = CountOccurence(part,"NAME");
	String partUpdate = part;
	//partUpdate = partUpdate.replace("/>", "SIZE=\""+size+"\" />");

	partUpdate = partUpdate.replaceFirst("NAME","FIXTUREID");
		for(int j=1;j<=size;j++){
			partUpdate = partUpdate.replaceFirst("NAME", "VOIE"+j);
		}
	XMLtext = XMLtext.replace(part,partUpdate);
	} 
    saveFileFromString(XMLtext); 
    System.out.println(XMLtext);
   
    inputStream.close();
   }catch (IOException ex) {
   ex.printStackTrace();
  }
 }
}
