import java.util.HashMap;
import java.util.Map;

class Performance {
    public Object[] _data = new Object[2];
}

public class Main {

    public static final int TRAGEDY_BASE_PRICE = 400;
    public static final int COMEDY_BASE_PRICE = 300;
    public static final int TRAGEDY_MAX_PEOPLE = 30;
    public static final int TRAGEDY_EXTRA_PRICE = 10;
    public static final int COMEDY_MAX_PEOPLE = 20;
    public static final int COMEDY_EXTRA_BASE = 100;
    public static final int COMEDY_EXTRA_PRICE = 5;
    public static final int COMEDY_EXTRA_FACTOR = 3;
    public static final int VOLUME_CREDITS_THRESHOLD = 30;
    public static final int EXTRA_CREDIT_FACTOR = 5;
    public static final int PERFORMANCE_AUDIENCE_INDEX = 1;

    public static void main(String[] args) {

        Map<String, Play> plays = new HashMap<>();
        plays.put("hamlet", new Play("Hamlet", "tragedy"));
        plays.put("as-like", new Play("As You Like It", "comedy"));
        plays.put("othello", new Play("Othello", "tragedy"));

        String customer = "RigCo";

        Object[][] performances = new Object[][]{
                {"hamlet", 55},
                {"as-like", 35},
                {"othello", 40}
        };

        int totalAmount = 0;
        int volumeCredits = 0;
        String result = "Statement for " + customer + "\n";
        for (Object[] performance : performances) {

            Performance performance2 = new Performance();
            performance2._data = performance;

            Play play = plays.get(performance2._data[0]);

            int thisAmount = 0;
            switch (play.getType()) {
                case "tragedy":
                    thisAmount = TRAGEDY_BASE_PRICE;
                    if ((int) performance2._data[PERFORMANCE_AUDIENCE_INDEX] > TRAGEDY_MAX_PEOPLE) {
                        thisAmount += TRAGEDY_EXTRA_PRICE * (((int) performance2._data[PERFORMANCE_AUDIENCE_INDEX]) - TRAGEDY_MAX_PEOPLE);
                    }
                    break;
                case "comedy":
                    thisAmount = COMEDY_BASE_PRICE;
                    if (((int) performance2._data[1]) > COMEDY_MAX_PEOPLE) {
                        thisAmount += COMEDY_EXTRA_BASE + COMEDY_EXTRA_PRICE * (((int) performance2._data[PERFORMANCE_AUDIENCE_INDEX]) - COMEDY_MAX_PEOPLE);
                    }
                    thisAmount += COMEDY_EXTRA_FACTOR * ((int) performance2._data[PERFORMANCE_AUDIENCE_INDEX]);
                    break;
                default:
                    throw new RuntimeException("unknown type " + play.getType());
            }
            // add volume credits
            volumeCredits += Math.max(((int) performance2._data[PERFORMANCE_AUDIENCE_INDEX]) - VOLUME_CREDITS_THRESHOLD, 0);

            // add extra credit for every 5 comedy attendees;
            if ("comedy" == play.getType()) volumeCredits += Math.floor(((int) performance2._data[PERFORMANCE_AUDIENCE_INDEX]) / EXTRA_CREDIT_FACTOR);


            // print line for this order
            result += " " + play.getName() + ": $" + thisAmount + " (" + performance2._data[PERFORMANCE_AUDIENCE_INDEX] + " seats)\n";
            totalAmount += thisAmount;
        }

        result += "Amount owed is $" + totalAmount + "\n";
        result += "You earned " + volumeCredits + " credits\n";
        System.out.println(result);
    }
}
