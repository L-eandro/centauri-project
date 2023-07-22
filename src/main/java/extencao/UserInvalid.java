package extencao;

import java.io.Serial;

public class UserInvalid extends Exception {

    @Serial
    private static final long serialVersionUID = 1L;

    public UserInvalid(String msg) {
        super(msg);
    }

}
