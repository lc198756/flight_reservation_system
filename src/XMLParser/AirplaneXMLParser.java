/** cs509 team: team07
 * Date: March 13. 2015
 * Description: Creates a AirplaneDOM that parses an Airplane XML file
 * 				The class stores the information in 
 * 				a list of airplane objects.
 */
 
 import java.io.IOException; 
 import javax.xml.parsers.DocumentBuilder; 
 import javax.xml.parsers.DocumentBuilderFactory; 
 import javax.xml.parsers.ParserConfigurationException; 
 import org.w3c.dom.Document; 
 import org.w3c.dom.Element; 
 import org.w3c.dom.Node; 
 import org.w3c.dom.NodeList; 
 import org.xml.sax.SAXException; 
 import org.xml.sax.InputSource;
 

 public class AirplaneXMLParser {
        /** fields */
        private List<Airplane> airplaneList; 
        
        /** public constructor of class AirportXMLParser
         *  used to initiate field values.
         */
        public AirplaneXMLParser() {
                airplaneList = new ArrayList<Airplane>();
        }
        
        /** implement the method prototype from the interface
         *  XMLParser and store the DOM object into the airportList.
         */
        public void parseXML(String xmlString) {
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance(); 
            Document document = null; 
            try { 
               //DOM parser instance 
               DocumentBuilder builder = builderFactory.newDocumentBuilder(); 
               
               //parse an XML file into a DOM tree, in this case, change the filepath to xml String  
               //document = builder.parse(new File(filePath));
                InputSource is = new InputSource();
                is.setCharacterStream(new StringReader(new XMLLoader().getAirplanes()));
                document.parse(is);
               //get root element, which is <Airports>
               Element rootElement = document.getDocumentElement(); 
      
               //traverse child elements. retrieve all the <Airport>
               NodeList nodes = rootElement.getChildNodes(); 
               for (int i=0; i < nodes.getLength(); i++) 
               { 
                  Node node = nodes.item(i); 
                  if (node.getNodeType() == Node.ELEMENT_NODE) {   
                     Element airplane = (Element) node; 
                     
                     //process child element 
                     String model = airplane.getAttribute("Model");
                     String manufacturer = airplane.getAttribute("Manufacturer"); 
                     
                     // child node of airport
                     NodeList airplaneChildren = airplane.getChildNodes();
                    
                     // value of longitude & latitude
                     String firstClassSeats =  airplaneChildren.item(0).getTextContent();
                     String coachSeats =  airplaneChildren.item(1).getTextContent();

                    airplaneList.add(new Airplane(model, manufacturer, firstClassSeats, coachSeats));
                  } 
               } 
    
            } catch (ParserConfigurationException e) { 
               e.printStackTrace();  
            } catch (SAXException e) { 
               e.printStackTrace(); 
            } catch (IOException e) { 
               e.printStackTrace(); 
            } 
        }
        
 
 }

