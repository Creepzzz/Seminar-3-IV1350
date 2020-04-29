package se.kth.iv1350.amazingpos.model;

import se.kth.iv1350.amazingpos.integration.Item;
import se.kth.iv1350.amazingpos.util.Amount;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.*;

/**
 * One single sale made by one single customer and payed with one payment
 */
public class Sale {
	private Total total;
	private HashMap<String, Item> items = new HashMap<>();
	private Date saleEnded;
	private Date time;
	private String startTime;

	/**
	 * Instance of sale
	 */
	public Sale(){
		this.total = new Total();
		time = Calendar.getInstance().getTime();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
		startTime = dateFormat.format(time);
	}

	/**
	 *Gets the start time of the sale
	 *
	 * @return    The start time for the sale
	 */
	public String startTime(){
		return startTime;
	}

	/**
	 * Gets the end time of the sale
	 *
	 * @return    The end time for the sale
	 */
	public String endTime(){
		saleEnded = Calendar.getInstance().getTime();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
		String endTime = dateFormat.format(time);
		return endTime;
	}

	/**
	 * Getter of total cost
	 *
	 * @return       The total cost
	 */
	public Total getTotal() {
		return total;
	}

	/**
	 * Getter of items
	 *
	 * @return    The items from the hashmap
	 */
	public HashMap<String, Item> getItems(){
		return items;
	}

	/**
	 * Updates the sale with valid item
	 *
	 * @param item   The item that will be added to the sale
	 * @return       The information about the item in the sale
	 */
	public String updateSale(Item item){
		if (itemListContains(item)) {
			updateItemQuantityAndTotal(item);
			Item oldItem = items.get(item.getItemIdentifier());
			return oldItem.getItemDescription().toString() + " | Quantity: " +oldItem.getQuantity().getAmount() + "\t";
		} else {
			addValidItem(item);
			return item.getItemDescription().toString() + " | Quantity: " +item.getQuantity().getAmount() + "\t";
		}
	}

	/**
	 * Checks if the item exist in the inventory
	 *
	 * @param item   The item to be added to the sale
	 * @return       True if item exists, false if it doesn't
	 */
	private boolean itemListContains(Item item){
		return items.containsKey(item.getItemIdentifier());
	}

	/**
	 * Updates the quantity of specified item in sale
	 * @param item     The item specified
	 */
	private void updateItemQuantityAndTotal(Item item){
		Item oldItem = items.get(item.getItemIdentifier());
		oldItem.increaseQuantity(new Amount(1));
		items.put(oldItem.getItemIdentifier(), oldItem);
		total.updateTotal(item);
	}

	/**
	 * Adds item to the sale
	 * @param item      The specified item
	 */
	private void addValidItem(Item item){
		items.put(item.getItemIdentifier(), item);
		total.updateTotal(item);
	}

	/**
	 * Displays the sale as a string
	 *
	 * @return     The sale as a string
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		Iterator entriesIterator = getEntries();

		while(entriesIterator.hasNext()) {
			Item item = getCurrentItem(entriesIterator);
			builder.append(item.getItemDescription().toString());
			addNewLine(builder, " | Quantity: " + item.getQuantity().toString());
		}

		addNewLine(builder, "Total: " + total.getTotalPrice().toString());
		addNewLine(builder, "VAT: " + total.getTotalVAT().toString());
		return builder.toString();
	}

	/**
	 * Iterator used for the entries
	 * @return    An iterator for entries
	 */
	private Iterator getEntries(){
		Set entries = items.entrySet();
		return entries.iterator();
	}

	/**
	 * Getter for current item for the iteration
	 *
	 * @param entriesIterator    Iterator to go through the set
	 * @return                   The current item
	 */
	private Item getCurrentItem(Iterator entriesIterator){
		Map.Entry mapping = (Map.Entry) entriesIterator.next();
		return (Item) mapping.getValue();
	}

	/**
	 * Adds new line to a string builder
	 * @param builder     The string builder
	 * @param line        A string of a line
	 */
	private void addNewLine(StringBuilder builder, String line){
		builder.append(line);
		builder.append("\n");
	}
}
