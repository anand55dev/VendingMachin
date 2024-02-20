package com.app.entity;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test {
	
	public static void main(String[] args) {
        // Initialize products
        Map<String, Product> products = new HashMap<>();
        products.put("Coke", new Product("Coke", 25, 10));
        products.put("Pepsi", new Product("Pepsi", 35, 15));
        products.put("Sprite", new Product("Sprite", 45, 12));

        // Initialize coins
        Map<Integer, Coin> coins = new HashMap<>();
        coins.put(1, new Coin(1, 100));
        coins.put(5, new Coin(5, 50));
        coins.put(10, new Coin(10, 50));
        coins.put(25, new Coin(25, 50));
        coins.put(50, new Coin(50, 50));
        coins.put(100, new Coin(100, 50));

        // Initialize vending machine
        VendingMachine vendingMachine = new VendingMachine(products, coins);

        // Command line interface
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Available products:");
            for (String productName : products.keySet()) {
                Product product = products.get(productName);
                System.out.println(product.name + " - Price: " + product.price + " - Quantity: " + product.quantity);
            }
            System.out.print("Enter product name to buy (or type 'exit' to quit): ");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("exit")) {
                break;
            }
            System.out.print("Enter coins separated by space (e.g., 25 25 10): ");
            String[] coinsInput = scanner.nextLine().split(" ");
            int[] coinsInserted = new int[coinsInput.length];
            for (int i = 0; i < coinsInput.length; i++) {
                coinsInserted[i] = Integer.parseInt(coinsInput[i]);
            }
            Transaction transaction = vendingMachine.buyProducts(input, coinsInserted);
            System.out.println("Transaction completed:");
            for (Product product : transaction.products) {
                System.out.println("Product: " + product.name);
            }
            for (Coin coin : transaction.change) {
                System.out.println("Change: " + coin.value);
            }
        }
        scanner.close();
    }

}
