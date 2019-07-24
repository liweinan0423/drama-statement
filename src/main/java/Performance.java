class Performance {

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
