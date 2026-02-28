import java.util.Scanner;

public class Problem3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== TIME CALCULATOR ===\n");
        
        System.out.println("Enter FIRST time:");
        System.out.print("Hour (0-23): ");
        int h1 = scanner.nextInt();
        
        System.out.print("Minute (0-59): ");
        int m1 = scanner.nextInt();
        
        System.out.print("Second (0-59): ");
        int s1 = scanner.nextInt();
        
        Time t1 = new Time(h1, m1, s1);
        
        System.out.println("\nEnter SECOND time:");
        System.out.print("Hour (0-23): ");
        int h2 = scanner.nextInt();
        
        System.out.print("Minute (0-59): ");
        int m2 = scanner.nextInt();
        
        System.out.print("Second (0-59): ");
        int s2 = scanner.nextInt();
        
        Time t2 = new Time(h2, m2, s2);
        
        System.out.println("\n=== YOUR TIMES ===");
        System.out.println("Time 1:");
        System.out.println("  Universal: " + t1.toUniversal());
        System.out.println("  Standard: " + t1.toStandard());
        
        System.out.println("\nTime 2:");
        System.out.println("  Universal: " + t2.toUniversal());
        System.out.println("  Standard: " + t2.toStandard());
        
        System.out.println("\n=== ADDING TIMES ===");
        Time sum = t1.add(t2);
        System.out.println(t1.toUniversal() + " + " + t2.toUniversal() + 
                          " = " + sum.toUniversal());
        System.out.println("In standard format: " + sum.toStandard());
        
        scanner.close();
    }
}

class Time {
    private int hour;
    private int minute;
    private int second;
    
    public Time(int hour, int minute, int second) {
        setTime(hour, minute, second);
    }
    
    public void setTime(int hour, int minute, int second) {
        if (hour < 0 || hour > 23) {
            System.out.println("❌ Invalid hour: " + hour + ". Setting to 0.");
            this.hour = 0;
        } else {
            this.hour = hour;
        }
        
        if (minute < 0 || minute > 59) {
            System.out.println("❌ Invalid minute: " + minute + ". Setting to 0.");
            this.minute = 0;
        } else {
            this.minute = minute;
        }
        
        if (second < 0 || second > 59) {
            System.out.println("❌ Invalid second: " + second + ". Setting to 0.");
            this.second = 0;
        } else {
            this.second = second;
        }
    }
    
    public String toUniversal() {
        String h = (hour < 10) ? "0" + hour : "" + hour;
        String m = (minute < 10) ? "0" + minute : "" + minute;
        String s = (second < 10) ? "0" + second : "" + second;
        
        return h + ":" + m + ":" + s;
    }
    
    public String toStandard() {
        int stdHour;
        String ampm;
        
        if (hour == 0) {
            stdHour = 12;
            ampm = "AM";
        } else if (hour == 12) {
            stdHour = 12;
            ampm = "PM";
        } else if (hour < 12) {
            stdHour = hour;
            ampm = "AM";
        } else {
            stdHour = hour - 12;
            ampm = "PM";
        }
        
        String h = (stdHour < 10) ? "0" + stdHour : "" + stdHour;
        String m = (minute < 10) ? "0" + minute : "" + minute;
        String s = (second < 10) ? "0" + second : "" + second;
        
        return h + ":" + m + ":" + s + " " + ampm;
    }
    
    public Time add(Time other) {
        int newSecond = this.second + other.second;
        int newMinute = this.minute + other.minute;
        int newHour = this.hour + other.hour;
        
        if (newSecond >= 60) {
            newMinute = newMinute + (newSecond / 60);
            newSecond = newSecond % 60;
        }
        
        if (newMinute >= 60) {
            newHour = newHour + (newMinute / 60);
            newMinute = newMinute % 60;
        }
        
        if (newHour >= 24) {
            newHour = newHour % 24;
        }
        
        return new Time(newHour, newMinute, newSecond);
    }
    
    public static Time add(Time t1, Time t2) {
        return t1.add(t2);
    }
    
    public String toString() {
        return toUniversal();
    }
}