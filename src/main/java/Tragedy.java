public class Tragedy extends Play {
    @Override
    public String getType() {
        return "tragedy";
    }

    public Tragedy(String name) {
        super(name, "tragedy");
    }
}
