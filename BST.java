package sample;

public class BST implements Tree {
    private TreeNode root;

    // Create a default binary search tree
    public BST() {
    }

    @Override
    // Return true if the element is in the tree
    public boolean search(Integer e) {
        TreeNode current = root; // Start from the root

        while (current != null) {
            if (e.compareTo(current.element) < 0) {
                current = current.left;
            } else if (e.compareTo(current.element) > 0) {
                current = current.right;
            } else // element matches current.element
                return true; // Element is found
        }

        return false;
    }

    @Override
    // Insert element e into the binary search tree.
    //Return true if the element is inserted successfully. */
    public boolean insert(Integer e , Integer elementNumber) {

        if (root == null)
            root = createNewNode(e,elementNumber); // Create a new root
        else {
            // Locate the parent node
            TreeNode parent = null;
            TreeNode current = root;
            while (current != null)
                if (e.compareTo(current.element) < 0) {
                    parent = current;
                    current = current.left;
                } else if (e.compareTo(current.element) > 0) {
                    parent = current;
                    current = current.right;
                } else
                    return false; // Duplicate node not inserted
            // Create the new node and attach it to the parent node
            if (e.compareTo(parent.element) < 0)
                parent.left = createNewNode(e,elementNumber);
            else
                parent.right = createNewNode(e,elementNumber);
        }

        return true; // Element inserted successfully
    }

    public TreeNode createNewNode(Integer e, Integer elementNumber) {
        return new TreeNode(e,elementNumber);
    }

    //Returns the root of the tree
    public TreeNode getRoot() {
        return root;
    }


}

