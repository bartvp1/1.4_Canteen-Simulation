import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class Dienblad {
    private Stack<Artikel> artikelen;
    private Persoon klant;

    /**
     * Constructor
     */
    public Dienblad() {
        artikelen = new Stack();
    }
    public Dienblad(Persoon p) {
        klant=p;
        artikelen = new Stack();
    }

    /**
     * Methode om artikel aan dienblad toe te voegen
     *
     * @param a
     */
    public void voegToe(Artikel a) {
        artikelen.add(a);
    }

    /**
     * Methode om aantal artikelen op dienblad te tellen
     *
     * @return Het aantal artikelen
     */
    public int getAantalArtikelen() {
        return artikelen.size();
    }

    /**
     * Methode om de totaalprijs van de artikelen
     * op dienblad uit te rekenen
     *
     * @return De totaalprijs
     */
    public double getTotaalPrijs() {
        double totaal = 0;
        for(Artikel a : artikelen){
            totaal+=a.getPrijs();
        }
        return totaal;
    }

    public Persoon getKlant(){
        return klant;
    }

    public void setKlant(Persoon p){
        klant=p;
    }
}

