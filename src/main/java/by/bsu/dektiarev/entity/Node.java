package by.bsu.dektiarev.entity;

import java.util.Objects;

/**
 * Created by USER on 25.11.2016.
 */
public class Node implements Comparable<Node> {

    private String symbol;
    private double value;
    private Node parent;
    private Node leftChild;
    private Node rightChild;

    public Node(double value) {
        this.value = value;
    }

    public Node(String symbol, double value) {
        this.symbol = symbol;
        this.value = value;
    }

    @Override
    public int compareTo(Node o) {
        return new Double(value).compareTo(o.value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return Double.compare(node.value, value) == 0 &&
                Objects.equals(symbol, node.symbol) &&
                Objects.equals(parent, node.parent) &&
                Objects.equals(leftChild, node.leftChild) &&
                Objects.equals(rightChild, node.rightChild);
    }

    @Override
    public int hashCode() {
        return Objects.hash(symbol, value, parent, leftChild, rightChild);
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", leftChild=" + leftChild +
                ", rightChild=" + rightChild +
                '}';
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }
}
