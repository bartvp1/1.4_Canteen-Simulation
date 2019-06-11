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


    public Iterator getArtikelen(){
        return artikelen.iterator();
    }

    public int getAantalArtikelen(){
        return artikelen.size();
    }

    public Persoon getKlant(){
        return klant;
    }

    public void setKlant(Persoon p){
        klant=p;
    }
}

