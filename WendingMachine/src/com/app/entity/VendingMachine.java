package com.app.entity;

import java.util.Map;

public class VendingMachine {
	
	Map<String, Product> inventory;
    Map<Integer, Coin> coins;
    
    public VendingMachine(Map<String, Product> inventory, Map<Integer, Coin> coins) {
        this.inventory = inventory;
        this.coins = coins;
    }

    public Transaction buyProducts(String productName, int[] coinsInserted) {
        Product product = inventory.get(productName);
        int totalPayment = calculateTotal(coinsInserted);
        if (product != null && product.quantity > 0 && totalPayment >= product.price) {
            int changeDue = totalPayment - product.price;
            if (canGiveChange(changeDue)) {
            	product.quantity -= 1;
                Coin[] change = calculateChange(changeDue);
                return new Transaction(new Product[]{product}, change);
            } else {
                System.out.println("Sorry, cannot give change. Transaction canceled.");
            }
        } else {
            System.out.println("Sorry, the product is not available or insufficient payment.");
        }
        return new Transaction(new Product[]{}, new Coin[]{});
    }

    private int calculateTotal(int[] coinsInserted) {
        int total = 0;
        for (int coin : coinsInserted) {
            total += coin;
        }
        return total;
    }

    private Coin[] calculateChange(int changeDue) {
        // Logic to calculate the change using the available coins
        return new Coin[]{};
    }

    private boolean canGiveChange(int changeDue) {
        // Logic to check if the vending machine can give change
        return true;
    }


}
