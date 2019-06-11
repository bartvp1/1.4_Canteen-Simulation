import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class KassaRij {

    public Queue<Dienblad> dienbladen;
    /**
     * Constructor
     */
    public KassaRij() {
        dienbladen = new LinkedList();
    }

    /**
     * Persoon sluit achter in de rij aan
     *
     * @param klant
     */
    public void sluitAchteraan(Dienblad klant) {
        dienbladen.add(klant);
    }

    /**
     * Indien er een rij bestaat, de eerste klant uit
     * de rij verwijderen en retourneren.
     * Als er niemand in de rij staat geeft deze null terug.
     *
     * @return Eerste klant in de rij of null
     */
    public Dienblad eerstePersoonInRij() {
        return dienbladen.peek();

    }

    /**
     * Methode kijkt of er personen in de rij staan.
     *
     * @return Of er wel of geen rij bestaat
     */
    public boolean erIsEenRij() {
        return dienbladen.size() > 0;
    }
    public void removeKlant(){
        dienbladen.remove(eerstePersoonInRij());
    }
}