/** CS509: team07
 *  Description: this class is created to retrieve stream data from the cs server 
 *  and convert it to XML String representation. 
 */
 import java.io.BufferedReader;
 import java.io.IOException;
 import java.io.InputStream;
 import java.io.InputStreamReader;
 import java.net.HttpURLConnection;
 import java.net.URL;
 
 import cs509.team07.QueryFactory;// the package of QueryFactory is not determined created yet
 
 public class XMLLoader {
        
        private final String mUrlBase= "http://cs509.cs.wpi.edu:8181/CS509.server/ReservationSystem?team=Team07&action=list";
        
        
        public String getXMLString(String query) {
            URL url;
            BufferedReader bReader;
            HttpURLConnection conn;
            String line;
            StringBuffer result;
            try {
              url = new URL(mUrlBase+ query);
              conn = (HttpURLConnection) url.openConnection();
              conn.setRequestMethod("GET");
              conn.setRequestProperty("User-Agent", "team07");
              
              int responseCode = conn.getResponseCode();
              if (responseCode >= 200 && responseCode <= 299) {
                  InputStream inputStream = conn.getInputStream();
                  String encoding = conn.getContentEncoding();
                  encoding = (encoding == null? "URF-8" : encoding);
                
                  bReader = new BufferedReader(new InputStreamReader(inputStream));
                  while ((line =bReader.readLine()) != null) {
                      result.append(line);
                  }
                  bReader.close();
              }
            } catch(IOException e) {
              e.printStackTrace();
            } catch(Exception e) {
              e.printStackTrace();
            }
            return result.toString();
        }
        
        /** return xml String list of airports
         */
        public String getAirports() {
            return getXMLString(QueryFactory.getAirports());
        }
        
        /** return xml String list of airplanes
         */ 
        public String getAirplanes() {
            return getXMLString(QueryFactory.getAirplanes());
        }
        
        /** return xml String list of departing flight 
         */
        public String getDepartingFlights() {
            return getXMLString(QueryFactory.getDepartingFlight());
        }
        
        /** return xml String list of arriving flight
         */
        public String getArrivingFlights() {
            return getXMLString(QueryFactory.getArrivingFlight());
        }
 }
 
