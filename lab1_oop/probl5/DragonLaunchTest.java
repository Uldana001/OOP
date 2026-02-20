public class DragonLaunchTest {
    public static void main(String[] args) {
        System.out.println("=== Test 1: BBGG ===");
        DragonLaunch launch1 = new DragonLaunch();
        launch1.kidnap(new Person(Gender.BOY, "Bob"));
        launch1.kidnap(new Person(Gender.BOY, "Charlie"));
        launch1.kidnap(new Person(Gender.GIRL, "Diana"));
        launch1.kidnap(new Person(Gender.GIRL, "Eve"));
        
        System.out.print("Initial line: ");
        launch1.displayLine();
        
        boolean result1 = launch1.willDragonEatOrNot();
        System.out.println("Will dragon eat? " + (result1 ? "YES" : "NO"));
        System.out.println("Expected: NO (all disappear)\n");
        
       
        System.out.println("=== Test 2: GBGB ===");
        DragonLaunch launch2 = new DragonLaunch();
        launch2.kidnap(new Person(Gender.GIRL, "Fiona"));
        launch2.kidnap(new Person(Gender.BOY, "George"));
        launch2.kidnap(new Person(Gender.GIRL, "Helen"));
        launch2.kidnap(new Person(Gender.BOY, "Ian"));
        
        System.out.print("Initial line: ");
        launch2.displayLine();
        
        boolean result2 = launch2.willDragonEatOrNot();
        System.out.println("Will dragon eat? " + (result2 ? "YES" : "NO"));
        System.out.println("Expected: YES (2 left)");
    }
}