package ua.com.application.models;
public enum Team {

    LOS_ANGELES_LAKERS("LAL"), DETROIT_PISTONS("DET"), PHILADELPHIA_76ERS("PHI");

    private String shortName;
    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    Team(String shortName) {
        this.shortName = shortName;
    }
}
