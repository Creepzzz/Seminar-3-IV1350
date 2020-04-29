package se.kth.iv1350.amazingpos.model;

import se.kth.iv1350.amazingpos.integration.*;
import se.kth.iv1350.amazingpos.util.*;
/**
 * Represent the total with VAT included.
 */

public class Total {
	private Amount totalPrice;
	private Amount totalVAT;
	
	/**
	 * Creating an instance of a total
	 */
	public Total() {
		this.totalPrice = new Amount(0);
		this.totalVAT = new Amount(0);
	}
	
	/**
	 * Getter of total price
	 * 
	 * @return     The total price
	 */
	public Amount getTotalPrice() {
		return totalPrice;
	}

	/**
	 * Getter of total VAT
	 * 
	 * @return    The total VAT
	 */
	public Amount getTotalVAT() {
		return totalVAT;
	}

	/**
	 * Getter of total with VAT included
	 *
	 * @return     The total price with VAT
	 */
	public Amount getTotalPriceWithVAT() {
		return totalPrice.add(totalVAT);
	}

	/**
     * Updated the total according to item and corresponding price/VAT
     *
     * @param item     The item that updates the total
     */
	 public void updateTotal(Item item){
	        if(item == null){
	            return;
	        }
				Amount amountOfItems = item.getQuantity();
				Amount itemPrice = item.getItemDescription().getPrice();
				Amount itemVAT = item.getItemDescription().getVAT();
		 	this.totalVAT = this.totalVAT.add(amountOfItems.multiply(itemVAT));
		 	this.totalPrice = this.totalPrice.add(amountOfItems.multiply(itemPrice));
	    }
}
