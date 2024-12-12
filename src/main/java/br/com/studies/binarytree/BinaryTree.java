package br.com.studies.binarytree;

import java.util.Arrays;
import java.util.Scanner;

public class BinaryTree {

    enum SearchType {
        SEARCH_INSERTION_POINT,
        SEARCH_ELEMENT_EXISTS
    }

    enum PrinterType {

        PRE_ORDER_TRAVERSAL(0),
        IN_ORDER_TRAVERSAL(1),
        POST_ORDER_TRAVERSAL(2);

        PrinterType(int value){
            this.value = value;
        }

        private final int value;

        public int getValue() {
            return value;
        }

        public static PrinterType getPrinterTypeByValue(int value) {
            return Arrays.stream(PrinterType.values())
                .filter(printerType -> printerType.getValue() == value)
                .findFirst()
                .orElse(null);
        }

    }

    static class Tree {

        private Node root;

        public Node getRoot() {
            return root;
        }

        public void addNode(int value) {

            // If the tree is empty, We are initializing the structure to receive new data
            if (root == null) {
                root = new Node(value);
                return;
            }

            // Else we need to search where the data need to be storage
            Node insertPoint = searchNode(this.getRoot(), value, SearchType.SEARCH_INSERTION_POINT);

            if (insertPoint.getData() == value) {
                System.out.println("This node already exists, no operations were performed");
                return;
            }

            Node element = new Node(value);

            if (value > insertPoint.getData()) {
                insertPoint.setRight(element);
                return;
            }

            insertPoint.setLeft(element);

        }

        public Node searchNode(Node node, int value, SearchType... searchParameter) {

            if (node == null)
                return null;

            if (node.getData() == value)
                return node;

            SearchType searchType = searchParameter.length < 1 ? SearchType.SEARCH_ELEMENT_EXISTS : searchParameter[0];
            Node nextNode;

            if (value > node.getData()) {

                nextNode = searchType.equals(SearchType.SEARCH_ELEMENT_EXISTS) ? node.getRight() : node;
                return node.getRight() == null ? nextNode : this.searchNode(node.getRight(), value, searchType);

            } else {

                nextNode = searchType.equals(SearchType.SEARCH_ELEMENT_EXISTS) ? node.getLeft() : node;
                return node.getLeft() == null ? nextNode : this.searchNode(node.getLeft(), value, searchType);

            }

        }

        public void deleteNode(int value) {

        }

        public void print(PrinterType printerType) {

            switch (printerType) {
                case IN_ORDER_TRAVERSAL -> this.printTreeInOrderTraversal(this.getRoot());
                case PRE_ORDER_TRAVERSAL -> this.printTreePreOrderTraversal(this.getRoot());
                case POST_ORDER_TRAVERSAL -> this.printTreePostOrderTraversal(this.getRoot());
            }

        }

        private void printTreePostOrderTraversal(final Node node) {

            if (node == null)
                return;

            printTreePostOrderTraversal(node.getLeft());
            printTreePostOrderTraversal(node.getRight());

            System.out.println(node);


        }

        private void printTreePreOrderTraversal(Node node) {

            if (node == null)
                return;

            System.out.println(node);
            printTreePreOrderTraversal(node.getLeft());
            printTreePreOrderTraversal(node.getRight());

        }

        private void printTreeInOrderTraversal(Node node) {

            if (node == null)
                return;

            printTreeInOrderTraversal(node.getLeft());
            System.out.println(node);
            printTreeInOrderTraversal(node.getRight());

        }

    }

    static class Node {

        private Integer data;

        private Node left;

        private Node right;

        @Override
        public String toString() {
            return "Node{" + "data=" + data + '}';
        }

        public Node(final Integer data) {
            this.data = data;
        }

        public Integer getData() {
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

    }

}