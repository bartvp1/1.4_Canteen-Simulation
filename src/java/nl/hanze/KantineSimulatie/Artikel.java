package nl.hanze.KantineSimulatie;

import javax.persistence.*;

@Entity(name="artikel")
public class Artikel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String naam;
    private double prijs;

    public Artikel(String naam, double prijs){
        this.naam = naam;
        this.prijs = prijs;
    }
    public Artikel(){}

    public String getNaam(){
        return naam;
    }

    public double getPrijs(){
        return prijs;
    }

    @Override
    public String toString() {
        return "Artikel{" +
                "naam='" + naam + '\'' +
                ", prijs=" + prijs +
                '}';
    }
}
