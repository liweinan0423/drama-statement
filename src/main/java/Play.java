import javax.sql.rowset.BaseRowSet;

abstract class Play {
    public static final int TRAGEDY_MAX_PEOPLE = 30;
    public static final int COMEDY_MAX_PEOPLE = 20;
    public static final int VOLUME_CREDITS_THRESHOLD = 30;
    public static final int EXTRA_CREDIT_FACTOR = 5;
    public static final int TRAGEDY_BASE_PRICE = 400;
    public static final int COMEDY_BASE_PRICE = 300;
    public static final int TRAGEDY_EXTRA_PRICE = 10;
    public static final int COMEDY_EXTRA_BASE = 100;
    public static final int COMEDY_EXTRA_PRICE = 5;
    public static final int COMEDY_EXTRA_FACTOR = 3;

    static Play create(String name, String type) {
        if ("tragedy".equals(type)) {
            return new Tragedy(name);
        } else if ("comedy".equals(type)) {
            return new Comedy(name);
        }
        return null;
    }

    private String name;

    public Play(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getAmount(Performance performance) {
        throw new RuntimeException("unknown type " + this.getType());
    }

    public abstract String getType();

    abstract int calculateVolumeCredits(Performance performance);
}
