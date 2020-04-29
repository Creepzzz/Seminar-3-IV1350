package se.kth.iv1350.amazingpos.integration;

import se.kth.iv1350.amazingpos.util.*;
import java.util.HashMap;

/**
 * This is a dummy item catalog
 */
public class ItemCatalog {
    private HashMap<String, ItemDTO > itemList = new HashMap<>();

    /**
     *  Creates a dummy item catalog
     */
    ItemCatalog(){
        itemsInCatalog();
    }

    /**
     *  Checks if specified item exists in the catalog
     *
     * @param itemIdentifier    The specified item
     * @return                  True if item exists, false if it doesn't
     */
    public boolean validItem(String itemIdentifier){
        return itemList.containsKey(itemIdentifier);
    }

    /**
     * Getter of the item specified
     *
     * @param itemIdentifier    The identifier of an item
     * @param quantity          The amount of specified item
     * @return                  If item exist - the item, if item doesn't exist - null
     */
    public Item getItem(String itemIdentifier, Amount quantity){
        if (validItem(itemIdentifier)){
            return new Item(itemList.get(itemIdentifier), itemIdentifier, quantity);
        }
        return null;
    }

    /**
     * Dummy item catalog
     */
    private void itemsInCatalog(){
        itemList.put("1", new ItemDTO(new Amount(40), new Amount(15), "Paprika"));
        itemList.put("2", new ItemDTO(new Amount(30), new Amount(10), "Apelsin" ));
        itemList.put("3", new ItemDTO(new Amount(10), new Amount(5), "Gurka"));
        itemList.put("4", new ItemDTO(new Amount(35), new Amount(20), "Mandarin"));
    }
}
