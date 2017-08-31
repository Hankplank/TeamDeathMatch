package me.untilt.Objects;

/**
 * Created by henry27 on 8/31/2017.
 */
public class Classes {

    public enum CLASS {
        DEFAULT,
        PVP,
        TANK;
        public String toString() {
            switch (this) {
                case DEFAULT:
                    return "Knight";
                case PVP:
                    return "Mage";
                case TANK:
                    return "Tank";
                default:
                    return "null";
            }
        }
    }

}
