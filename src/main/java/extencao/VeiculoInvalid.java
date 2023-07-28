package extencao;

import java.io.Serial;

public class VeiculoInvalid extends Exception{

     @Serial
    private static final long serialVersionUID = 1L;

    public VeiculoInvalid(String msg) {
        super(msg);
    }
    
}
