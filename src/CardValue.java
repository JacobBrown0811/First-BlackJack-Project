/**
 * This class will contain the value
 * An Ace will either be a 1 = 11
 * King, Queen, Jack will be 10
 * Other card will be face value
 */
public class CardValue {
    
        private int value;
    
        public CardValue() {
            
            value = 10;
        }
    
        public void setAceValue(int aceValue) {
            // Set the value of Ace (1 or 11)
            value = aceValue;
        }
    
        public int getValue() {
            return value;
        }
    }
    

    
