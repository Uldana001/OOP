public class problem3 {
    
    public static class Temperature {
        private double value;
        private char scale;
        
        public Temperature() {
            this(0, 'C');
        }
        
        public Temperature(double value) {
            this(value, 'C');
        }
        
        public Temperature(char scale) {
            this(0, scale);
        }
        
        public Temperature(double value, char scale) {
            this.value = value;
            setScale(scale);
        }
        
        public double getValue() {
            return value;
        }
        
        public char getScale() {
            return scale;
        }
        
        public void setValue(double value) {
            this.value = value;
        }
        
        public void setScale(char scale) {
            if (scale == 'C' || scale == 'F') {
                this.scale = scale;
            } else {
                System.out.println("Invalid scale! Using C");
                this.scale = 'C';
            }
        }
        
        public void setBoth(double value, char scale) {
            this.value = value;
            setScale(scale);
        }
        
        public double toCelsius() {
            if (scale == 'C') {
                return value;
            } else {
                return 5 * (value - 32) / 9;
            }
        }
        
        public double toFahrenheit() {
            if (scale == 'F') {
                return value;
            } else {
                return (9 * value / 5) + 32;
            }
        }
        
        @Override
        public String toString() {
            return value + "°" + scale;
        }
    }
    
    public static void main(String[] args) {
        System.out.println("=== TEMPERATURE TEST ===\n");
        
        Temperature t1 = new Temperature();
        Temperature t2 = new Temperature(25);
        Temperature t3 = new Temperature('F');
        Temperature t4 = new Temperature(98.6, 'F');
        
        System.out.println("t1: " + t1);
        System.out.println("t2: " + t2);
        System.out.println("t3: " + t3);
        System.out.println("t4: " + t4);
        
        System.out.println("\n25°C in F: " + t2.toFahrenheit() + "°F");
        System.out.println("98.6°F in C: " + t4.toCelsius() + "°C");
        
        t1.setBoth(32, 'F');
        System.out.println("\nt1 after setting: " + t1);
        System.out.println("t1 in Celsius: " + t1.toCelsius() + "°C");
    }
}