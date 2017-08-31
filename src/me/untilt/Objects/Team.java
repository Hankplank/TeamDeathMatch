package me.untilt.Objects;

/**
 * Created by henry27 on 8/31/2017.
 */
public class Team {

    public enum TEAM {
        RED,
        BLUE;
        public String toString() {
            switch (this) {
                case RED:
                    return "RED";
                case BLUE:
                    return "BLUE";
                default:
                    return "null";
            }
        }
    }
}
