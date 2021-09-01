package skole.programmering;

import skole.programmering.helpers.Tabell;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int[] a = Tabell.randPerm(20); // tilfeldig permutasjon av 1 . . 20
        int[] b = Tabell.nextMaxSwapLast(a);  // metoden returnerer en tabell

        int m = b[0], nm = b[1];       // m for maks, nm for nestmaks

        Tabell.writeln(a);        // se Oppgave 5 i Avsnitt 1.2.2
        System.out.print("Størst(" + a[m] + ") har posisjon " + m);
        System.out.println(", nest størst(" + a[nm] + ") har posisjon " + nm);
        Tabell.swapSortAsc(a);
        Tabell.writeln(a);
        Tabell.swapSortDesc(a);
        Tabell.writeln(a);
    }
}
