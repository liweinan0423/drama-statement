import java.util.Map;

public class Statement {
    public Performance[] performances;
    public String customer;

    Invoice getInvoice() {
        Invoice invoice = new Invoice();
        int volumeCredits = 0;
        int totalAmount = 0;

        for (Performance performance : performances) {
            Play play = performance.getPlay();
            volumeCredits += play.calculateVolumeCredits(performance);
            totalAmount += play.getAmount(performance);

            invoice.addItem(play.getAmount(performance), performance.getAudiences(), play.getName());
        }

        invoice.volumeCredits = volumeCredits;
        invoice.totalAmount = totalAmount;
        return invoice;
    }

}
