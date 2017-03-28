package org.stpaul;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.persistence.NoResultException;

/**
 * Created by tjc4h on 3/28/2017.
 */
public abstract class BaseController {
    protected static final Logger LOGGER = LoggerFactory.getLogger(BaseController.class);
    protected static final int BAD_REQUEST = 400;

    public BaseController(){

    }

    @ExceptionHandler({NoResultException.class})
    public ResponseEntity<Exception> handleNoResultException(NoResultException nre) {
        LOGGER.info("> handleNoResultException");
        LOGGER.warn("-NoResultException", nre);
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public static class InternalServerErrorException extends Exception {
        public InternalServerErrorException(){

        }
    }
}
