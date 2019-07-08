import java.util.HashMap;
import java.util.Map;

public class Main {

    public static final int TRAGEDY_MAX_PEOPLE = 30;
    public static final int COMEDY_MAX_PEOPLE = 20;
    public static final int COMEDY_EXTRA_FACTOR = 3;
    public static final int VOLUME_CREDITS_THRESHOLD = 30;
    public static final int EXTRA_CREDIT_FACTOR = 5;

    public static void main(String[] args) {

        Map<String, Play> plays = new HashMap<>();
        plays.put("hamlet", new Play("Hamlet", "tragedy"));
        plays.put("as-like", new Play("As You Like It", "comedy"));
        plays.put("othello", new Play("Othello", "tragedy"));

        String customer = "RigCo";

        Performance[] performances = new Performance[]{
                new Performance("hamlet", 55),
                new Performance("as-like", 35),
                new Performance("othello", 40)
        };

        int totalAmount = 0;
        int volumeCredits = 0;
        String result = "Statement for " + customer + "\n";
        for (Performance performance : performances) {
            Play play = plays.get(performance.getPlayId());

            int thisAmount = 0;
            switch (play.getType()) {
                case "tragedy":
                    thisAmount = Play.TRAGEDY_BASE_PRICE;
                    if (performance.getAudiences() > TRAGEDY_MAX_PEOPLE) {
                        thisAmount += Play.TRAGEDY_EXTRA_PRICE * (performance.getAudiences() - TRAGEDY_MAX_PEOPLE);
                    }
                    break;
                case "comedy":
                    thisAmount = Play.COMEDY_BASE_PRICE;
                    if (performance.getAudiences() > COMEDY_MAX_PEOPLE) {
                        thisAmount += Play.COMEDY_EXTRA_BASE + Play.COMEDY_EXTRA_PRICE * (performance.getAudiences() - COMEDY_MAX_PEOPLE);
                    }
                    thisAmount += COMEDY_EXTRA_FACTOR * performance.getAudiences();
                    break;
                default:
                    throw new RuntimeException("unknown type " + play.getType());
            }
            // add volume credits
            volumeCredits += Math.max(performance.getAudiences() - VOLUME_CREDITS_THRESHOLD, 0);

            // add extra credit for every 5 comedy attendees;
            if ("comedy" == play.getType())
                volumeCredits += Math.floor(performance.getAudiences() / EXTRA_CREDIT_FACTOR);


            // print line for this order
            result += " " + play.getName() + ": $" + thisAmount + " (" + performance.getAudiences() + " seats)\n";
            totalAmount += thisAmount;
        }

        result += "Amount owed is $" + totalAmount + "\n";
        result += "You earned " + volumeCredits + " credits\n";
        System.out.println(result);
    }
}
