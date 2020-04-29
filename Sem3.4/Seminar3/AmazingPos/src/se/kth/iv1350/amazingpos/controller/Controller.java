package se.kth.iv1350.amazingpos.controller;

import se.kth.iv1350.amazingpos.integration.*;
import se.kth.iv1350.amazingpos.model.Payment;
import se.kth.iv1350.amazingpos.model.Receipt;
import se.kth.iv1350.amazingpos.model.Sale;
import se.kth.iv1350.amazingpos.util.Amount;

/**
  * This is the application's only controller. All calls to the model pass through this class.
 */

public class Controller {
	private Sale sale;
	private InventorySystem inventorySystem;
	private AccountingSystem accountingSystem;
	private ItemCatalog itemCatalog;
	private Printer printer;

	/**
	 * Starts a new sale. This method must be called first before the process of a sale.
	 */
	public void startSale() {
		this.sale = new Sale();
	}

  /**
   * Creator of controller
   *
   * @param systemCreator     Getter of classes of external system calls
   * @param catalogCreator    Getter of classes of external catalog calls
   * @param printer           Interface to the printer
   */
	public Controller(SystemCreator systemCreator, CatalogCreator catalogCreator, Printer printer){
		this.accountingSystem = systemCreator.getAccountingSystem();
		this.inventorySystem = systemCreator.getInventorySystem();
		this.itemCatalog = catalogCreator.getItemCatalog();
		this.printer = printer;
	}

	/**
	 * The validity of the item is checked
	 * Gets item from the catalog and adds it to the sale
	 * Updates the catalog
	 *
	 * @param itemIdentifier    Specify the item
	 * @param quantity          Specify the number of items
	 */
	public String registerItem(String itemIdentifier, Amount quantity){
		if(checkItem(itemIdentifier)){
			Item item = itemCatalog.getItem(itemIdentifier,quantity);
			return sale.updateSale(item)+" | Total price: "+ sale.getTotal().getTotalPriceWithVAT().getAmount();
		}
		return "Total price: " + sale.getTotal().toString();
	}

	/**
	 * Checks validity of an item
	 * @param itemIdentifier   Specify the item
	 * @return                 Returns true if item exists
	 */
	public boolean checkItem(String itemIdentifier){
		return itemCatalog.validItem(itemIdentifier);
	}

	/**
	 * Creates a payment, adds the amount paid and nullifies the sale
	 *
	 * @param paidAmount      Specifies the amount customer has paid
	 */
	public String paid(Amount paidAmount){
		Payment payment = new Payment(paidAmount, sale.getTotal());
		accountingSystem.updateAccount(sale);
		inventorySystem.updateInventory(sale);
		Receipt receipt = new Receipt(sale, payment);
		printer.printReceipt(receipt);
		sale = null;
		return "";
	}

	/**
	 * Gets full string with the total cost with taxes included
	 *
	 * @return       The string that displays the total cost with taxes
	 */
	public String displayTotalWithTax(){
		return "Total with taxes: " + sale.getTotal().getTotalPriceWithVAT().toString();
	}
}
