package extencao;

import java.io.Serial;

public class MotoristaInvalid extends Exception {

    @Serial
    private static final long serialVersionUID = 1L;

    // Construtor da exceção MotoristaInvalid, que recebe uma mensagem como argumento.
    public MotoristaInvalid(String msg) {
        super(msg);
    }
}
