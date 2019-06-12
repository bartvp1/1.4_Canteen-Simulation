public class Docent extends Persoon implements KortingskaartHouder {
    String afkorting;
    String afdeling;

    Docent(String afkorting, String afdeling, int bsn, String voornaam, String achternaam, Datum geboortedatum, char geslacht){
        super(bsn,voornaam,achternaam,geboortedatum,geslacht);
        this.afkorting = afkorting;
        this.afdeling = afdeling;
    }

    @Override
    public double geefKortingsPercentage() {
        return 25;
    }

    @Override
    public boolean heeftMaximum() {
        return true;
    }

    @Override
    public double geefMaximum() {
        return 1;
    }

    @Override
    public String toString() {
        return "Docent{" +
                "afkorting='" + afkorting + '\'' +
                ", afdeling='" + afdeling + '\'' +
                '}';
    }
}
