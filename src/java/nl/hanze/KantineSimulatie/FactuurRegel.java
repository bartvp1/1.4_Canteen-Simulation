package nl.hanze.KantineSimulatie;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class FactuurRegel implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @ManyToOne(cascade=CascadeType.ALL,targetEntity = Factuur.class)
    private Factuur factuur;

    @ManyToOne(cascade=CascadeType.ALL,targetEntity = Artikel.class)
    private Artikel artikel;

    public FactuurRegel() {}

    public FactuurRegel(Factuur factuur, Artikel artikel) {
        this.factuur = factuur;
        this.artikel = artikel;
    }

    /**
     * @return een printbare factuurregel
    */


    @Override
    public String toString() {
        return artikel.toString();
    }
}
