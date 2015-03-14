/** cs509: team07
  * Date: 13, March, 2015 
  * Description: JavaBean created to store data from the 
  *    the xml retriever
  */
  
  class Airplane {
        /* private fields*/
        private String model;
        private String manufacturer;
        private int coachSeats;
        private int firstClassSeats;
        
        /** constructor used to create and initialize the airplane objects */
        public Airplane(String model, String manufacturer, int coachSeats, int firstClassSeats) {
            this.model = model;
            this.manufacturer = manufacturer;
            this.coachSeats = coachSeats;
            this.firstClassSeats = firstClassSeats;
        }
        
        public void setModel(String model) {}
        public String getModel() {}
        
        public void setManufacturer(Sting manufacturer) {}
        public String getManufacturer() {}
        
        public void setFirstClassSeats(int seats) {}
        public int getFirstClassSeats() {}
        
        public void setCoachSeats(int seats) {}
        public int getCoachSeats() {}
  }
