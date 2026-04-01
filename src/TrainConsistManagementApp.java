import java.util.*;
import java.util.stream.Collectors;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class TrainConsistManagementApp {

    // ---------------- UC7 / UC8 / UC9 / UC10 / UC13: Bogie Class ----------------
    static class Bogie {
        String name;
        int capacity;

        public Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }

        @Override
        public String toString() {
            return name + " (" + capacity + " seats)";
        }
    }

    // ---------------- UC12: GoodsBogie Class ----------------
    static class GoodsBogie {
        String type;   // Cylindrical, Rectangular, Open, etc.
        String cargo;  // Petroleum, Coal, Grain, etc.

        public GoodsBogie(String type, String cargo) {
            this.type = type;
            this.cargo = cargo;
        }

        @Override
        public String toString() {
            return type + " bogie carrying " + cargo;
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Train Consist Management App ===");

        // ---------------- UC1: Initialize train consist ----------------
        List<String> trainConsist = new ArrayList<>();
        System.out.println("Initial train consist size: " + trainConsist.size());

        // ---------------- UC2: Add/remove bogies ----------------
        trainConsist.add("Sleeper");
        trainConsist.add("AC Chair");
        trainConsist.add("First Class");
        System.out.println("\nPassenger bogies: " + trainConsist);
        trainConsist.remove("AC Chair");
        System.out.println("After removing AC Chair: " + trainConsist);

        // ---------------- UC3: Unique Bogie IDs ----------------
        Set<String> bogieIds = new HashSet<>(Arrays.asList("BG101", "BG102", "BG103", "BG101"));
        System.out.println("\nUnique Bogie IDs: " + bogieIds);

        // ---------------- UC4: Ordered LinkedList ----------------
        LinkedList<String> orderedTrain = new LinkedList<>(Arrays.asList("Engine", "Sleeper", "AC", "Cargo", "Guard"));
        orderedTrain.add(2, "Pantry Car");
        System.out.println("\nTrain after adding Pantry Car: " + orderedTrain);
        orderedTrain.removeFirst();
        orderedTrain.removeLast();
        System.out.println("Final Ordered Train Consist: " + orderedTrain);

        // ---------------- UC5: LinkedHashSet for insertion order ----------------
        LinkedHashSet<String> formation = new LinkedHashSet<>(Arrays.asList("Engine", "Sleeper", "Cargo", "Guard", "Sleeper"));
        System.out.println("\nTrain Formation (unique + insertion order): " + formation);

        // ---------------- UC6: Bogie capacities ----------------
        Map<String, Integer> bogieCapacity = Map.of("Sleeper", 72, "AC Chair", 54, "First Class", 36);
        System.out.println("\nBogie Capacities:");
        bogieCapacity.forEach((k, v) -> System.out.println(k + " → " + v + " seats"));

        // ---------------- UC7: Sort passenger bogies ----------------
        List<Bogie> passengerBogies = new ArrayList<>();
        passengerBogies.add(new Bogie("Sleeper", 72));
        passengerBogies.add(new Bogie("AC Chair", 54));
        passengerBogies.add(new Bogie("First Class", 36));

        passengerBogies.sort(Comparator.comparingInt(b -> b.capacity));
        System.out.println("\nPassenger Bogies Sorted by Capacity:");
        passengerBogies.forEach(System.out::println);

        // ---------------- UC8: Filter high capacity ----------------
        List<Bogie> highCapacityBogies = passengerBogies.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());
        System.out.println("\nPassenger Bogies with Capacity > 60:");
        highCapacityBogies.forEach(System.out::println);

        // ---------------- UC9: Group by type ----------------
        Map<String, List<Bogie>> bogiesByType = passengerBogies.stream()
                .collect(Collectors.groupingBy(b -> b.name));
        System.out.println("\nPassenger Bogies Grouped by Type:");
        bogiesByType.forEach((k, v) -> System.out.println(k + " → " + v));

        // ---------------- UC10: Total seats ----------------
        int totalSeats = passengerBogies.stream()
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);
        System.out.println("\nTotal Seating Capacity in Train: " + totalSeats + " seats");

        // ---------------- UC11: Regex validation ----------------
        Pattern trainIdPattern = Pattern.compile("TRN-\\d{4}");
        Pattern cargoCodePattern = Pattern.compile("PET-[A-Z]{2}");

        System.out.print("\nEnter Train ID (TRN-1234): ");
        String trainId = scanner.nextLine();
        System.out.print("Enter Cargo Code (PET-AB): ");
        String cargoCode = scanner.nextLine();

        System.out.println(trainIdPattern.matcher(trainId).matches() ? "Train ID is valid." : "Invalid Train ID!");
        System.out.println(cargoCodePattern.matcher(cargoCode).matches() ? "Cargo Code is valid." : "Invalid Cargo Code!");

        // ---------------- UC12: Goods safety check ----------------
        List<GoodsBogie> goodsBogies = Arrays.asList(
                new GoodsBogie("Cylindrical", "Petroleum"),
                new GoodsBogie("Rectangular", "Coal"),
                new GoodsBogie("Cylindrical", "Petroleum"),
                new GoodsBogie("Open", "Grain")
        );

        boolean isSafe = goodsBogies.stream()
                .allMatch(b -> !b.type.equals("Cylindrical") || b.cargo.equals("Petroleum"));

        System.out.println("\nGoods Bogie Safety Compliance:");
        goodsBogies.forEach(System.out::println);
        System.out.println("Train safety compliant: " + isSafe);

        // ---------------- UC13: Performance Comparison ----------------
        // Create 1,000 bogies with varying capacities
        List<Bogie> bogies = new ArrayList<>();
        for (int i = 1; i <= 1000; i++) {
            int cap = (i % 3 == 0) ? 36 : (i % 3 == 1) ? 54 : 72;
            String type = (i % 3 == 0) ? "First Class" : (i % 3 == 1) ? "AC Chair" : "Sleeper";
            bogies.add(new Bogie(type, cap));
        }

        // Loop-based filtering
        long startLoop = System.nanoTime();
        List<Bogie> filteredLoop = new ArrayList<>();
        for (Bogie b : bogies) {
            if (b.capacity > 60) filteredLoop.add(b);
        }
        long endLoop = System.nanoTime();
        System.out.println("\nLoop-based filtering count: " + filteredLoop.size());
        System.out.println("Loop execution time (ns): " + (endLoop - startLoop));

        // Stream-based filtering
        long startStream = System.nanoTime();
        List<Bogie> filteredStream = bogies.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());
        long endStream = System.nanoTime();
        System.out.println("Stream-based filtering count: " + filteredStream.size());
        System.out.println("Stream execution time (ns): " + (endStream - startStream));

        scanner.close();
    }
}