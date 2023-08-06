package extencao;

import java.io.Serial;

public class UsuarioNoExistExtencao extends Exception {

    @Serial
    private static final long serialVersionUID = 1L;

    // Construtor da exceção UsuarioNoExistExtencao, que recebe uma mensagem como argumento.
    public UsuarioNoExistExtencao(String msg) {
        super(msg);
    }
}
