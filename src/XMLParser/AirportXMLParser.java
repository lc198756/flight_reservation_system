/** cs509 team: team07
 * Date: March 12. 2015
 * Description: Creates a AirportDOM that parses an Airport XML file
 * 				The class stores the information in 
 * 				a list of airport objects.
 */
 
 import java.io.File; 
 import java.io.IOException; 
 import javax.xml.parsers.DocumentBuilder; 
 import javax.xml.parsers.DocumentBuilderFactory; 
 import javax.xml.parsers.ParserConfigurationException; 
 import org.w3c.dom.Document; 
 import org.w3c.dom.Element; 
 import org.w3c.dom.Node; 
 import org.w3c.dom.NodeList; 
 import org.xml.sax.SAXException; 
 

 public class AirportXMLParser {
        /** fields */
        private List<Airport> airportList; 
        
        /** public constructor of class AirportXMLParser
         *  used to initiate field values.
         */
        public AirportXMLParser() {
                airportList = new ArrayList<Airport>();
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
                   document = builder.parse(new File(filePath));
                   
                   //get root element, which is <Airports>
                   Element rootElement = document.getDocumentElement(); 
          
                   //traverse child elements. retrieve all the <Airport>
                   NodeList nodes = rootElement.getChildNodes(); 
                   for (int i=0; i < nodes.getLength(); i++) 
                   { 
                      Node node = nodes.item(i); 
                      if (node.getNodeType() == Node.ELEMENT_NODE) {   
                         Element airport = (Element) node; 
                         
                         //process child element 
                         String code = airport.getAttribute("Code");
                         String name = airport.getAttribute("Name"); 
                         
                         // child node of airport
                         NodeList airportChildren = airport.getChildNodes();
                        
                         // value of longitude & latitude
                         String longitude =  airportChildren.item(1).getTextContent();
                         String latitude =  airportChildren.item(2).getTextContent();
                         
                        Location location = new Location(longitude, latitude);
                        airportList.add(new Airport(code, name, location));
                      } 
                   } 
        
                  // another approach to traverse all the listNode by tagName   
                   /*NodeList nodeList = rootElement.getElementsByTagName("book"); 
                   if(nodeList != null) 
                   { 
                      for (int i = 0 ; i < nodeList.getLength(); i++) 
                      { 
                         Element element = (Element)nodeList.item(i); 
                         String id = element.getAttribute("id"); 
                      } 
                   }*/
                   // add the DOM object to the airportList
                } catch (ParserConfigurationException e) { 
                   e.printStackTrace();  
                } catch (SAXException e) { 
                   e.printStackTrace(); 
                } catch (IOException e) { 
                   e.printStackTrace(); 
                } 
        }
        
 
 }
