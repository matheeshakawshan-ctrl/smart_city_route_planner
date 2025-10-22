package smartcity.management;

import smartcity.graph.Graph;

public class LocationManager {
    private Graph cityGraph;

    public LocationManager(Graph graph) {
        this.cityGraph = graph;
    }

    public void addLocation(String name) {
        cityGraph.addLocation(name);
    }

    public void removeLocation(String name) {
        cityGraph.removeLocation(name);
    }

    public void addRoad(String from, String to) {
        cityGraph.addRoad(from, to);
    }

    public void removeRoad(String from, String to) {
        cityGraph.removeRoad(from, to);
    }

    public void displayConnections() {
        cityGraph.displayConnections();
    }
}

