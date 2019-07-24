import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Invoice {
    int totalAmount;
    int volumeCredits;

    List<InvoiceItem> invoiceItems = new ArrayList<>();
}

class InvoiceItem {
    String playName;
    int audiences;
    int amount;
}

class App {
    public String run() {
        Map<String, Play> plays = new HashMap<>();
        plays.put("hamlet", Play.create("Hamlet", "tragedy"));
        plays.put("as-like", Play.create("As You Like It", "comedy"));
        plays.put("othello", Play.create("Othello", "tragedy"));

        Statement statement = new Statement();
        statement.customer = "RigCo";

        statement.performances = new Performance[]{
                new Performance("hamlet", 55),
                new Performance("as-like", 35),
                new Performance("othello", 40)
        };

        StringBuilder resultBuilder = new StringBuilder();
        makeHead(statement, resultBuilder);
        Invoice invoice = statement.getInvoice(plays);

        for (InvoiceItem item : invoice.invoiceItems) {
            resultBuilder.append(" ").append(item.playName).append(": $").append(item.amount).append(" (").append(item.audiences).append(" seats)\n");
        }


        makeFoot(invoice.totalAmount, invoice.volumeCredits, resultBuilder);
        return resultBuilder.toString();
    }


    private void makeFoot(int totalAmount, int volumeCredits, StringBuilder resultBuilder) {
        resultBuilder.append("Amount owed is $").append(totalAmount).append("\n");
        resultBuilder.append("You earned ").append(volumeCredits).append(" credits\n");
    }

    private void makeHead(Statement statement, StringBuilder resultBuilder) {
        resultBuilder.append("Statement for ").append(statement.customer).append("\n");
    }
}
