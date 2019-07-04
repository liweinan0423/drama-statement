import java.util.HashMap;
import java.util.Map;


class Play {
    public String[] _data = new String[2];

    public String getName() {
        return _data[0];
    }

    public String getType() {
        return _data[1];
    }
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

        Map<String, String[]> plays = new HashMap<>();
        plays.put("hamlet", new String[]{"Hamlet", "tragedy"});
        plays.put("as-like", new String[]{"As You Like It", "comedy"});
        plays.put("othello", new String[]{"Othello", "tragedy"});

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

            String[] play = plays.get(performance[0]);

            Play play1 = new Play();
            play1._data = play;

            int thisAmount = 0;
            switch (play1._data[1]) {
                case "tragedy":
                    thisAmount = TRAGEDY_BASE_PRICE;
                    if ((int) performance[PERFORMANCE_AUDIENCE_INDEX] > TRAGEDY_MAX_PEOPLE) {
                        thisAmount += TRAGEDY_EXTRA_PRICE * (((int) performance[PERFORMANCE_AUDIENCE_INDEX]) - TRAGEDY_MAX_PEOPLE);
                    }
                    break;
                case "comedy":
                    thisAmount = COMEDY_BASE_PRICE;
                    if (((int) performance[1]) > COMEDY_MAX_PEOPLE) {
                        thisAmount += COMEDY_EXTRA_BASE + COMEDY_EXTRA_PRICE * (((int) performance[PERFORMANCE_AUDIENCE_INDEX]) - COMEDY_MAX_PEOPLE);
                    }
                    thisAmount += COMEDY_EXTRA_FACTOR * ((int) performance[PERFORMANCE_AUDIENCE_INDEX]);
                    break;
                default:
                    throw new RuntimeException("unknown type " + play1._data[1]);
            }
            // add volume credits
            volumeCredits += Math.max(((int) performance[PERFORMANCE_AUDIENCE_INDEX]) - VOLUME_CREDITS_THRESHOLD, 0);

            // add extra credit for every 5 comedy attendees;
            if ("comedy" == play1._data[1]) volumeCredits += Math.floor(((int) performance[PERFORMANCE_AUDIENCE_INDEX]) / EXTRA_CREDIT_FACTOR);


            // print line for this order
            result += " " + play1.getName() + ": $" + thisAmount + " (" + performance[PERFORMANCE_AUDIENCE_INDEX] + " seats)\n";
            totalAmount += thisAmount;
        }

        result += "Amount owed is $" + totalAmount + "\n";
        result += "You earned " + volumeCredits + " credits\n";
        System.out.println(result);
    }
}
