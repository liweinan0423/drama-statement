class Performance {

    public static final int TRAGEDY_MAX_PEOPLE = 30;
    public static final int COMEDY_MAX_PEOPLE = 20;
    public static final int VOLUME_CREDITS_THRESHOLD = 30;
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
}
