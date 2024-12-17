package br.com.studies.binarytree;

import java.util.List;

public class Test {

    public static void main(String[] args) {

        BinaryTree binaryTree = new BinaryTree();

//        List.of(50, 40, 60, 55, 53, 54, 56, 61, 66)
//                .forEach(binaryTree::addNode);

        List.of(50, 30, 70, 20, 40, 60, 80, 10, 25, 45, 75, 85, 15)
                .forEach(binaryTree::addNode);

        binaryTree.deleteNode(binaryTree.getRoot(), 30);
        binaryTree.print(PrinterType.IN_ORDER_TRAVERSAL);

    }

}