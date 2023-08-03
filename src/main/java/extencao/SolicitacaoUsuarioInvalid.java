package extencao;

import java.io.Serial;

public class SolicitacaoUsuarioInvalid extends Exception{

     @Serial
    private static final long serialVersionUID = 1L;

    // Construtor da exceção MotoristaInvalid, que recebe uma mensagem como argumento.
    public SolicitacaoUsuarioInvalid(String msg) {
        super(msg);
    }
    
}
