public class Contant extends Betaalwijze {
    /**
     * Methode om betaling af te handelen
     */
    public boolean betaal(double tebetalen) {
        if(saldo >= tebetalen){
            saldo -= tebetalen;
            return true;
        }else{
            System.out.println("Te weinig saldo");
            return false;
        }

    }
}