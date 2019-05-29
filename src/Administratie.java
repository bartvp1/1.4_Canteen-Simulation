public class Administratie {

    /**
     * Deze methode berekent van de int array aantal de gemiddelde waarde
     *
     * @param aantal
     * @return het gemiddelde
     */
    public double berekenGemiddeldAantal(int[] aantal) {
        int totaal=0;
        for(int i : aantal){ totaal+=i; }
        return totaal/aantal.length;
    }

    /**
     * Deze methode berekent van de double array omzet de gemiddelde waarde
     *
     * @param omzet
     * @return het gemiddelde
     */
    public double berekenGemiddeldeOmzet(double[] omzet) {
        double totaal=0;
        for(double i : omzet){ totaal+=i; }
        return totaal/omzet.length;
    }

    /**
     * Methode om dagomzet uit te rekenen
     *
     * @param omzet
     * @return array (7 elementen) met dagomzetten
     */

    public static double[] berekenDagOmzet(double[] omzet) {
        double[] temp_omzet=new double[7];
        for(int i=0;i<7;i++) {
            int j=0;
            while(omzet.length>i+7*j) {
                temp_omzet[i]+=omzet[i+7*j];
                j++;
            }
        }
        return temp_omzet;
    }
}
