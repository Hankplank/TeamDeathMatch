package me.untilt.Objects;

/**
 * Created by henry27 on 8/31/2017.
 */
public class Kit {

    public enum KITS {
        KNIGHT,
        MAGE,
        TANK;
        public String toString() {
            switch (this) {
                case KNIGHT:
                    return "Knight";
                case MAGE:
                    return "Mage";
                case TANK:
                    return "Tank";
                default:
                    return "NULL";
            }

        }
    }


}
