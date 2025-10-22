package smartcity.tree;

public class LocationNode {
    String name;
    LocationNode left, right;

    public LocationNode(String name) {
        this.name = name;
        left = right = null;
    }
}
