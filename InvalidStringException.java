public class InvalidStringException extends Exception {
	private String string;

	public InvalidStringException(String string) {
		this.string = string;
	}

	public String getString() {
		return string;
	}
}