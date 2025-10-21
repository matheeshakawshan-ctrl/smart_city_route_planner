package smartcity.graph;

import java.util.*;

public class Graph {
    private Map<String, List<String>> adjList;

    public Graph() {
        adjList = new HashMap<>();
    }

    // Add a new location (vertex)
    public void addLocation(String name) {
        if (!adjList.containsKey(name)) {
            adjList.put(name, new ArrayList<>());
            System.out.println(name + " added!");
        } else {
            System.out.println(name + " already exists!");
        }
    }

    // Remove a location (vertex)
    public void removeLocation(String name) {
        if (adjList.containsKey(name)) {
            adjList.remove(name);
            for (List<String> neighbors : adjList.values()) {
                neighbors.remove(name);
            }
            System.out.println(name + " removed!");
        } else {
            System.out.println(name + " not found!");
        }
    }

    // Add a road (edge)
    public void addRoad(String from, String to) {
        if (adjList.containsKey(from) && adjList.containsKey(to)) {
            adjList.get(from).add(to);
            adjList.get(to).add(from); // because undirected
            System.out.println("Road added between " + from + " and " + to);
        } else {
            System.out.println("One or both locations do not exist!");
        }
    }

    // Remove a road (edge)
    public void removeRoad(String from, String to) {
        if (adjList.containsKey(from) && adjList.containsKey(to)) {
            adjList.get(from).remove(to);
            adjList.get(to).remove(from);
            System.out.println("Road removed between " + from + " and " + to);
        } else {
            System.out.println("One or both locations do not exist!");
        }
    }

    // Display all connections
    public void displayConnections() {
        for (String loc : adjList.keySet()) {
            System.out.println(loc + " -> " + adjList.get(loc));
        }
    }
}
