public class Comedy extends Play {
    @Override
    public String getType() {
        return "comedy";
    }

    @Override
    public int getAmount(Performance performance) {
        int thisAmount;
        thisAmount = COMEDY_BASE_PRICE;
        if (performance.getAudiences() > Play.COMEDY_MAX_PEOPLE) {
            thisAmount += COMEDY_EXTRA_BASE + COMEDY_EXTRA_PRICE * (performance.getAudiences() - Play.COMEDY_MAX_PEOPLE);
        }
        thisAmount += COMEDY_EXTRA_FACTOR * performance.getAudiences();
        return thisAmount;

    }

    public Comedy(String name) {
        super(name);
    }

    int calculateVolumeCredits(Performance performance) {
        return (int) (Math.max(performance.getAudiences() - Play.VOLUME_CREDITS_THRESHOLD, 0) + Math.floor(performance.getAudiences() / Play.EXTRA_CREDIT_FACTOR));
    }
}
