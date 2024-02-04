package com.gr.java13;

public class SwitchPreview {

	public static void main(String [] args) {

		OrderStatus status = OrderStatus.CANCELLED;
		var displayStatus = processOrder(status);
		System.out.println(displayStatus);

	}

	private static String processOrder(OrderStatus status) {

		var result = switch (status) {
			case ORDERED   -> "Food ordered,Restaurant will confirm";
			case CONFIRMED -> "Restaurant confirmed order,food is being cooked";
			case DELIVERED -> "Food has been delivered";
			case CANCELLED -> {
							   processCancellation();
							   yield "Food order has been cancelled";
							 }
			default -> "There was a problem, please try later..";
		};
		
		return result;
	}

	private static void processCancellation() {
		System.out.println("Order cancelled..");
	}
}

enum OrderStatus {

	ORDERED, CONFIRMED, DELIVERED, CANCELLED
}