public class Comedy extends Play {
    @Override
    public String getType() {
        return "comedy";
    }

    @Override
    public int getAmount(Performance performance) {
        return performance.getComedyAmount();
    }

    public Comedy(String name) {
        super(name);
    }

    int calculateVolumeCredits(Performance performance) {
        int volumeCredits = 0;
        volumeCredits = (int) (Math.max(performance.getAudiences() - Performance.VOLUME_CREDITS_THRESHOLD, 0) + Math.floor(performance.getAudiences() / Performance.EXTRA_CREDIT_FACTOR));
        return volumeCredits;
    }
}
