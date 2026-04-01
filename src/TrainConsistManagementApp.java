import java.util.ArrayList;
import java.util.List;

public class TrainConsistManagementApp {

    public static void main(String[] args) {

        // Welcome Message
        System.out.println("=== Train Consist Management App ===");

        // Initialize Train Consist (Empty List)
        List<String> trainConsist = new ArrayList<>();

        // Display Initial Bogie Count
        System.out.println("Train consist initialized.");
        System.out.println("Initial number of bogies: " + trainConsist.size());

        // Program continues...
        System.out.println("System ready for further operations.");

        import java.util.ArrayList;
import java.util.List;

        public class TrainConsistManagementApp {

            public static void main(String[] args) {

                // Welcome Message
                System.out.println("=== Train Consist Management App ===");

                // UC1: Initialize Train Consist
                List<String> trainConsist = new ArrayList<>();
                System.out.println("Train consist initialized.");
                System.out.println("Initial number of bogies: " + trainConsist.size());

                // ---------------- UC2 START ----------------

                // Add Passenger Bogies
                trainConsist.add("Sleeper");
                trainConsist.add("AC Chair");
                trainConsist.add("First Class");

                // Display Bogies
                System.out.println("\nPassenger bogies after addition:");
                System.out.println(trainConsist);

                // Remove a bogie (AC Chair)
                trainConsist.remove("AC Chair");
                System.out.println("\nAfter removing AC Chair:");
                System.out.println(trainConsist);

                // Check existence
                boolean isSleeperPresent = trainConsist.contains("Sleeper");
                System.out.println("\nIs Sleeper present? " + isSleeperPresent);

                // Final state
                System.out.println("\nFinal Train Consist:");
                System.out.println(trainConsist);

                // ---------------- UC2 END ----------------
            }
        }
    }
}