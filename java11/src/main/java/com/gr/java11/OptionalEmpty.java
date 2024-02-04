package com.gr.java11;

import java.io.IOException;
import java.util.Optional;


//Shows example of empty method in the Optional class.
public class OptionalEmpty {
	
	public static void main(String[] args) throws IOException {	
		
		//Before java 11
		boolean isNotMember = isCustomerNotAMemberBeforeJava11(1321L);
		System.out.println(isNotMember);

		//Java 11
		isNotMember = isCustomerNotAMemberJava11(1321L);
		System.out.println(isNotMember);
		
		
	}
	
	public static boolean isCustomerNotAMemberBeforeJava11(Long customerId) {
		return !getCustomerRepository()
			   .findCustomer(customerId)
			   .map(Customer::getCard)
			   .isPresent();
	}
	
	public static boolean isCustomerNotAMemberJava11(Long customerId) {
		return getCustomerRepository()
			  .findCustomer(customerId)
			  .map(Customer::getCard)
			  .isEmpty();
	}
	
	
	private static CustomerRepository getCustomerRepository() {
		return new CustomerRepository();
	}

}

class Customer{

	private final Long customerId;
	private final String name;

	private Card card;
	
	public Customer(Long customerId,String name) {
		this.customerId = customerId;
		this.name = name;
	}

	public Long getCustomerId(){
		return customerId;
	}

	private String name(){
		return name;
	}
	
	public Card getCard() {
		return card;
	}
	
	public void setCard(Card card) {
		this.card = card;
	}
}

class Card{
	
}

class CustomerRepository {
	
	public Optional<Customer> findCustomer(Long customerId){
		Customer c  = new Customer(customerId,"Rahul");
	    //c.setCard(new Card());
		return Optional.ofNullable(c);
	}

	
}
