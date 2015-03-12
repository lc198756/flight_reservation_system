/** cs509: team07
 *  Description: This class is created to generate the query parameters 
 *    like list=airports, list=airplanes etc, used to append to mBaseURL.
 *    Each call of query returns its unique
 *    URL parameter.
 */
 
 public class QueryFactory {
        /** constructor for QueryFactory class
         */
        public QueryFactory() {}
        
        /** public method class methods 
         *  returns the url parameter used to retrive airports 
         *  using http get besides the given base urls
         */
        public static String getAirport() {
                return "&list_type=airports";
        }
        
        public static String getAirplanes() {
                return "&list_type=airplanes";
        }
        
        /** 
         * return the string as url string parameter 
         * to retrieve departing flight from the cs server
         * @param code refers to the airport code
         * @param day used for specifying the day of departure
         */
         
        public static String getDepartingFlight(String code, Date day) {
                String day = day.toString();
                return "&list_type=departing&airport="+ code+ "&day="+ day;
        }
        
        public static String getArrivingFlight(String code, Date day) {
                String day = day.toString();
                return "&list_type=arriving&airport="+ code+ "&day="+ day;
        }
 
 }
