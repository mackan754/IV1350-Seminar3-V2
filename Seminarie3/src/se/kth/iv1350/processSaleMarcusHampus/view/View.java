package se.kth.iv1350.processSaleMarcusHampus.view;

import se.kth.iv1350.processSaleMarcusHampus.controller.Controller;
import se.kth.iv1350.processSaleMarcusHampus.integration.Item;
import se.kth.iv1350.processSaleMarcusHampus.util.Amount;

/**
 * This class represents the user interface of the application. It is
 * responsible for
 * starting and displaying the outcomes of a simulated sale process.
 */
public class View {
    private Controller contr;

    /**
     * Constructs a View instance which will interact with the specified Controller
     * for processing sales.
     *
     * @param contr the Controller that manages the operations and flow of the sale
     *              process.
     */
    public View(Controller contr) {
        this.contr = contr;
    }

    /**
     * Simulates a sale by interacting with the Controller to add items, display
     * totals,
     * and handle payments. This method is intended for demonstration purposes and
     * prints
     * the progress of a sale to the console.
     */
    public void fakeSale() {
        contr.startNewSale();
        String output;
        System.out.println("A new sale has been started.\n");
        System.out.println("Cashier enter items.\n");
        Item item = contr.addItem("32001", new Amount(2));
        System.out.println(generateItemDetails(item));
        output = contr.displayTotal();
        System.out.println("Running total: " + output);
        System.out.println();
        item = contr.addItem("32003", new Amount(4));
        System.out.println(generateItemDetails(item));
        output = contr.displayTotal();
        System.out.println("Running total: " + output);
        System.out.println();
        item = contr.addItem("32004", new Amount(3));
        System.out.println(generateItemDetails(item));
        output = contr.displayTotal();
        System.out.println("Running total: " + output);
        System.out.println();
        item = contr.addItem("32001", new Amount(2));
        System.out.println(generateItemDetails(item));
        output = contr.displayTotal();
        System.out.println("Running total: " + output);
        System.out.println();
        output = contr.displayTotalIncludingTax();
        System.out.println("Total including VAT: " + output);
        System.out.println("Cashier enter amount paid");
        output = contr.enterPayment(new Amount(350));
        System.out.println("Change to give customer: " + output);

    }

    /**
     * Formats the data stored in Item.
     * 
     * @return The item details as a String.
     */
    private String generateItemDetails(Item item) {
        String itemDetails = "item name: " + item.getItemInformation().getItemName()
                + ", price: " + item.getItemInformation().getItemPrice()
                + ", tax amount: " + item.getItemInformation().getItemTaxAmount()
                + ", quantity: " + item.getQuantity();
        return itemDetails;
    }
}
