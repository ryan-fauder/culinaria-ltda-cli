public class InvalidPriceException extends Exception {
	private double price;

	public InvalidPriceException(double price) {
		this.price = price;
	}

	public double getPrice() {
		return price;
	}
}