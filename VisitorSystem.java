import java.util.*;

class Visitor {
    String name;
    String contact;
    String purpose;
    String entryTime;
    String exitTime;

    Visitor(String name, String contact, String purpose, String entryTime) {
        this.name = name;
        this.contact = contact;
        this.purpose = purpose;
        this.entryTime = entryTime;
        this.exitTime = "Not Exited";
    }
}

public class VisitorSystem {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Visitor> list = new ArrayList<>();

    // Login Module
    static boolean login() {
        String username, password;
       System.out.print("Enter Username: ");
username = sc.nextLine();
System.out.print("Enter Password: ");
password = sc.nextLine();

        if (username.equals("admin") && password.equals("1234")) {
            System.out.println("Login Successful!");
            return true;
        } else {
            System.out.println("Invalid Login!");
            return false;
        }
    }

    // Visitor Entry
    static void addVisitor() {
        sc.nextLine(); 
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Contact: ");
        String contact = sc.nextLine();
        System.out.print("Enter Purpose: ");
        String purpose = sc.nextLine();
        System.out.print("Enter Entry Time: ");
        String entryTime = sc.nextLine();

        list.add(new Visitor(name, contact, purpose, entryTime));
        System.out.println("Visitor Added Successfully!");
    }

    // Visitor Exit
    static void updateExit() {
        System.out.print("Enter Visitor Name: ");
        sc.nextLine();
        String name = sc.nextLine();

        for (Visitor v : list) {
            if (v.name.equalsIgnoreCase(name)) {
                System.out.print("Enter Exit Time: ");
                v.exitTime = sc.nextLine();
                System.out.println("Exit Updated!");
                return;
            }
        }
        System.out.println("Visitor Not Found!");
    }

    // Display Report
    static void displayVisitors() {
        System.out.println("\n---- VISITOR REPORT ----");
        for (Visitor v : list) {
            System.out.println("Name: " + v.name);
            System.out.println("Contact: " + v.contact);
            System.out.println("Purpose: " + v.purpose);
            System.out.println("Entry Time: " + v.entryTime);
            System.out.println("Exit Time: " + v.exitTime);
            System.out.println("------------------------");
        }
    }

    public static void main(String[] args) {
        if (!login()) return;

        int choice;
        do {
            System.out.println("\n1. Add Visitor");
            System.out.println("2. Update Exit");
            System.out.println("3. Display Visitors");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addVisitor();
                    break;
                case 2:
                    updateExit();
                    break;
                case 3:
                    displayVisitors();
                    break;
                case 4:
                    System.out.println("Exiting System...");
                    break;
                default:
                    System.out.println("Invalid Choice!");
            }
        } while (choice != 4);
    }
}