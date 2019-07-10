public class Comedy extends Play {
    @Override
    public String getType() {
        return "comedy";
    }

    public Comedy(String name) {
        super(name, "comedy");
    }
}
