public class Artikel {

    private String naam;
    private float prijs;

    public Artikel(String naam, float prijs){
        this.naam = naam;
        this.prijs = prijs;
    }

    public Artikel(){
    }

    public String getNaam(){
        return naam;
    }

    public float getPrijs(){
        return prijs;
    }

    public void setNaam(String nieuw){
        naam = nieuw;
    }

    public void setPrijs(float nieuw){
        prijs = nieuw;
    }

    @Override
    public String toString() {
        return "Artikel{" +
                "naam='" + naam + '\'' +
                ", prijs=" + prijs +
                '}';
    }
}
