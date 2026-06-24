package es.jamasa.tpv.exception;


/**
 * Excepción de que un usuario ya existe. 
 */
public final class UserAlreadyExistException extends AlreadyExistException {

    private static final long serialVersionUID = 5861310537366287163L;

    public UserAlreadyExistException(String messageKey, Object dto, Object... args) {
        super(messageKey, dto, args);
    }
}
