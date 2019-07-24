import java.util.HashMap;
import java.util.Map;

class Invoice {
    int totalAmount;
    int volumeCredits;
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

        Invoice invoice = new Invoice();
        invoice.totalAmount = 0;
        invoice.volumeCredits = 0;
        StringBuilder resultBuilder = new StringBuilder();
        makeHead(statement, resultBuilder);
        calculateInvoice(plays, statement, invoice);

        for (Performance performance : statement.performances) {
            Play play = plays.get(performance.getPlayId());

            resultBuilder.append(" ").append(play.getName()).append(": $").append(play.getAmount(performance)).append(" (").append(performance.getAudiences()).append(" seats)\n");
        }


        makeFoot(invoice.totalAmount, invoice.volumeCredits, resultBuilder);
        return resultBuilder.toString();
    }

    private void calculateInvoice(Map<String, Play> plays, Statement statement, Invoice invoice) {
        for (Performance performance : statement.performances) {
            Play play = plays.get(performance.getPlayId());

            invoice.volumeCredits += play.calculateVolumeCredits(performance);
            invoice.totalAmount += play.getAmount(performance);
        }
    }

    private Invoice get(Map<String, Play> plays, Statement statement, Invoice invoice) {
        Invoice invoice1 = new Invoice();
        calculateInvoice(plays, statement, invoice1);
        return invoice1;
    }



    private void makeFoot(int totalAmount, int volumeCredits, StringBuilder resultBuilder) {
        resultBuilder.append("Amount owed is $").append(totalAmount).append("\n");
        resultBuilder.append("You earned ").append(volumeCredits).append(" credits\n");
    }

    private void makeHead(Statement statement, StringBuilder resultBuilder) {
        resultBuilder.append("Statement for ").append(statement.customer).append("\n");
    }
}
