import javax.sql.rowset.BaseRowSet;

abstract class Play {
    static Play create(String name, String type) {
        if ("tragedy".equals(type)) {
            return new Tragedy(name);
        } else if ("comedy".equals(type)) {
            return new Comedy(name);
        }
        return null;
    }

    public static final int TRAGEDY_BASE_PRICE = 400;
    public static final int COMEDY_BASE_PRICE = 300;
    public static final int TRAGEDY_EXTRA_PRICE = 10;
    public static final int COMEDY_EXTRA_BASE = 100;
    public static final int COMEDY_EXTRA_PRICE = 5;
    public static final int COMEDY_EXTRA_FACTOR = 3;
    private String name;

    public Play(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getAmount(Performance performance, Play play) {
        return this.getAmount(performance);
    }

    public int getAmount(Performance performance) {
        int thisAmount;
        Play play = this;
        switch (play.getType()) {
            case "tragedy":
                thisAmount = performance.getTragedyAmount();
                break;
            case "comedy":
                thisAmount = performance.getComedyAmount();
                break;
            default:
                throw new RuntimeException("unknown type " + play.getType());
        }
        return thisAmount;
    }

    public abstract String getType();
}
