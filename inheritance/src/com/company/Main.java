package com.company;

public class Main {
//SOLID= open closed principle= yeni bir kod eklendiğinde mevcuttaki kodu değiştirme

    public static void main(String[] args) {
        IndividualCustomer emin = new IndividualCustomer();
        CorporateCustomer getir = new CorporateCustomer();
        emin.customerNumber = "1";
        getir.customerNumber = "2";
        CustomerManager customerManager = new CustomerManager();
        //bunun adı polymorfizimdir. Extend ettiği classı verdik ama içerisinde
        customerManager.add(emin);
        customerManager.add(getir);
    }
}
