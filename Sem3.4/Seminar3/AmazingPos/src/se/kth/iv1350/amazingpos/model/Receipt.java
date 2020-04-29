package se.kth.iv1350.amazingpos.model;

import java.time.LocalDateTime;
/**
 * Represents one receipt, which proves the payment of one sale
 */
public class Receipt {
    private Sale sale;
    private Payment payment;
    private LocalDateTime saleDate;
    private String beganTime;
    private String endTime;


    /**
     * Creates an instance of type receipt
     *
     * @param sale    The sale information
     * @param payment The payment information
     */
    public Receipt(Sale sale, Payment payment){
        this.payment = payment;
        this.sale = sale;
        beganTime = sale.startTime();
        endTime = sale.endTime();
    }

    /**
     * Creates a receipt formula
     *
     * @return      The string displaying the receipt
     */
    public String toString(){
        saleDate =LocalDateTime.now();
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        sb.append("------------RECEIPT-----------" + "\n");
        sb.append("Sale began: " + beganTime + "\n");
        sb.append("Store name: Some store\n");
        sb.append("Address: Store street\n");
        sb.append("*Phone number*\n");
        sb.append("www.thisstore.se\n");
        sb.append("ITEMS:\n");
        sb.append(sale.toString());
        sb.append("Paid SEK: " +payment.getPaidAmount().getAmount()+ "\n");
        sb.append("Change SEK: " +payment.getChange().toString()+ "\n");
        sb.append("Sale ended: " +endTime+"\n");
        sb.append("---------------END--------------");
        return sb.toString();
    }
}