package objects;

public class CustomerWrapper {
	private Customer customer;

	public CustomerWrapper(Customer customer) {
		this.customer = customer;
	}

	public String toString() {
		return customer.getName();
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
}
