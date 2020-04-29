package se.kth.iv1350.amazingpos.model;

import se.kth.iv1350.amazingpos.util.Amount;

public class Payment{

    private Amount paidAmount;
    private Total total;

    /**
     * Creates a instance of payment
     * @param paidAmount     The amount customer has paid
     * @param total          The total price that is to be paid
     */
    public Payment(Amount paidAmount, Total total){
        this.paidAmount = paidAmount;
        this.total = total;
    }

    /**
     *  Will give you the amount paid
     * @return     The amount paid
     */
    public Amount getPaidAmount(){
        return paidAmount;
    }

    /**
     * Getter of the amount of change the customer is to be given
     * @return      Returns the amount of change the customer is to be given
     */
    public Amount getChange(){
        return paidAmount.decrease(total.getTotalPriceWithVAT());
    }
}
