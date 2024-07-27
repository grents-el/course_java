import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class XMLHandler extends DefaultHandler {
    private Voter voter;
    private static SimpleDateFormat birthDayFormat = new SimpleDateFormat("yyyy.MM.dd");

    private HashMap<Voter, Integer> voterCounts;
    private int voterCount;
    private HashMap<Voter, Integer> map =new HashMap<>();
   public XMLHandler(){
        voterCounts=new HashMap<>();
    }
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        try {
            if (qName.equals("voter") ){
                String birthDay = attributes.getValue("birthDay");
                Date date = birthDayFormat.parse(birthDay);
                voter=new Voter(attributes.getValue("name"), date);
                DBConnection.countVoter(attributes.getValue("name"), birthDay);
            } else if (qName.equals("visit")&& voter != null) {
               int count = voterCounts.getOrDefault(voter,0);
                voterCounts.put(voter,count+1);
                voterCount++;
            }
        } catch (ParseException | SQLException e){
            e.printStackTrace();
        }
    }


    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
       try {
           if (voterCount==1024){
               for (Map.Entry<Voter,Integer> entry : map.entrySet()){
                   DBConnection.insertQuery.append((DBConnection.insertQuery.isEmpty() ? "": ",")+
                           "('" + entry.getKey().getName() + "', '" + entry.getKey().getBirthDay()+
                           "', '" + entry.getValue()+"')");
               }

               DBConnection.executeMultiInsert();
               voterCount=0;
               DBConnection.insertQuery= new StringBuilder();
           }
       }catch (SQLException e){
           e.printStackTrace();
       }
    }
    public void printDoplicatedVoters(){
        for (Voter voter : voterCounts.keySet()){
            int count = voterCounts.get(voter);
            if (count>1){
                System.out.println(voter.toString()+ " - "+count);
            }
        }
    }
}
