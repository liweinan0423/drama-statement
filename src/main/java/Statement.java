import java.util.Map;

public class Statement {
    public Performance[] performances;
    public String customer;

    Invoice getInvoice(Map<String, Play> plays) {
        Invoice invoice = new Invoice();
        for (Performance performance : performances) {
            Play play = plays.get(performance.getPlayId());

            invoice.volumeCredits += play.calculateVolumeCredits(performance);
            invoice.totalAmount += play.getAmount(performance);
        }
        return invoice;
    }
}
