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
        return performance.getTragedyAmount();
    }

    int calculateVolumeCredits(Performance performance) {
        int volumeCredits = 0;
        volumeCredits = Math.max(performance.getAudiences() - Performance.VOLUME_CREDITS_THRESHOLD, 0);
        return volumeCredits;
    }
}
