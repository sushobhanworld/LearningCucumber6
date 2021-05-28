package org.example.practice;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class _Concumer
{
    public static void main(String[] args) {
        greetCustomer(new Customer("Sushobhan", "987654321"));
        greetCustomerConsumer.accept(new Customer("Kumar Sushobhan", "9731950640"));

        greetCustomerConsumerV2.accept(new Customer("Anjana Maiti", "7619549352"), false);
    }

    static Consumer<Customer> greetCustomerConsumer=
            customer -> System.out.println("Hello "+customer.name+ ", thanks for registering phone number "+customer.customerPhoneNumber);

    static BiConsumer<Customer, Boolean> greetCustomerConsumerV2=
            (customer, showPhoneNumber)
                    -> System.out.println("Hello "+customer.name+ ", thanks for registering phone number "+(showPhoneNumber ? customer.customerPhoneNumber : "Dont show phone number"));


    static void greetCustomer(Customer customer)
    {
        System.out.println("Hello "+customer.name+ ", thanks for registering phone number "+customer.customerPhoneNumber);
    }
    static class Customer
    {
        private final String name;
        private final String customerPhoneNumber;

        Customer(String name, String customerPhoneNumber) {
            this.name = name;
            this.customerPhoneNumber = customerPhoneNumber;
        }
    }
}
