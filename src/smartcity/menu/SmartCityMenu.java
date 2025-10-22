package smartcity.menu;

import smartcity.graph.Graph;
import smartcity.management.LocationManager;
import smartcity.tree.LocationBST;

import java.util.Scanner;

public class SmartCityMenu {
    private Graph graph;
    private LocationManager manager;
    private LocationBST bst;

    public SmartCityMenu() {
        graph = new Graph();
        manager = new LocationManager(graph);
        bst = new LocationBST();
    }

    public void start() {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n--- Smart City Route Planner ---");
            System.out.println("1. Add a new location");
            System.out.println("2. Remove a location");
            System.out.println("3. Add a road between locations");
            System.out.println("4. Remove a road");
            System.out.println("5. Display all connections");
            System.out.println("6. Display all locations (BST)");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch(choice) {
                case 1:
                    System.out.print("Enter location name: ");
                    String nameAdd = sc.nextLine();
                    manager.addLocation(nameAdd);
                    bst.insert(nameAdd);
                    break;
                case 2:
                    System.out.print("Enter location name to remove: ");
                    String nameRemove = sc.nextLine();
                    manager.removeLocation(nameRemove);
                    bst.delete(nameRemove);
                    break;
                case 3:
                    System.out.print("Enter first location: ");
                    String from = sc.nextLine();
                    System.out.print("Enter second location: ");
                    String to = sc.nextLine();
                    manager.addRoad(from, to);
                    break;
                case 4:
                    System.out.print("Enter first location: ");
                    String rfrom = sc.nextLine();
                    System.out.print("Enter second location: ");
                    String rto = sc.nextLine();
                    manager.removeRoad(rfrom, rto);
                    break;
                case 5:
                    manager.displayConnections();
                    break;
                case 6:
                    bst.displayAll();
                    break;
                case 7:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
            }

        } while(choice != 7);
        sc.close();
    }

    public static void main(String[] args) {
        SmartCityMenu menu = new SmartCityMenu();
        menu.start();
    }
}