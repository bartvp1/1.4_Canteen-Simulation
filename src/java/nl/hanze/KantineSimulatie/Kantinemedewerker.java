package nl.hanze.KantineSimulatie;

public class Kantinemedewerker extends Persoon implements KortingskaartHouder {
    int medewerkersnummer;
    boolean magKassa;

    Kantinemedewerker(int medewerkersnummer, boolean magKassa,int bsn, String voornaam, String achternaam, Datum geboortedatum, char geslacht){
        super(bsn,voornaam,achternaam,geboortedatum,geslacht);
        this.medewerkersnummer = medewerkersnummer;
        this.magKassa = magKassa;
    }

    @Override
    public double geefKortingsPercentage() {
        return 35;
    }

    @Override
    public boolean heeftMaximum() {
        return false;
    }

    @Override
    public double geefMaximum() {
        return 0;
    }

    @Override
    public String toString() {
        return "Kantinemedewerker{" +
                "medewerkersnummer=" + medewerkersnummer +
                ", magKassa=" + magKassa +
                '}';
    }
}
