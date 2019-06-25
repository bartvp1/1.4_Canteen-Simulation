package nl.hanze.KantineSimulatie;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Entity(name="factuur")
@NamedQueries({
        @NamedQuery(name = "3a", query = "select sum(totaal) from factuur"),
        @NamedQuery(name = "3b", query = "select avg(totaal) from factuur"),
        @NamedQuery(name = "3c", query = "select totaal from factuur order by totaal desc")
})
public class Factuur implements Serializable {

    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

    private LocalDate datum;

    private double korting;

    private double totaal;

    @OneToMany(cascade = {CascadeType.ALL})
    private List<FactuurRegel> regels;

    public Factuur(){
        totaal=0;
        korting=0;
    }

    public Factuur(Dienblad dienblad, LocalDate datum){
        this();
        this.datum = datum;
        regels = new ArrayList<>();
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
        FactuurRegel regel;
        while(it.hasNext()){
            Artikel element = (Artikel)it.next();
            sum_prijs+=element.getPrijs();
            regel = new FactuurRegel(this,element);
            regels.add(regel);
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
        System.out.println(this);
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

    /*public void transaction(List regels){
        EntityTransaction transaction = null;
        for(Object regel : regels){
            try {
                // Get a transaction, sla de student gegevens op en commit de transactie
                transaction = KantineSimulatie.manager.getTransaction();
                transaction.begin();
                KantineSimulatie.manager.persist(regel);
                transaction.commit();
            } catch (Exception ex) {
                // If there are any exceptions, roll back the changes
                if (transaction != null) {
                    transaction.rollback();
                }
                ex.printStackTrace();
                System.out.println("Transaction failed - Factuur.java");
            }
        }
    }*/

    /**
     * @return een printbaar bonnetje
     */
    @Override
    public String toString() {
        String s = "Factuur{datum=" + datum + ", korting= \u20ac" + korting + ", totaal= \u20ac "+ totaal +"}\n";
        for(FactuurRegel regel : regels){
            s=s+"   "+regel.toString()+"\n";
        }
        return s;
    }
}
