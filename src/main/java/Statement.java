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

            invoice.items.put(performance, play.getAmount(performance));
            InvoiceItem invoiceItem = new InvoiceItem();
            invoiceItem.amount = play.getAmount(performance);
            invoiceItem.playName = play.getName();
            invoiceItem.audiences = performance.getAudiences();
            invoice.invoiceItems.add(invoiceItem);
        }
        return invoice;
    }
}
