class Performance {

    public static final int TRAGEDY_MAX_PEOPLE = 30;
    public static final int COMEDY_MAX_PEOPLE = 20;
    public static final int VOLUME_CREDITS_THRESHOLD = 30;
    public static final int EXTRA_CREDIT_FACTOR = 5;
    private int audiences;
    private Play play;

    public Performance(Play play, int audiences) {
        this.audiences = audiences;
        this.play = play;
    }

    public int getAudiences() {
        return audiences;
    }


    public Play getPlay() {
        return play;
    }
}
