package sample;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

public class BTView extends Pane {
    private BST tree = new BST();
    private double radius = 15; // Tree node radius
    private double vGap = 50; // Gap between two levels in a tree

    public BTView(BST tree) {
        this.tree = tree;
    }

    public void displayTree() {
        this.getChildren().clear(); // Clear the pane
        if (tree.getRoot() != null) {
            // Display tree recursively
            displayTree(tree.getRoot(), 350, vGap,
                    150);
        }
    }

    private void displayTree(TreeNode root,
                             double x, double y, double hGap) {
        if (root.left != null) {
            // Draw a line to the left node
            getChildren().add(new Line(x - hGap, y + vGap, x, y));
            // Draw the left subtree recursively
            displayTree(root.left, x - hGap, y + vGap, hGap / 2);
        }

        if (root.right != null) {
            // Draw a line to the right node
            getChildren().add(new Line(x + hGap, y + vGap, x, y));
            // Draw the right subtree recursively
            displayTree(root.right, x + hGap, y + vGap, hGap / 2);
        }

        // Display a node
        Circle circle = new Circle(x, y, radius);
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);
        if (root.elementNumber == 3) {
            getChildren().addAll(circle,
                    new Text(x - 4, y + 4, "  "));
        } else
            getChildren().addAll(circle,
                    new Text(x - 4, y + 4, root.element + ""));
    }
}