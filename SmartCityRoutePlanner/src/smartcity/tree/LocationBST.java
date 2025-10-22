package smartcity.tree;

public class LocationBST {
    private LocationNode root;

    public void insert(String name) {
        root = insertRec(root, name);
    }

    private LocationNode insertRec(LocationNode root, String name) {
        if (root == null) return new LocationNode(name);
        if (name.compareToIgnoreCase(root.name) < 0)
            root.left = insertRec(root.left, name);
        else if (name.compareToIgnoreCase(root.name) > 0)
            root.right = insertRec(root.right, name);
        return root;
    }

    public void delete(String name) {
        root = deleteRec(root, name);
    }

    private LocationNode deleteRec(LocationNode root, String name) {
        if (root == null) return null;
        if (name.compareToIgnoreCase(root.name) < 0)
            root.left = deleteRec(root.left, name);
        else if (name.compareToIgnoreCase(root.name) > 0)
            root.right = deleteRec(root.right, name);
        else {
            if (root.left == null) return root.right;
            else if (root.right == null) return root.left;
            root.name = minValue(root.right);
            root.right = deleteRec(root.right, root.name);
        }
        return root;
    }

    private String minValue(LocationNode root) {
        String minv = root.name;
        while (root.left != null) {
            minv = root.left.name;
            root = root.left;
        }
        return minv;
    }

    public void displayAll() {
        if (root == null) System.out.println("No locations found!");
        else inorder(root);
    }

    private void inorder(LocationNode root) {
        if (root != null) {
            inorder(root.left);
            System.out.println(" - " + root.name);
            inorder(root.right);
        }
    }

    public boolean search(String name) {
        return searchRec(root, name);
    }

    private boolean searchRec(LocationNode root, String name) {
        if (root == null) return false;
        if (root.name.equalsIgnoreCase(name)) return true;
        if (name.compareToIgnoreCase(root.name) < 0)
            return searchRec(root.left, name);
        else
            return searchRec(root.right, name);
    }
}

