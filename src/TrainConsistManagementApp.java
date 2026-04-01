import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;
import java.util.LinkedList;
import java.util.LinkedHashSet;
import java.util.HashMap;
import java.util.Map;

public class TrainConsistManagementApp {

    public static void main(String[] args) {

        // Welcome Message
        System.out.println("=== Train Consist Management App ===");

        // UC1
        List<String> trainConsist = new ArrayList<>();
        System.out.println("Train consist initialized.");
        System.out.println("Initial number of bogies: " + trainConsist.size());

        // UC2
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

        // UC3
        Set<String> bogieIds = new HashSet<>();

        bogieIds.add("BG101");
        bogieIds.add("BG102");
        bogieIds.add("BG103");
        bogieIds.add("BG101"); // duplicate
        bogieIds.add("BG102"); // duplicate

        System.out.println("\nUnique Bogie IDs:");
        System.out.println(bogieIds);



// ---------------- UC4 START ----------------

// Create LinkedList for Train Consist
        LinkedList<String> orderedTrain = new LinkedList<>();

// Add bogies
        orderedTrain.add("Engine");
        orderedTrain.add("Sleeper");
        orderedTrain.add("AC");
        orderedTrain.add("Cargo");
        orderedTrain.add("Guard");

// Insert Pantry Car at position 2
        orderedTrain.add(2, "Pantry Car");

// Display after insertion
        System.out.println("\nTrain Consist after adding Pantry Car:");
        System.out.println(orderedTrain);

// Remove first and last bogie
        orderedTrain.removeFirst();
        orderedTrain.removeLast();

// Final ordered consist
        System.out.println("\nFinal Ordered Train Consist:");
        System.out.println(orderedTrain);

// ---------------- UC4 END ----------------

        // ---------------- UC5 START ----------------

// Create LinkedHashSet for Train Formation
        LinkedHashSet<String> formation = new LinkedHashSet<>();

// Add bogies
        formation.add("Engine");
        formation.add("Sleeper");
        formation.add("Cargo");
        formation.add("Guard");

// Add duplicate (will be ignored)
        formation.add("Sleeper");

// Display formation
        System.out.println("\nTrain Formation (Insertion Order + Unique):");
        System.out.println(formation);

// ---------------- UC5 END ----------------

        // ---------------- UC6 START ----------------

// Create HashMap for bogie capacities
        HashMap<String, Integer> bogieCapacity = new HashMap<>();

// Add bogie-capacity pairs
        bogieCapacity.put("Sleeper", 72);
        bogieCapacity.put("AC Chair", 54);
        bogieCapacity.put("First Class", 36);

// Display each bogie and its capacity
        System.out.println("\nBogie Capacities:");
        for (Map.Entry<String, Integer> entry : bogieCapacity.entrySet()) {
            System.out.println(entry.getKey() + " → " + entry.getValue() + " seats");
        }

// ---------------- UC6 END ----------------
    }
}