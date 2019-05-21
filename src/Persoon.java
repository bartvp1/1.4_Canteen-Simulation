import java.text.SimpleDateFormat;

public class Persoon {

    private int bsn;
    private String voornaam;
    private String achternaam;
    private Datum geboortedatum;
    private char geslacht;

    public Persoon(int bsn, String voornaam, String achternaam, Datum geboortedatum, char geslacht){
        this.bsn = bsn;
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        this.geboortedatum = geboortedatum;
        this.geslacht = geslacht;
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
        if(geslacht == 'M'){
           return "Man";
        }
        else if(geslacht == 'V'){
            return "Vrouw";
        }
        else{
            return "Onbekend";
        }
    }



}
