package com.cg.banking.main;

import com.cg.banking.beans.Customer;

public class MainClass {

	public static void main(String[] args) {
		
		Customer customer=new Customer(101, "Puru", "kumar", "07.07.1993", "7387933229", "1000389488");
		System.out.println(customer.getId() +" "+customer.getFirstName() +" "+ customer.getLastName() +" "+ customer.getDateOfBirth());
	}

}
