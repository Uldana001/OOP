public class Problem2 {
    public static void main(String[] args) {
        StarTriangle small = new StarTriangle(3);
        StarTriangle medium = new StarTriangle(5);
        StarTriangle large = new StarTriangle(7);
        
        System.out.println("Small triangle (3):");
        System.out.println(small.toString());
        
        System.out.println("Medium triangle (5):");
        System.out.println(medium);
        
        System.out.println("Large triangle (7):");
        System.out.println(large);
    }
}

class StarTriangle {
    private int width;
    
    public StarTriangle(int width) {
        this.width = width;
    }
    
    public String toString() {
        String result = "";
        
        for (int i = 1; i <= width; i++) {
            for (int j = 1; j <= i; j++) {
                result = result + "[*]";
            }
            if (i < width) {
                result = result + "\n";
            }
        }
        
        return result;
    }
}