package se.kth.iv1350.processSaleMarcusHampus.model;

import java.time.format.DateTimeFormatter;

import se.kth.iv1350.processSaleMarcusHampus.integration.Item;

/**
 * This class represents a receipt that is generated after a sale is completed.
 * It includes details of the sale such as the time of the sale and a summary of
 * the items purchased.
 */
public class Receipt {

    private SaleDTO saleInformation;

    /**
     * Constructs a Receipt object with a reference to the SaleDTO instance that the
     * receipt will represent.
     *
     * @param saleInformation the SaleDTO object that contains the details of the
     *                        completed sale.
     */
    public Receipt(SaleDTO saleInformation) {
        this.saleInformation = saleInformation;
    }

    /**
     * Formats the sale time for display on the receipt.
     *
     * @return a String representing the formatted sale initiation time.
     */
    private String getFormattedSaleTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return saleInformation.getSaleTime().format(formatter);
    }

    /**
     * Generates a formatted string representation of the receipt, which includes
     * the sale time,
     * details of items purchased, and other relevant sale information.
     *
     * @return a string representation of the receipt, formatted for printing.
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        sb.append("-----RECEIPT-----");
        sb.append("\n");
        sb.append(getFormattedSaleTime().toString());
        sb.append("\n");
        sb.append(getSaleDetails());
        sb.append("\n-------END-------");
        return sb.toString();
    }

    /**
     * Generates a string representation of the sale details.
     *
     * @return the string format of the sale details.
     */
    private String getSaleDetails() {
        StringBuilder sb = new StringBuilder();
        for (Item item : saleInformation.getItems()) {
            sb.append("\n").append(item.getItemInformation().getItemName())
                    .append("\nprice: ").append(item.getItemInformation().getItemPrice())
                    .append("\ntax amount: ").append(item.getItemInformation().getItemTaxAmount())
                    .append("\nquantity: ").append(item.getQuantity()).append("\n");
        }
        sb.append("\ntotal: ").append(saleInformation.getTotal());
        sb.append("\ntax: ").append(saleInformation.getTotalIncludingTax().minus(saleInformation.getTotal()));
        return sb.toString();
    }
}
