package se.kth.iv1350.amazingpos.integration;

import se.kth.iv1350.amazingpos.util.*;

/**
 * Represents an Item.
 */
public class Item {
    private ItemDTO itemDescription;
    private String itemIdentifier;
    private Amount quantity;

    /**
     * Creates a new instance of an item
     *
     * @param itemDescription   The description of an item
     * @param itemIdentifier    The identifier of an item
     * @param quantity          The amount of specified item
     */
    public Item(ItemDTO itemDescription, String itemIdentifier, Amount quantity) {
        this.itemDescription = itemDescription;
        this.itemIdentifier = itemIdentifier;
        this.quantity = quantity;
    }

    /**
     * Will increase the quantity of specified item
     *
     * @param otherQuantity The {@link Amount} that will be added to the quantity
     */
    public void increaseQuantity(Amount otherQuantity){
        this.quantity = this.quantity.add(otherQuantity);
    }

    /**
     * Will decrease the quantity of specified item
     *
     * @param otherQuantity The {@link Amount} that will be subtracted to the quantity
     */
    public void decreaseQuantity(Amount otherQuantity){
        this.quantity = this.quantity.decrease(otherQuantity);
    }

    /**
     * Getter of quantity
     *
     * @return     The quantity
     */
    public Amount getQuantity() {
        return quantity;
    }

    /**
     * Getter of item description
     *
     * @return    The itemDescription
     */
    public ItemDTO getItemDescription() {
        return itemDescription;
    }

    /**
     * Getter of itemIdentifier.
     *
     * @return The itemIdentifier.
     */
    public String getItemIdentifier() {
        return itemIdentifier;
    }

    /**
     * Displays a string with gathered item information
     *
     * @return       The string with item information
     */
    @Override
    public String toString() {
        return ("item identifier: " + itemIdentifier) +
                "quantity: " + quantity +
                "item description: " + itemDescription.toString();
    }
}
