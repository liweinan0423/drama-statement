import java.util.HashMap;
import java.util.Map;

public class Main {

    public static final int TRAGEDY_BASE_PRICE = 400;

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
            int thisAmount = 0;
            switch (play[1]) {
                case "tragedy":
                    thisAmount = TRAGEDY_BASE_PRICE;
                    if ((int) performance[1] > 30) {
                        thisAmount += 10 * (((int) performance[1]) - 30);
                    }
                    break;
                case "comedy":
                    thisAmount = 300;
                    if (((int) performance[1]) > 20) {
                        thisAmount += 100 + 5 * (((int) performance[1]) - 20);
                    }
                    thisAmount += 3 * ((int) performance[1]);
                    break;
                default:
                    throw new RuntimeException("unknown type " + play[1]);
            }
            // add volume credits
            volumeCredits += Math.max(((int) performance[1]) - 30, 0);

            // add extra credit for every 5 comedy attendees;
            if ("comedy" == play[1]) volumeCredits += Math.floor(((int) performance[1]) / 5);


            // print line for this order
            result += " " + play[0] + ": $" + thisAmount + " (" + performance[1] + " seats)\n";
            totalAmount += thisAmount;
        }

        result += "Amount owed is $" + totalAmount + "\n";
        result += "You earned " + volumeCredits + " credits\n";
        System.out.println(result);
    }
}
