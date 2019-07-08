class Performance {

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
