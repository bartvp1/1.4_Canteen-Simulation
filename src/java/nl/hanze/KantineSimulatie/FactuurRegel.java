package nl.hanze.KantineSimulatie;

import java.io.Serializable;
import javax.persistence.*;

//@Entity
public class FactuurRegel implements Serializable {
    /*@Id @Column(name="id") @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Id
    private Factuur factuur;

    private Artikel artikel;
    public FactuurRegel() {}

    public FactuurRegel(Factuur factuur, Artikel artikel) {
        this.factuur = factuur;
        this.artikel = artikel;
    }

    /**
     * @return een printbare factuurregel
    */

    /*
    @Override
    public String toString() {
        return "FactuurRegel{" +
                "id=" + id +
                ", factuur=" + factuur +
                ", artikel=" + artikel +
                '}';
    }*/
}
