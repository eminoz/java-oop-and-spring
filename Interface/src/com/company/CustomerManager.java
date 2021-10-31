package com.company;

public class CustomerManager {


    //dependinsi injection
    // private Logger logger;
    /*
      public CustomerManager(Logger loggers) {
        this.logger = logger;
    }
    */
    private Logger[] loggers; //Birden fazla loglama varsa o zaman bu kullanılı

    public CustomerManager(Logger[] loggers) {
        this.loggers = loggers;
    }

    public void add(Customer customer) {
        System.out.println("Müşteri eklendi" + customer.getFirstName());
        // this.logger.log(customer.getFirstName());
        Utils.runLoggers(loggers, customer.getFirstName());
    }

    public void delete(Customer customer) {
        System.out.println("Müşteri silindi" + customer.getFirstName());
        //this.logger.log(customer.getFirstName());
        Utils.runLoggers(loggers, customer.getFirstName());

    }
}
