import java.util.Arrays;

public class Task5 {

    static class Chocolate implements Comparable<Chocolate> {
        String name;
        double weight;

        Chocolate(String name, double weight) {
            this.name = name;
            this.weight = weight;
        }

        public int compareTo(Chocolate other) {
            return Double.compare(this.weight, other.weight);
        }

        public String toString() {
            return name + "(" + weight + "g)";
        }
    }

    static class Time implements Comparable<Time> {
        int hours;
        int minutes;
        int seconds;

        Time(int hours, int minutes, int seconds) {
            this.hours = hours;
            this.minutes = minutes;
            this.seconds = seconds;
        }

        public int compareTo(Time other) {
            if (this.hours != other.hours) return Integer.compare(this.hours, other.hours);
            if (this.minutes != other.minutes) return Integer.compare(this.minutes, other.minutes);
            return Integer.compare(this.seconds, other.seconds);
        }

        public String toString() {
            return hours + ":" + minutes + ":" + seconds;
        }
    }

    static class Sort {

        static <E> void swap(E[] array, int i, int j) {
            E temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }

        static <E extends Comparable<E>> void bubbleSort(E[] array) {
            int n = array.length;
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - i - 1; j++) {
                    if (array[j].compareTo(array[j + 1]) > 0) {
                        swap(array, j, j + 1);
                    }
                }
            }
        }

        static <E extends Comparable<E>> void mergeSort(E[] array) {
            if (array.length <= 1) return;
            int mid = array.length / 2;
            E[] left = Arrays.copyOfRange(array, 0, mid);
            E[] right = Arrays.copyOfRange(array, mid, array.length);
            mergeSort(left);
            mergeSort(right);
            merge(array, left, right);
        }

        static <E extends Comparable<E>> void merge(E[] array, E[] left, E[] right) {
            int i = 0, j = 0, k = 0;
            while (i < left.length && j < right.length) {
                if (left[i].compareTo(right[j]) <= 0) array[k++] = left[i++];
                else array[k++] = right[j++];
            }
            while (i < left.length) array[k++] = left[i++];
            while (j < right.length) array[k++] = right[j++];
        }
    }

    public static void main(String[] args) {

        System.out.println("--- Sorting Chocolates (bubble sort) ---");
        Chocolate[] chocolates = {
            new Chocolate("Twix", 58),
            new Chocolate("Snickers", 45),
            new Chocolate("KitKat", 41.5),
            new Chocolate("Mars", 51)
        };
        Sort.bubbleSort(chocolates);
        System.out.println(Arrays.toString(chocolates));

        System.out.println("\n--- Sorting Times (merge sort) ---");
        Time[] times = {
            new Time(10, 30, 0),
            new Time(8, 15, 45),
            new Time(10, 30, 10),
            new Time(6, 0, 0)
        };
        Sort.mergeSort(times);
        System.out.println(Arrays.toString(times));

        System.out.println("\n--- Sorting Employees by salary (bubble sort) ---");
        Employee[] employees = {
            new Employee("Alice", 50000),
            new Employee("Bob", 70000),
            new Employee("Charlie", 40000)
        };
        Sort.bubbleSort(employees);
        System.out.println(Arrays.toString(employees));
    }

    static class Employee implements Comparable<Employee> {
        String name;
        double salary;

        Employee(String name, double salary) {
            this.name = name;
            this.salary = salary;
        }

        public int compareTo(Employee other) {
            return Double.compare(this.salary, other.salary);
        }

        public String toString() {
            return name + "($" + salary + ")";
        }
    }
}