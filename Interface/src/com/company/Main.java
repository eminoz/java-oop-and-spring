package com.company;

public class Main {


    public static void main(String[] args) {
        Logger[] loggers = {new SmsLogger(), new DatabaseLogger()};
        CustomerManager customerManager = new CustomerManager(loggers); //çoklu class yollayacaksak böyle yaparız
        Customer emin = new Customer(1, "emin", "oz");
        customerManager.add(emin);
    }
}
