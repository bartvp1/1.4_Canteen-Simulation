public class Docent extends Persoon {
    String afkorting;
    String afdeling;

    Docent(String afkorting, String afdeling,int bsn, String voornaam, String achternaam, Datum geboortedatum, char geslacht){
        super(bsn,voornaam,achternaam,geboortedatum,geslacht);
        this.afkorting = afkorting;
        this.afdeling = afdeling;
    }
}
