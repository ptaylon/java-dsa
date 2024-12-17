package br.com.studies.binarytree;

public class BinaryTree {

    private Node root;

    public Node getRoot() {
        return root;
    }

    public void addNode(final int value) {

        // If the tree is empty, We are initializing the structure to receive new data
        if (root == null) {
            root = new Node(value);
            return;
        }

        // Else we need to search where the data need to be storage
        Node insertPoint = this.searchNode(
            this.getRoot(),
            value,
            SearchType.SEARCH_INSERTION_POINT
        );

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

    public Node searchNode(final Node node, final int value, final SearchType... searchParameter) {

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

    public Node deleteNode(Node node, final int value) {

        if (node == null)
            return null;

        if (value > node.getData()) {
            node.setRight(deleteNode(node.getRight(), value));
        } else if (value < node.getData()) {
            node.setLeft(deleteNode(node.getLeft(), value));
        } else {

            if (node.hasNoChildren())
                return null;

            if (node.getLeft() == null)
                return deleteNode(node.getRight(), value);

            if (node.getRight() == null)
                return deleteNode(node.getLeft(), value);

            Node successor = findSuccessorNumber(node);
            if (successor != null) {
                node.setData(successor.getData());
                node.setRight(deleteNode(node.getRight(), node.getData()));
            }

        }

        return node;

    }

    private static Node findSuccessorNumber(final Node node) {
        Node sucessor = node.getRight();
        while (sucessor != null && sucessor.getLeft() != null) {
            sucessor = sucessor.getLeft();
        }
        return sucessor;
    }

    public void print(final PrinterType printerType) {

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

    private void printTreePreOrderTraversal(final Node node) {

        if (node == null)
            return;

        System.out.println(node);
        printTreePreOrderTraversal(node.getLeft());
        printTreePreOrderTraversal(node.getRight());

    }

    private void printTreeInOrderTraversal(final Node node) {

        if (node == null)
            return;

        printTreeInOrderTraversal(node.getLeft());
        System.out.println(node);
        printTreeInOrderTraversal(node.getRight());

    }

}