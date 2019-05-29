import java.util.Iterator;

public class Kassa {
    private double geldInKas;
    public KassaRij rij;
    private int aantalArtikelen;
    /**
     * Constructor
     */
    public Kassa(KassaRij kassarij) {
        rij=kassarij;
        geldInKas=0;
        aantalArtikelen=0;
    }

    /**
     * Vraag het aantal artikelen en de totaalprijs op.
     * Tel deze gegevens op bij de controletotalen die voor
     * de kassa worden bijgehouden. De implementatie wordt
     * later vervangen door een echte betaling door de persoon.
     *
     * @param klant die moet afrekenen
     */
    public void rekenAf(Dienblad klant) {
        geldInKas+=getTotaalPrijs();
        aantalArtikelen+=getAantalArtikelen();
    }
    /**
     * Methode om aantal artikelen op dienblad te tellen
     *
     * @return Het aantal artikelen
     */
    public int getAantalArtikelen() {
        int aantal=0;
        Iterator it = rij.eerstePersoonInRij().getArtikelen();
        while(it.hasNext()){
            Artikel element = (Artikel)it.next();
            aantal+=1;
            it.remove();
        }
        return aantal;
    }

    /**
     * Methode om de totaalprijs van de artikelen
     * op dienblad uit te rekenen
     *
     * @return De totaalprijs
     */
    public double getTotaalPrijs() {
        double totaal = 0;
        Iterator it = rij.eerstePersoonInRij().getArtikelen();
        while(it.hasNext()){
            Artikel element = (Artikel)it.next();
            totaal+=element.getPrijs();
            it.remove();
        }
        return totaal;
    }
    /**
     * Geeft het aantal artikelen dat de kassa heeft gepasseerd,
     * vanaf het moment dat de methode resetWaarden is aangeroepen.
     *
     * @return aantal artikelen
     */
    public int aantalArtikelen() {
        return aantalArtikelen;
    }

    /**
     * Geeft het totaalbedrag van alle artikelen die de kass
     * zijn gepasseerd, vanaf het moment dat de methode
     * resetKassa is aangeroepen.
     *
     * @return hoeveelheid geld in de kassa
     */
    public double hoeveelheidGeldInKassa() {
        return geldInKas;
    }

    /**
     * reset de waarden van het aantal gepasseerde artikelen en
     * de totale hoeveelheid geld in de kassa.
     */
    public void resetKassa() {
        geldInKas=0;
        aantalArtikelen=0;
    }
}