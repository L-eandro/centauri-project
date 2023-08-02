package extencao;

import java.io.Serial;

public class MotoristaNonexistentExcepition extends Exception{

    @Serial
    private static final long serialVersionUID = 1L;

    // Construtor da exceção MotoristaNonexistentExcepition, que recebe uma mensagem como argumento.
    public MotoristaNonexistentExcepition(String msg) {
        super(msg);
    }
}
