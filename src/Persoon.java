import java.text.SimpleDateFormat;
import java.util.Random;


public class Persoon {

    private int bsn;
    private String voornaam;
    private String achternaam;
    private Datum geboortedatum;
    private char geslacht;
    private Betaalwijze betaalwijze;

    public Persoon(int bsn, String voornaam, String achternaam, Datum geboortedatum, char geslacht){
        this.bsn = bsn;
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        this.geboortedatum = geboortedatum;
        setGeslacht(geslacht);

        Random rand = new Random();
        int random = rand.nextInt(10);
        if(random < 5){
            betaalwijze = new Contant();
            betaalwijze.setSaldo(20);
        } else {
            betaalwijze = new Pinpas();
            betaalwijze.setSaldo(20);
        }

    }

    public Persoon(){

    }

    public void setBsn(int bsn){
        this.bsn = bsn;
    }

    public void setVoornaam(String voornaam){
        this.voornaam = voornaam;
    }

    public void setAchternaam(String achternaam){
        this.achternaam = achternaam;
    }

    public void setGeboortedatum(Datum geboortedatum){
        this.geboortedatum = geboortedatum;
    }

    public void setGeslacht(char geslacht){
        if(geslacht == 'M' || geslacht == 'V') {
            this.geslacht = geslacht;
        }
        else{
            this.geslacht = 'O';
        }
    }

    public void setBetaalwijze(Betaalwijze betaalwijze){ this.betaalwijze = betaalwijze;}

    public int getBsn(){
        return bsn;
    }

    public String getVoornaam(){
        return voornaam;
    }

    public String getAchternaam(){
        return achternaam;
    }

    public String getGeboortedatum(){
        return geboortedatum.getDatumAsString();
    }

    public String getGeslacht(){
        switch(geslacht){
            case 'M':   return "Man";
            case 'V':   return "Vrouw";
            default:    return "Onbekend";
        }
    }

    public Betaalwijze getBetaalwijze(){ return betaalwijze;}

    @Override
    public String toString() {
        return "Persoon{" +
                "bsn=" + bsn +
                ", voornaam='" + voornaam + '\'' +
                ", achternaam='" + achternaam + '\'' +
                ", geboortedatum=" + geboortedatum +
                ", geslacht=" + geslacht +
                ", betaalwijze=" + betaalwijze +
                '}';
    }
}
