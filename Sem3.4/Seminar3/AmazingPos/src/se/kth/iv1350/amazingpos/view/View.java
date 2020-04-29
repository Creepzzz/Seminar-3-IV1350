package se.kth.iv1350.amazingpos.view;

import se.kth.iv1350.amazingpos.controller.Controller;
import se.kth.iv1350.amazingpos.util.Amount;
/**
 * This is a placeholder for the real view. It contains a hardcoded execution with calls to all system operations
 * in the controller.
 */
public class View {
	private Controller ctrl;
	/**
	 * Creates a new instance, that uses the specified controller for calls to other layers
	 * 
	 * @param ctrl      The controller used for calls
	 */
	public View(Controller ctrl) {
		this.ctrl = ctrl;
	}

	/**
	 * Initiates a fake sale
	 */
	public void runFakeExecution() {
		ctrl.startSale();
		System.out.println("A new sale has been started.");
	}

	/**
	 * A sample execution of the POS to display it
	 */
	public void sampleExecution(){
		System.out.println("Cashier starts new sale.\n");
		ctrl.startSale();
		System.out.println("Cashier enter items. \n");
		String out = ctrl.registerItem("2", new Amount(1));
		System.out.println(out);
		out = ctrl.registerItem("1", new Amount(1));
		System.out.println(out);
		out = ctrl.registerItem("1", new Amount(1));
		System.out.println(out);
		out = ctrl.registerItem("1", new Amount(1));
		System.out.println(out);
		out = ctrl.registerItem("4", new Amount(1));
		System.out.println(out);
		System.out.println("Cashier displays the total with taxes. \n");
		out = ctrl.displayTotalWithTax();
		System.out.println(out);
		System.out.println("Cashier enters the paid amount. \n");
		out = ctrl.paid(new Amount(2000));
		System.out.println(out);
	}
}
