package model;

import objects.Customer;

public class CustomerModel {
	private Customer customer;

	public CustomerModel(Customer customer) {
		this.customer = customer;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
}
