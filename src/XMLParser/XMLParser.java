/** cs509 team: team07 
 * Date: March 12. 2015
 * Description: This XMLParser interface is created to specify 
 *        the necessary fields and method prototypes that 
 * 				concrete classes have to implement to convert the XML Strings
 * 				to the corresponding DOM Object
 */
 
public interface XMLParser{
        
        /** parse the xml string list and store the DOM object in list 
         * @param xmlString is the xml String list returned by the url
         */
        public void parseXML(String xmlString);

}
