package se.kth.iv1350.amazingpos.integration;

/**
 * An instance created to handle the external systems
 */
public class SystemCreator {
    private AccountingSystem accountingSystem;
    private InventorySystem inventorySystem;

    /**
     * Creates a system creator
     */
    public SystemCreator(){
        accountingSystem = new AccountingSystem();
        inventorySystem = new InventorySystem();
    }

    /**
     * Getter of the accounting system
     *
     * @return       The accounting system
     */
    public AccountingSystem getAccountingSystem() {
        return accountingSystem;
    }

    /**
     * Getter if the inventory system
     *
     * @return       The inventory system
     */
    public InventorySystem getInventorySystem() {
        return inventorySystem;
    }
}