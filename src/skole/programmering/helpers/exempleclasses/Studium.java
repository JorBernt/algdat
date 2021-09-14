package skole.programmering.helpers.exempleclasses;

public enum Studium {
    DATA("Ingeniørfag - data"),
    IT ("Informasjonsteknologi"),
    ANVENDT("Anvdent Datateknologi"),
    ELEKTRO("Ingeniørfag - elektronikk og informasjonsteknologi"),
    ENKELT_EMNE("Enkeltemnestudent");

    private final String fulltNavn;

    Studium(String fulltNavn) {
        this.fulltNavn = fulltNavn;
    }

    public String toString() { return fulltNavn; }
}
