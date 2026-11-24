package com.ecoroute.exception;

public class CarbonThresholdExceededException extends RuntimeException {
    public CarbonThresholdExceededException(String message) {
        super(message);
    }
}