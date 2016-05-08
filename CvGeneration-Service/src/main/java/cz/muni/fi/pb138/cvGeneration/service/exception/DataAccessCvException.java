package cz.muni.fi.pb138.cvGeneration.service.exception;

import org.springframework.dao.DataAccessException;

/**
 * Data access exception for project.
 *
 * @author Lenka Heldova
 */
public class DataAccessCvException extends DataAccessException {

    public DataAccessCvException(String msg) {
        super(msg);
    }

    public DataAccessCvException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
