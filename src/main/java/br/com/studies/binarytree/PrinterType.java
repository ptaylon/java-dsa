package br.com.studies.binarytree;

import java.util.Arrays;

public enum PrinterType {

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