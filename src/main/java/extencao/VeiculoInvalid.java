package extencao;

import java.io.Serial;

public class VeiculoInvalid extends Exception{

     @Serial
    private static final long serialVersionUID = 1L;

    // Construtor da exceção UserInvalid, que recebe uma mensagem como argumento.
    public VeiculoInvalid(String msg) {
        super(msg);
    }

    
    
}
