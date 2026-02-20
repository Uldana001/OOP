import java.util.Vector;

public class DragonLaunch {
    private Vector<Person> kidnappedPeople;  
    
    public DragonLaunch() {
        kidnappedPeople = new Vector<>();  
    }
    public void kidnap(Person p) {
        kidnappedPeople.add(p);
    }
    
    public boolean willDragonEatOrNot() {
        if (kidnappedPeople.isEmpty()) {
            return false;  
        }
        
        int n = kidnappedPeople.size();
        char[] line = new char[n];
        
        for (int i = 0; i < n; i++) {
            Person p = kidnappedPeople.get(i);
            if (p.getGender() == Gender.BOY) {
                line[i] = 'B';
            } else {
                line[i] = 'G';
            }
        }
       
        boolean changed;
        
        do {
            changed = false;  
            StringBuilder newLine = new StringBuilder();
            
            for (int i = 0; i < line.length; i++) {
                if (i < line.length - 1 && line[i] == 'B' && line[i + 1] == 'G') {
                    i++;  
                    changed = true;  
                } else {
                    newLine.append(line[i]);
                }
            }
            
            line = newLine.toString().toCharArray();
            
        } while (changed);  
        
        return line.length > 0;
    }
    
    public void displayLine() {
        for (Person p : kidnappedPeople) {
            System.out.print(p);
        }
        System.out.println();
    }
}