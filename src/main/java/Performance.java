class Performance {

    public static final int TRAGEDY_MAX_PEOPLE = 30;
    public static final int COMEDY_MAX_PEOPLE = 20;
    public static final int VOLUME_CREDITS_THRESHOLD = 30;
    public static final int EXTRA_CREDIT_FACTOR = 5;
    private String playId;
    private int audiences;
    private Play play;

    public Performance(String playId, int audiences) {
        this(playId, audiences, null);
    }

    public Performance(String playId, int audiences, Play play) {
        this.playId = playId;
        this.audiences = audiences;
        this.play = play;
    }

    public String getPlayId() {
        return playId;
    }

    public int getAudiences() {
        return audiences;
    }


    public int getTragedyAmount() {
        int thisAmount;
        thisAmount = Play.TRAGEDY_BASE_PRICE;
        if (this.getAudiences() > TRAGEDY_MAX_PEOPLE) {
            thisAmount += Play.TRAGEDY_EXTRA_PRICE * (this.getAudiences() - TRAGEDY_MAX_PEOPLE);
        }
        return thisAmount;
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

    public Play getPlay() {
        return play;
    }
}
