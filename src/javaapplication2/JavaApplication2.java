
package javaapplication2;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author aexpedito
 */
public class JavaApplication2 
{

    public static void main(String[] args) 
    {
        
        if(args[0].length()==0 || args[1].length()==0 || args[2].length()==0)
        {
            System.out.println("Usage: ./exec <Pilot> <StartDate> <EndDate>");
            System.exit(1);
        }
        
        try{
        String baseURL = "http://192.168.201.91:7303/VJET/1.5/EPP/flightSchedule/"+args[0].toUpperCase()+"/?fromDate="+
                    args[1]+"&toDate="+ args[2]+"&enableMaintenanceEvent=false";
        System.out.println(baseURL);
        
        //open remote file
        URL url = new URL(baseURL);
        URLConnection urlConnection = url.openConnection();
        InputStream in = new BufferedInputStream(urlConnection.getInputStream());
        //XML parse
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = dbf.newDocumentBuilder();
        Document doc =  docBuilder.parse(in);
        
        //check element root
        Element root = doc.getDocumentElement();
        //System.out.println("Root: "+ root.getNodeName());
        
        NodeList rostersList = root.getElementsByTagName("roster");
        System.out.println("Crew\tDuty Type\tDate");
        for(int i=0; i< rostersList.getLength(); i++) //for each roster
        {
            Element ele = (Element) rostersList.item(i); //get one element from roster's list
            
            NodeList listCode = ele.getElementsByTagName("code"); //gets crew code in roster
            Node code = listCode.item(0).getFirstChild();
            //System.out.println("Crew: "+code.getNodeValue());
            
            NodeList listDuty = ele.getElementsByTagName("dutyType"); //gets duty type
            Node duty = listDuty.item(0).getFirstChild();
            //System.out.println("Duty type: "+duty.getNodeValue());
            
            NodeList listDate = ele.getElementsByTagName("dutyDate"); //gets date for roster
            Node date = listDate.item(0).getFirstChild();
            //System.out.println("Date: "+date.getNodeValue());
            
            //System.out.println(RosterTypeEnum.ONDUTY.getValue()); //returns 1
            //System.out.println(RosterTypeEnum.ONDUTY); //prints ONDUTY
            //System.out.println(RosterTypeEnum.CALL.getLabel(1));
            //System.out.println(RosterTypeEnum.CALL.getLabel(10));
            int dutyType= Integer.parseInt(duty.getNodeValue().trim());
            System.out.println(code.getNodeValue()+"\t"+duty.getNodeValue()+" "+RosterTypeEnum.CALL.getLabel(dutyType) +"\t "+date.getNodeValue());
            System.out.println();
            
            //TODO sort by date
        }
        
        }catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }
    
}


