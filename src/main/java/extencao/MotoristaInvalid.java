package extencao;

import java.io.Serial;

public class MotoristaInvalid extends Exception {

    @Serial
    private static final long serialVersionUID = 1L;

    public MotoristaInvalid(String msg) {
        super(msg);
    }
}
