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
}
