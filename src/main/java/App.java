import java.util.HashMap;
import java.util.Map;

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

        int totalAmount = 0;
        int volumeCredits = 0;
        StringBuilder resultBuilder = new StringBuilder();
        resultBuilder.append("Statement for ").append(statement.customer).append("\n");
        for (Performance performance : statement.performances) {
            Play play = plays.get(performance.getPlayId());

            int thisAmount = 0;
            thisAmount = play.getAmount(performance);
            // add volume credits
            volumeCredits += Math.max(performance.getAudiences() - Performance.VOLUME_CREDITS_THRESHOLD, 0);

            // add extra credit for every 5 comedy attendees;
            if ("comedy" == play.getType())
                volumeCredits += Math.floor(performance.getAudiences() / Performance.EXTRA_CREDIT_FACTOR);


            // print line for this order
            resultBuilder.append(" ").append(play.getName()).append(": $").append(thisAmount).append(" (").append(performance.getAudiences()).append(" seats)\n");
            totalAmount += thisAmount;
        }

        resultBuilder.append("Amount owed is $").append(totalAmount).append("\n");
        resultBuilder.append("You earned ").append(volumeCredits).append(" credits\n");
        return resultBuilder.toString();
    }
}
