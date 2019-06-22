package nl.hanze.KantineSimulatie;

import javax.persistence.EntityManager;

public class Kantine {

    private Kassa kassa;
    private KassaRij kassarij;
    private KantineAanbod kantineaanbod;
    private EntityManager manager;

    /**
     * Constructor
     */
    public Kantine(EntityManager manager) {
        kassarij = new KassaRij();
        kassa = new Kassa(manager, kassarij);
        this.manager = manager;
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
    public void verwerkRijVoorKassa() throws TeWeinigGeldException {
        while(kassarij.erIsEenRij()) {
            kassa.rekenAf();
            kassarij.removeKlant();
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