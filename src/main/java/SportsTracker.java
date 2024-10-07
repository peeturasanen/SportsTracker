import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SportsTracker {
    static class Activity {
        String name;
        int duration; // in minutes

        Activity(String name, int duration) {
            this.name = name;
            this.duration = duration;
        }

        @Override
        public String toString() {
            return name + ": " + duration + " minutes";
        }
    }

    private static List<Activity> activities = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Log Activity");
            System.out.println("2. View Activities");
            System.out.println("3. Calculate Total Time");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    logActivity(scanner);
                    break;
                case 2:
                    viewActivities();
                    break;
                case 3:
                    calculateTotalTime();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void logActivity(Scanner scanner) {
        System.out.print("Enter activity name: ");
        String name = scanner.nextLine();
        System.out.print("Enter duration in minutes: ");
        int duration = scanner.nextInt();
        scanner.nextLine(); // consume newline
        activities.add(new Activity(name, duration));
        System.out.println("Activity logged successfully.");
    }

    private static void viewActivities() {
        if (activities.isEmpty()) {
            System.out.println("No activities logged.");
        } else {
            System.out.println("Logged Activities:");
            for (Activity activity : activities) {
                System.out.println(activity);
            }
        }
    }

    private static void calculateTotalTime() {
        int totalTime = 0;
        for (Activity activity : activities) {
            totalTime += activity.duration;
        }
        System.out.println("Total time spent on sports: " + totalTime + " minutes");
    }
}