package se.kth.iv1350.amazingpos.util;

/**
 * Represent the amount of money and items
 */
public class Amount {
	private final int amount;
	
	/**
	 * Creates an instance of an amount
	 * 
	 * @param amount    Representing an amount
	 */
	public Amount(int amount) {
		this.amount = amount;
	}

	/**
	 * Getter of amount
	 * 
	 * @return     The amount
	 */
	public int getAmount(){
		return amount;
	}

	/**
	 * Displays the amount as a string
	 *  
	 *  @return    The amount as a string
	 */
	public String toString() {
		return Integer.toString(amount);
	}

	/**
	 * Increases the amount of specified amount
	 * 
	 * @param other     The other amount that is to be added
	 * @return          The sum of the amounts
	 */
	public Amount add(Amount other) {
		return new Amount(this.amount + other.amount);
	}

	/**
	 * Decreases the amount of specified amount
	 *
	 * @param other     The other amount that is to be subtracted
	 * @return          The difference of the mounts
	 */
	public Amount decrease(Amount other){
		return new Amount(this.amount - other.amount);
	}

	/**
	 * Multiplies amount with specified amount (tax of VAT)
	 *
	 * @param other      The other amount that is to be multiplied
	 * @return           The product of the amounts
	 */
	public Amount multiply(Amount other){
		return new Amount(this.amount * other.amount);
	}

}
