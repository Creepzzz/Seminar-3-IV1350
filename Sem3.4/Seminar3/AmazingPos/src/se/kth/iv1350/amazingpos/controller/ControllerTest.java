package se.kth.iv1350.amazingpos.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.kth.iv1350.amazingpos.integration.*;
import se.kth.iv1350.amazingpos.util.Amount;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ControllerTest{
  private Controller ctrl;

  @BeforeEach
  public void setUp(){
  ctrl = new Controller(new SystemCreator(), new CatalogCreator(), new Printer());
  }
  
  @AfterEach
  public void tearDown(){
  ctrl = null;
  }

  @Test
  public void registerItem() {
    ctrl.startSale();
    String itemName = "Paprika";
    String itemID = "1";
    Amount price = new Amount(40);
    Amount taxAmount = new Amount(15);
    String actualResult = ctrl.registerItem(itemID, new Amount(1));
    String expectedResult = "item name: " + itemName + "\t" +
            "price: " + price + "\t" +
            "tax amount: " + taxAmount + "\t" +
            " quantity: " + new Amount(1) + ", total price: " + new Amount(55);
    assertEquals( expectedResult, actualResult);
  }
}
