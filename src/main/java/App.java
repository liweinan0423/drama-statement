import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Invoice {
    int totalAmount;
    int volumeCredits;
    String customer;

    List<InvoiceItem> invoiceItems = new ArrayList<>();

    void addItem(int amount, int audiences, String playName) {
        InvoiceItem invoiceItem = new InvoiceItem();
        invoiceItem.amount = amount;
        invoiceItem.playName = playName;
        invoiceItem.audiences = audiences;
        invoiceItems.add(invoiceItem);

    }

    String print() {
        StringBuilder resultBuilder = new StringBuilder();
        resultBuilder.append("Statement for ").append(customer).append("\n");
        for (InvoiceItem item : invoiceItems) {
            printItem(resultBuilder, item);
        }
        resultBuilder.append("Amount owed is $").append(totalAmount).append("\n");
        resultBuilder.append("You earned ").append(volumeCredits).append(" credits\n");
        return resultBuilder.toString();
    }

    private void printItem(StringBuilder resultBuilder, InvoiceItem item) {
        resultBuilder.append(" ").append(item.playName).append(": $").append(item.amount).append(" (").append(item.audiences).append(" seats)\n");
    }
}

class InvoiceItem {
    String playName;
    int audiences;
    int amount;
}

class App {
    public String run() {
        Play hamlet = Play.create("Hamlet", "tragedy");
        Play asLike = Play.create("As You Like It", "comedy");
        Play othello = Play.create("Othello", "tragedy");

        Statement statement = new Statement();
        statement.customer = "RigCo";

        statement.performances = new Performance[]{
                new Performance("hamlet", 55, hamlet),
                new Performance("as-like", 35, asLike),
                new Performance("othello", 40, othello)
        };

        Invoice invoice = statement.getInvoice();
        invoice.customer = statement.customer;

        return invoice.print();
    }
}
