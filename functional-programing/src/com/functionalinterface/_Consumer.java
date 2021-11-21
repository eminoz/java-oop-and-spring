package com.functionalinterface;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class _Consumer {
    public static void main(String[] args) {
        //normal java function
        Customer emin = new Customer("emin", "9999");
        //consumer functional interface
        greetCustomerConsumer.accept(emin);
        greetCustomer(emin);


        greetCustomerConsumerV2.accept(emin, false);
        greetCustomer(emin, false);
    }

    //consumer take a value and no return nothing just runs as normal void function
    static Consumer<Customer> greetCustomerConsumer = customer -> System.out.println("Hello " + customer.customerName +
            ", thanks for registering phone number "
            + customer.customerPhoneNumber);


    static void greetCustomer(Customer customer) {
        System.out.println("Hello " + customer.customerName +
                ", thanks for registering phone number "
                + customer.customerPhoneNumber);
    }

    //This biConsumer take two argument a value and boolean
    static BiConsumer<Customer, Boolean> greetCustomerConsumerV2 = (customer, showPhoneNumber) ->
            System.out.println("Hello " + customer.customerName +
                    ", thanks for registering phone number "
                    + (showPhoneNumber ? customer.customerPhoneNumber : "0507"));

    static void greetCustomer(Customer customer, boolean showPhoneNumber) {
        System.out.println("Hello " + customer.customerName +
                ", thanks for registering phone number "
                + (showPhoneNumber ? customer.customerPhoneNumber : "0507"));
    }

    static class Customer {
        private final String customerName;
        private final String customerPhoneNumber;

        Customer(String customerName, String customerPhoneNumber) {
            this.customerName = customerName;
            this.customerPhoneNumber = customerPhoneNumber;
        }
    }
}
