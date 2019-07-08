class Performance {

    public static final int TRAGEDY_MAX_PEOPLE = 30;
    public static final int COMEDY_MAX_PEOPLE = 20;
    public static final int VOLUME_CREDITS_THRESHOLD = 30;
    public static final int EXTRA_CREDIT_FACTOR = 5;
    private String playId;
    private int audiences;

    public Performance(String playId, int audiences) {
        this.playId = playId;
        this.audiences = audiences;
    }

    public String getPlayId() {
        return playId;
    }

    public int getAudiences() {
        return audiences;
    }


    public int getComedyAmount() {
        int thisAmount;
        thisAmount = Play.COMEDY_BASE_PRICE;
        if (this.getAudiences() > Performance.COMEDY_MAX_PEOPLE) {
            thisAmount += Play.COMEDY_EXTRA_BASE + Play.COMEDY_EXTRA_PRICE * (this.getAudiences() - Performance.COMEDY_MAX_PEOPLE);
        }
        thisAmount += Play.COMEDY_EXTRA_FACTOR * this.getAudiences();
        return thisAmount;

    }
}
