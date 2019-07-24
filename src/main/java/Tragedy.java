public class Tragedy extends Play {
    @Override
    public String getType() {
        return "tragedy";
    }

    public Tragedy(String name) {
        super(name);
    }

    @Override
    public int getAmount(Performance performance) {
        int thisAmount;
        thisAmount = TRAGEDY_BASE_PRICE;
        if (performance.getAudiences() > Performance.TRAGEDY_MAX_PEOPLE) {
            thisAmount += TRAGEDY_EXTRA_PRICE * (performance.getAudiences() - Performance.TRAGEDY_MAX_PEOPLE);
        }
        return thisAmount;
    }

    int calculateVolumeCredits(Performance performance) {
        return Math.max(performance.getAudiences() - Performance.VOLUME_CREDITS_THRESHOLD, 0);
    }
}
