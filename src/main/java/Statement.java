import java.util.Map;

public class Statement {
    public Performance[] performances;
    public String customer;

    Invoice getInvoice(Map<String, Play> plays) {
        Invoice invoice = new Invoice();
        int volumeCredits = 0;
        int totalAmount = 0;

        for (Performance performance : performances) {
            Play play = plays.get(performance.getPlayId());
            volumeCredits += play.calculateVolumeCredits(performance);
            totalAmount += play.getAmount(performance);

            invoice.addItem(play.getAmount(performance), performance.getAudiences(), play.getName());
        }

        invoice.volumeCredits = volumeCredits;
        invoice.totalAmount = totalAmount;
        return invoice;
    }

}
