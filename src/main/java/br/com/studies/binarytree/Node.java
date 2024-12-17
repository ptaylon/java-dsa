package br.com.studies.binarytree;

public class Node {

    private int data;

    private Node left;

    private Node right;

    @Override
    public String toString() {
        return "Node{" + "data=" + data + '}';
    }

    public Node(final int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(final int data) {
        this.data = data;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(final Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(final Node right) {
        this.right = right;
    }

    public boolean hasNoChildren() {
        return this.getRight() == null && this.getLeft() == null;
    }

}