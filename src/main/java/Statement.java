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
            invoice.items.put(performance, play.getAmount(performance));
            InvoiceItem invoiceItem = new InvoiceItem();
            invoiceItem.amount = play.getAmount(performance);
            invoiceItem.playName = play.getName();
            invoiceItem.audiences = performance.getAudiences();
            invoice.invoiceItems.add(invoiceItem);
        }
        invoice.volumeCredits = volumeCredits;
        invoice.totalAmount = totalAmount;
        return invoice;
    }
}
