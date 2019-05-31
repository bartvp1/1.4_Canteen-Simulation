public class Kantine {

    private Kassa kassa;
    private KassaRij kassarij;
    private KantineAanbod kantineaanbod;


    /**
     * Constructor
     */
    public Kantine() {
        kassarij = new KassaRij();
        kassa = new Kassa(kassarij);
    }

     /**
     * In deze methode kiest een Persoon met een dienblad
     * de artikelen in artikelnamen.
     *
     * @param persoon
     * @param artikelnamen
     */

    public void loopPakSluitAan(Persoon persoon, String[] artikelnamen) {
        Persoon klant = new Persoon();
        Dienblad dienblad = new Dienblad(klant);
        dienblad.voegToe(new Artikel());
        dienblad.voegToe(new Artikel());
        kassarij.sluitAchteraan(dienblad);
    }

    /**
     * Deze methode handelt de rij voor de kassa af.
     */
    public void verwerkRijVoorKassa() {
        while(kassarij.erIsEenRij()) {
            kassa.rekenAf(kassarij.eerstePersoonInRij());
        }
    }

    public Kassa getKassa(){
        return kassa;
    }

    public KantineAanbod getKantineaanbod(){
        return kantineaanbod;
    }

    public void setKantineaanbod(KantineAanbod kantineaanbod){
        this.kantineaanbod = kantineaanbod;
    }
}