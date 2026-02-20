public class problem2 {
 
    public enum Level {
        EASY, MEDIUM, HARD
    }
    
    public static final String SCHOOL = "KBTU";
    
    public static int count = 0;
    public final int id;
    
    private String name;
    private Level level;
    {
        count++;  
        System.out.println("New object created. Total: " + count);
    }
    
    public problem2() {
        this("Unknown", Level.EASY, 100 + count);
    }
    
    public problem2(String name, Level level, int id) {
        this.name = name;    
        this.level = level;
        this.id = id;
    }
    
    public void show() {
        System.out.println("Name: " + name);
    }
    
    public void show(boolean showLevel) {
        this.show();         
        if (showLevel) {
            System.out.println("Level: " + level);
        }
    }
    
    public int getId() {
        return id;
    }
    
    public static void main(String[] args) {
        problem2 obj1 = new problem2();
        problem2 obj2 = new problem2("Java", Level.MEDIUM, 101);
        problem2 obj3 = new problem2("Python", Level.HARD, 102);
        
        System.out.println("\n=== TESTING ===");
        obj1.show();
        obj2.show(true);
        obj3.show(true);
        
        System.out.println("\nSCHOOL: " + SCHOOL);
        System.out.println("Total objects: " + count);
        System.out.println("IDs: " + obj1.getId() + ", " + 
                          obj2.getId() + ", " + obj3.getId());
    }
}