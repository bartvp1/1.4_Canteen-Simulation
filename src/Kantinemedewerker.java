public class Kantinemedewerker extends Persoon {
    int medewerkersnummer;
    boolean magKassa;

    Kantinemedewerker(int medewerkersnummer, boolean magKassa,int bsn, String voornaam, String achternaam, Datum geboortedatum, char geslacht){
        super(bsn,voornaam,achternaam,geboortedatum,geslacht);
        this.medewerkersnummer = medewerkersnummer;
        this.magKassa = magKassa;
    }

    @Override
    public String toString() {
        return "Kantinemedewerker{" +
                "medewerkersnummer=" + medewerkersnummer +
                ", magKassa=" + magKassa +
                '}';
    }
}
