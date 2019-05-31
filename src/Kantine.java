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
     * @param dienblad
     * @param artikelnamen
     */

     public void loopPakSluitAan(Dienblad dienblad, String[] artikelnamen)
     {
        for(String naam : artikelnamen){
            dienblad.voegToe(kantineaanbod.getArtikel(naam));
        }
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

    public void setKantineAanbod(KantineAanbod aanbod) {
        kantineaanbod = aanbod;
    }
}