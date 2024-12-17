package br.com.studies.binarytree;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class MenuConsole {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        BinaryTree binaryTree = new BinaryTree();

        while (!exit) {

            System.out.println("\n====== Binary Tree Operations Menu ======");
            System.out.println("1. Add Node");
            System.out.println("2. Add multiple values");
            System.out.println("3. Print Tree");
            System.out.println("4. Search Node");
            System.out.println("5. Delete Node");
            System.out.println("6. Exit");
            System.out.print("Select an option (1-6): ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number between 1 and 5.");
                continue;
            }

            switch (choice) {

                case 1:

                    System.out.print("Enter the value to add: ");

                    try {

                        int valueToAdd = Integer.parseInt(scanner.nextLine());
                        binaryTree.addNode(valueToAdd);

                        System.out.println("Node with value " + valueToAdd + " added.");

                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Please enter a valid integer.");
                    }

                    break;

                case 2:

                    System.out.print("Add multiple values separated by space: ");

                    try {

                        String valuesToAdd = scanner.nextLine();
                        Arrays.stream(valuesToAdd.split(" "))
                            .mapToInt(Integer::parseInt)
                            .forEach(binaryTree::addNode);

                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Please enter a valid integer.");
                    }

                    break;

                case 3:

                    System.out.println("There are these type printer, select one: ");
                    System.out.println("""
                        PRE_ORDER_TRAVERSAL -> 0,
                        IN_ORDER_TRAVERSAL -> 1,
                        POST_ORDER_TRAVERSAL -> 2;
                        """);
                    System.out.print("Option: ");

                    try {

                        int printType = Integer.parseInt(scanner.nextLine());
                        binaryTree.print(PrinterType.getPrinterTypeByValue(printType));
                        System.out.println("Click either key to continue...");
                        System.in.read();

                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Please enter a valid integer.");
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                    break;

                case 4:

                    System.out.print("Enter the value to search for: ");

                    try {

                        int valueToSearch = Integer.parseInt(scanner.nextLine());
                        Node node = binaryTree.searchNode(binaryTree.getRoot(), valueToSearch);

                        if (node != null) {
                            System.out.println("Searched for node with value: " + node.getData());
                        } else {
                            System.out.println("Typed value not founded");
                        }

                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Please enter a valid integer.");
                    }

                    break;

                case 5:

                    System.out.print("Enter the value to delete: ");

                    try {

                        int valueToDelete = Integer.parseInt(scanner.nextLine());
                        System.out.println("Node with value " + valueToDelete + " deleted.");

                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Please enter a valid integer.");
                    }

                    break;

                case 6:

                    System.out.println("Exiting the program. Goodbye!");
                    exit = true;

                    break;

                default:
                    System.out.println("Invalid choice. Please select a number between 1 and 5.");
            }
        }

        scanner.close();

    }

}