public class Artikel {

    private String naam;
    private double prijs;

    public Artikel(String naam, double prijs){
        this.naam = naam;
        this.prijs = prijs;
    }

    public Artikel(){
    }

    public String getNaam(){
        return naam;
    }

    public double getPrijs(){
        return prijs;
    }

    public void setNaam(String nieuw){
        naam = nieuw;
    }

    public void setPrijs(double nieuw){
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
