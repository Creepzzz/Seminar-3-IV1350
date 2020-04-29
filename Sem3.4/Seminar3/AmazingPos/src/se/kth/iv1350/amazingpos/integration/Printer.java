package se.kth.iv1350.amazingpos.integration;
import se.kth.iv1350.amazingpos.model.*;

public class Printer {
    /**
     * New instance of type printer
     */
    public Printer(){
    }

    /**
     * Prints the receipt
     * @param receipt     The receipt of the purchase
     */
    public static void printReceipt(Receipt receipt){
        System.out.println(receipt.toString());
    }
}