package nl.hanze.KantineSimulatie;

public class Administratie {

    private static final int DAYS_IN_WEEK = 7;
    /**
     * Deze methode berekent van de int array aantal de gemiddelde waarde
     *
     * @param aantal
     * @return het gemiddelde
     */
    public static double berekenGemiddeldAantal(int[] aantal) {
        int totaal = 0;
        for (int i : aantal) {
            totaal += i;
        }
        return totaal / aantal.length;
    }

    /**
     * Deze methode berekent van de double array omzet de gemiddelde waarde
     *
     * @param omzet
     * @return het gemiddelde
     */
    public static double berekenGemiddeldeOmzet(double[] omzet) {
        double totaal = 0;
        for (double i : omzet) {
            totaal += i;
        }
        return totaal / omzet.length;
    }

    //public static double berekenTotaleOmzet();

    /**
     * Methode om dagomzet uit te rekenen
     *
     * @param omzet
     * @return array (7 elementen) met dagomzetten
     */

    public static double[] berekenDagOmzet(double[] omzet) {
        double[] temp_omzet = new double[DAYS_IN_WEEK];
        for (int i = 0; i < DAYS_IN_WEEK; i++) {
            int j = 0;
            while (omzet.length > i + DAYS_IN_WEEK * j) {
                temp_omzet[i] += omzet[i + DAYS_IN_WEEK * j];
                j++;
            }
        }
        return temp_omzet;
    }
}
