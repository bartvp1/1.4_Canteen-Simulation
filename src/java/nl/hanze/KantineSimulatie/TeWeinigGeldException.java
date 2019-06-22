package nl.hanze.KantineSimulatie;

public class TeWeinigGeldException extends Exception {
    TeWeinigGeldException(){
        super();
    }
    TeWeinigGeldException(Exception e){
        super(e);
    }
    TeWeinigGeldException(String message){
        super(message);
    }

}
