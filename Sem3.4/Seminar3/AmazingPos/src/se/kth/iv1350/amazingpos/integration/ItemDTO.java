package se.kth.iv1350.amazingpos.integration;

import se.kth.iv1350.amazingpos.util.*;
public class ItemDTO {
	private String itemName;
	private Amount VAT;
	private Amount price;
	
	/**
	 * Creates a DTO with item information
	 * 
	 * @param price the price of the item
	 * @param VAT the VAT amount for the item
	 * @param itemName The Name of the item
	 */
	public ItemDTO(Amount price, Amount VAT,  String itemName) {
		this.itemName = itemName;
		this.price = price;
		this.VAT = VAT;
	}

	/**
	 * Getter of price of specified item
	 * 
	 * @return        The price for the specified item
	 */
	public Amount getPrice() {
		return price;
	}

	/**
	 * Getter of VAT of specified item
	 * 
	 * @return      The tem VAT
	 */
	public Amount getVAT() {
		return VAT;
	}

	/**
	 * Getter of item name
	 * 
	 * @return     Item name
	 */
	public String getItemName() {
		return itemName;
	}

	/**
	 * Creates string with gathered item information
	 *
	 * @return     The string with item information
	 */
	@Override
	public String toString() {
		String builder = "Item name: " + itemName + "\t" +
				" | Price: " + price + "\t" +
				" | Tax amount: " + VAT + "\t";
		return builder;
	}
}
