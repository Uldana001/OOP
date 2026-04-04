public class Task2 {
    interface Moveable {
        void move(int x, int y);
        void stop();
        int getSpeed();
    }

    interface Flyable extends Moveable {
        void fly(int altitude);
        void land();
        int getAltitude();
    }

    static class Bird implements Flyable {
        private String name;
        private int x, y, speed, altitude;

        Bird(String name, int speed) {
            this.name = name;
            this.speed = speed;
        }

        public void move(int x, int y) {
            this.x = x; this.y = y;
            System.out.println(name + " flies to (" + x + ", " + y + ")");
        }
        public void stop() {
            System.out.println(name + " stops flapping and glides.");
        }
        public int getSpeed() { return speed; }
        public void fly(int altitude) {
            this.altitude = altitude;
            System.out.println(name + " rises to " + altitude + "m altitude.");
        }
        public void land() {
            this.altitude = 0;
            System.out.println(name + " lands on the ground.");
        }
        public int getAltitude() { return altitude; }
    }

    static class Drone implements Flyable {
        private String id;
        private int speed, altitude;

        Drone(String id, int speed) {
            this.id = id;
            this.speed = speed;
        }

        public void move(int x, int y) {
            System.out.println("Drone " + id + " moves to (" + x + ", " + y + ")");
        }
        public void stop() {
            System.out.println("Drone " + id + " hovering in place.");
        }
        public int getSpeed() { return speed; }
        public void fly(int altitude) {
            this.altitude = altitude;
            System.out.println("Drone " + id + " ascends to " + altitude + "m.");
        }
        public void land() {
            this.altitude = 0;
            System.out.println("Drone " + id + " lands safely.");
        }
        public int getAltitude() { return altitude; }
    }

    static class Car implements Moveable {
        private String brand;
        private int speed;

        Car(String brand, int speed) {
            this.brand = brand;
            this.speed = speed;
        }

        public void move(int x, int y) {
            System.out.println(brand + " drives to (" + x + ", " + y + ")");
        }
        public void stop() {
            System.out.println(brand + " brakes and stops.");
        }
        public int getSpeed() { return speed; }
    }

    public static void main(String[] args) {

        System.out.println("--- Bird ---");
        Bird bird = new Bird("Eagle", 80);
        bird.fly(500);
        bird.move(10, 20);
        bird.stop();
        bird.land();

        System.out.println("\n--- Drone ---");
        Drone drone = new Drone("DJI-01", 60);
        drone.fly(200);
        drone.move(5, 15);
        drone.stop();
        drone.land();

        System.out.println("\n--- Car ---");
        Car car = new Car("Toyota", 120);
        car.move(3, 7);
        car.stop();

        System.out.println("\n--- Polymorphism ---");
        Moveable[] movers = { bird, drone, car };
        for (Moveable m : movers) {
            m.move(1, 1);
        }
    }
}