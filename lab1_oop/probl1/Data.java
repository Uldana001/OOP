public class Data {
    private double sum;      
    private double max;      
    private int count;      
    
    public Data() {
        this.sum = 0.0;
        this.max = Double.NEGATIVE_INFINITY;  
        this.count = 0;
    }
    
   
    public void addValue(double value) {
        sum = sum + value;          
        
        if (count == 0 || value > max) {
            max = value;              
        }
        
        count = count + 1;            
    }
    
    public double getAverage() {
        if (count == 0) {              
            return 0.0;                
        }
        return sum / count;             
    }
    

    public double getLargest() {
        if (count == 0) {              
            return 0.0;                 
        }
        return max;                     
    }
}