package nl.hanze.KantineSimulatie;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.awt.*;
import java.time.LocalDate;

public class Kassa {
    private double geldInKas;
    public KassaRij rij;
    private int aantalArtikelen;
    private int totaalkorting;
    private EntityManager manager;

    /**
     * Constructor
     */
    public Kassa(EntityManager manager, KassaRij kassarij) {
        this.manager = manager;
        rij=kassarij;
        geldInKas=0;
        aantalArtikelen=0;
        totaalkorting=0;
    }

    /**
     * Vraag het aantal artikelen en de totaalprijs op.
     * Tel deze gegevens op bij de controletotalen die voor
     * de kassa worden bijgehouden. De implementatie wordt
     * later vervangen door een echte betaling door de persoon.
     */
    public void rekenAf() throws TeWeinigGeldException {
        Dienblad klant = rij.eerstePersoonInRij();

        int aantal = klant.getAantalArtikelen();
        double totaal = 0;

        Factuur factuur = new Factuur(klant, LocalDate.of(2019,1,KantineSimulatie.currentDay+1));
        double teBetalen = factuur.getTotaal();
        double korting = factuur.getKorting();

        //EntityTransaction transaction = null;
        try {
            Betaalwijze betaalwijze = klant.getKlant().getBetaalwijze();
            if (betaalwijze instanceof Pinpas || betaalwijze instanceof Contant) {
                betaalwijze.betaal(teBetalen);
                transaction(factuur);
                aantalArtikelen += aantal;
                geldInKas += teBetalen;
                totaalkorting += korting;
            }
        } catch(TeWeinigGeldException ex){
            System.out.println("Te weinig geld exception");
            throw ex;
        }
    }


    public void transaction(Factuur factuur){
        EntityTransaction transaction = null;
        //manager.isOpen();
        //System.out.println(manager.isOpen());
        try {
            // Get a transaction, sla de student gegevens op en commit de transactie
            transaction = manager.getTransaction();
            transaction.begin();
            manager.persist(factuur);
            transaction.commit();
        } catch (NullPointerException ex) {
            // If there are any exceptions, roll back the changes
            if (transaction != null) {
                transaction.rollback();
            }
            //ex.printStackTrace();
            System.out.println("Transaction failed (NullPointer)");
        }
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

    public double hoeveelheidKorting() {
        return totaalkorting;
    }

    /**
     * reset de waarden van het aantal gepasseerde artikelen en
     * de totale hoeveelheid geld in de kassa.
     */
    public void resetKassa() {
        geldInKas=0;
        aantalArtikelen=0;
        totaalkorting=0;
    }
}