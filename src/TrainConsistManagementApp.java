import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;
import java.util.LinkedList;
import java.util.LinkedHashSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class TrainConsistManagementApp {

    public static void main(String[] args) {

        // Welcome Message
        System.out.println("=== Train Consist Management App ===");

        // ---------------- UC1 START ----------------
        List<String> trainConsist = new ArrayList<>();
        System.out.println("Train consist initialized.");
        System.out.println("Initial number of bogies: " + trainConsist.size());
        // ---------------- UC1 END ----------------

        // ---------------- UC2 START ----------------
        trainConsist.add("Sleeper");
        trainConsist.add("AC Chair");
        trainConsist.add("First Class");

        System.out.println("\nPassenger bogies after addition:");
        System.out.println(trainConsist);

        trainConsist.remove("AC Chair");
        System.out.println("\nAfter removing AC Chair:");
        System.out.println(trainConsist);

        System.out.println("\nIs Sleeper present? " + trainConsist.contains("Sleeper"));

        System.out.println("\nFinal Train Consist:");
        System.out.println(trainConsist);
        // ---------------- UC2 END ----------------

        // ---------------- UC3 START ----------------
        Set<String> bogieIds = new HashSet<>();
        bogieIds.add("BG101");
        bogieIds.add("BG102");
        bogieIds.add("BG103");
        bogieIds.add("BG101"); // duplicate ignored
        bogieIds.add("BG102"); // duplicate ignored

        System.out.println("\nUnique Bogie IDs:");
        System.out.println(bogieIds);
        // ---------------- UC3 END ----------------

        // ---------------- UC4 START ----------------
        LinkedList<String> orderedTrain = new LinkedList<>();
        orderedTrain.add("Engine");
        orderedTrain.add("Sleeper");
        orderedTrain.add("AC");
        orderedTrain.add("Cargo");
        orderedTrain.add("Guard");

        // Insert Pantry Car at position 2
        orderedTrain.add(2, "Pantry Car");
        System.out.println("\nTrain Consist after adding Pantry Car:");
        System.out.println(orderedTrain);

        // Remove first and last bogie
        orderedTrain.removeFirst();
        orderedTrain.removeLast();
        System.out.println("\nFinal Ordered Train Consist:");
        System.out.println(orderedTrain);
        // ---------------- UC4 END ----------------

        // ---------------- UC5 START ----------------
        LinkedHashSet<String> formation = new LinkedHashSet<>();
        formation.add("Engine");
        formation.add("Sleeper");
        formation.add("Cargo");
        formation.add("Guard");
        formation.add("Sleeper"); // duplicate ignored

        System.out.println("\nTrain Formation (Insertion Order + Unique):");
        System.out.println(formation);
        // ---------------- UC5 END ----------------

        // ---------------- UC6 START ----------------
        HashMap<String, Integer> bogieCapacity = new HashMap<>();
        bogieCapacity.put("Sleeper", 72);
        bogieCapacity.put("AC Chair", 54);
        bogieCapacity.put("First Class", 36);

        System.out.println("\nBogie Capacities:");
        for (Map.Entry<String, Integer> entry : bogieCapacity.entrySet()) {
            System.out.println(entry.getKey() + " → " + entry.getValue() + " seats");
        }
        // ---------------- UC6 END ----------------

        // ---------------- UC7 START ----------------
        // Bogie class
        class Bogie {
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

        // Create list of passenger bogies
        List<Bogie> passengerBogies = new ArrayList<>();
        passengerBogies.add(new Bogie("Sleeper", 72));
        passengerBogies.add(new Bogie("AC Chair", 54));
        passengerBogies.add(new Bogie("First Class", 36));

        // Sort by capacity (ascending)
        passengerBogies.sort(Comparator.comparingInt(b -> b.capacity));

        System.out.println("\nPassenger Bogies Sorted by Capacity:");
        for (Bogie b : passengerBogies) {
            System.out.println(b);
        }
        // ---------------- UC7 END ----------------

        // ---------------- UC8 START ----------------
        // Filter bogies with capacity > 60
        List<Bogie> highCapacityBogies = passengerBogies.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());

        System.out.println("\nPassenger Bogies with Capacity > 60:");
        for (Bogie b : highCapacityBogies) {
            System.out.println(b);
        }
        // ---------------- UC8 END ----------------
        // ---------------- UC9 START ----------------

// Group bogies by type (name)
        Map<String, List<Bogie>> bogiesByType = passengerBogies.stream()
                .collect(Collectors.groupingBy(b -> b.name));

// Display grouped bogies
        System.out.println("\nPassenger Bogies Grouped by Type:");
        for (Map.Entry<String, List<Bogie>> entry : bogiesByType.entrySet()) {
            System.out.println(entry.getKey() + " → " + entry.getValue());
        }
// ---------------- UC9 END ----------------
        // ---------------- UC10 START ----------------
// Calculate total seats using Stream reduce
        int totalSeats = passengerBogies.stream()
                .map(b -> b.capacity)        // extract numeric capacity
                .reduce(0, Integer::sum);   // sum all capacities

        System.out.println("\nTotal Seating Capacity in Train: " + totalSeats + " seats");
// ---------------- UC10 END ----------------
        // ---------------- UC11 START ----------------

        Scanner scanner = new Scanner(System.in);

// Regex patterns
        Pattern trainIdPattern = Pattern.compile("TRN-\\d{4}");
        Pattern cargoCodePattern = Pattern.compile("PET-[A-Z]{2}");

// User input
        System.out.print("\nEnter Train ID (format TRN-1234): ");
        String trainId = scanner.nextLine();

        System.out.print("Enter Cargo Code (format PET-AB): ");
        String cargoCode = scanner.nextLine();

// Validation
        Matcher trainMatcher = trainIdPattern.matcher(trainId);
        Matcher cargoMatcher = cargoCodePattern.matcher(cargoCode);

        if (trainMatcher.matches()) {
            System.out.println("Train ID is valid.");
        } else {
            System.out.println("Invalid Train ID format!");
        }

        if (cargoMatcher.matches()) {
            System.out.println("Cargo Code is valid.");
        } else {
            System.out.println("Invalid Cargo Code format!");
        }
// ---------------- UC11 END ----------------
        // ---------------- UC12 START ----------------


        class GoodsBogie {
            String type;   // e.g., Cylindrical, Rectangular
            String cargo;  // e.g., Petroleum, Coal

            public GoodsBogie(String type, String cargo) {
                this.type = type;
                this.cargo = cargo;
            }

            @Override
            public String toString() {
                return type + " bogie carrying " + cargo;
            }
        }

// Sample goods bogies
        List<GoodsBogie> goodsBogies = new ArrayList<>();
        goodsBogies.add(new GoodsBogie("Cylindrical", "Petroleum"));
        goodsBogies.add(new GoodsBogie("Rectangular", "Coal"));
        goodsBogies.add(new GoodsBogie("Cylindrical", "Petroleum"));
        goodsBogies.add(new GoodsBogie("Open", "Grain"));

// Safety compliance check
        boolean isSafe = goodsBogies.stream()
                .allMatch(b -> !b.type.equals("Cylindrical") || b.cargo.equals("Petroleum"));

// Display result
        System.out.println("\nGoods Bogie Safety Compliance:");
        for (GoodsBogie b : goodsBogies) {
            System.out.println(b);
        }
        System.out.println("Train safety compliant: " + isSafe);
// ---------------- UC12 END ----------------

    }
}