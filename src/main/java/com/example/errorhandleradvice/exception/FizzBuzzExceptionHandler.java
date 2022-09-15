package com.example.errorhandleradvice.exception;

import com.example.errorhandleradvice.dto.BuzzException;
import com.example.errorhandleradvice.dto.FizzBuzzException;
import com.example.errorhandleradvice.dto.FizzBuzzResponse;
import com.example.errorhandleradvice.dto.FizzException;
import com.example.errorhandleradvice.dto.GlobalError;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class FizzBuzzExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(FizzException.class)
    public ResponseEntity<GlobalError> fizzException(FizzException fizzException) {

        GlobalError globalError=new GlobalError();
        globalError.setErrorReason("Internal Server Error");
        globalError.setMessage("Fizz Exception has been thrown");
        return new ResponseEntity<GlobalError>(globalError, HttpStatus.INTERNAL_SERVER_ERROR);

    }
    @ExceptionHandler(BuzzException.class)
    public ResponseEntity<GlobalError> buzzException(BuzzException buzzException) {

        GlobalError globalError=new GlobalError();
        globalError.setErrorReason("Bad Request");
        globalError.setMessage("Buzz Exception has been thrown");
        return new ResponseEntity<GlobalError>(globalError,HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(FizzBuzzException.class)
    public ResponseEntity<GlobalError> fizzBuzzException(FizzBuzzException fizzBuzzException) {

        GlobalError globalError=new GlobalError();
        globalError.setErrorReason("Insufficient Storage");
        globalError.setMessage("FizzBuzz Exception has been thrown");
        return new ResponseEntity<GlobalError>(globalError,HttpStatus.INSUFFICIENT_STORAGE);

    }
}

