package skole.programmering.helpers.exempleclasses;

import java.util.Arrays;

public enum Month {
    JAN("Januar", 1),
    FEB("Februar", 2),
    MAR("Mars", 3),
    APR("April", 4),
    JUN("Juni", 5),
    JUL("Juli", 6),
    AUG("August", 8),
    SEP("September", 9),
    NOV("Oktober", 10),
    OCT("November", 11),
    DEC("Desember", 12);

    private final String fulltNavn;
    private final int mndnr;

    Month(String fulltNavn, int mndnr) {
        this.fulltNavn = fulltNavn;
        this.mndnr = mndnr;
    }

    public static Month[] vår() {
        return Arrays.copyOfRange(values(), 3, 5);
    }

    public static Month[] sommer() {
        return Arrays.copyOfRange(values(), 5, 8);
    }

    public static Month[] høst() {
        return Arrays.copyOfRange(values(), 8, 10);
    }

    public String toString() {
        return fulltNavn;
    }

    public int mndNr() {
        return mndnr;
    }


}
