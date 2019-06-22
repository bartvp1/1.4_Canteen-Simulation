package nl.hanze.KantineSimulatie;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Iterator;

@Entity @Table(name = "factuur")
public class Factuur implements Serializable {

    @Id @Column(name = "id",nullable = false) @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    @Column(name = "datum",nullable = false)
    private LocalDate datum;

    @Column(name = "korting",nullable = false)
    private double korting;

    @Column(name = "totaal",nullable = false)
    private double totaal;

    public Factuur(){
        totaal=0;
        korting=0;
    }

    public Factuur(Dienblad dienblad, LocalDate datum){
        this();
        this.datum = datum;
        verwerkBestelling(dienblad);
    }
    /**
     * Verwerk artikelen en pas kortingen toe.
     *
     * Zet het totaal te betalen bedrag en het
     * totaal aan ontvangen kortingen.
     *
     * @param klant
     */
    private void verwerkBestelling(Dienblad klant) {
        Iterator it = klant.getArtikelen();
        double sum_prijs=0;
        while(it.hasNext()){
            Artikel element = (Artikel)it.next();
            sum_prijs+=element.getPrijs();
            it.remove();
        }
        if(klant.getKlant() instanceof KortingskaartHouder){
            KortingskaartHouder persoon = (KortingskaartHouder)klant.getKlant();
            double max = persoon.geefMaximum();
            totaal = sum_prijs*(1-(persoon.geefKortingsPercentage()/100));
            if(persoon.heeftMaximum() && (sum_prijs-totaal)>max) {
                totaal = sum_prijs - max;
            }
        } else {
            totaal = sum_prijs;
        }
        korting = sum_prijs - totaal;

    }


    public long getId(){
        return id;
    }

    public LocalDate getDate(){
        return datum;
    }
    /*
    * @return het totaalbedrag
    */
    public double getTotaal() {
        return totaal;
    }

    /**
    * @return de toegepaste korting
    */
    public double getKorting() {
        return korting;
    }

    /**
     * @return een printbaar bonnetje
     */
    @Override
    public String toString() {
        return "Factuur{" +
                "id=" + id +
                ", datum=" + datum +
                ", korting=" + korting +
                ", totaal=" + totaal +
                '}';
    }
}
