package com.ra58ad.bicyclerentalsystem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CustomerWindowTest extends CustomerWindow {
    @Test
    void addSampleBikesTest() {
        new Welcome().addSamples();
    }

    @Override
    void display() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'display'");
    }
}
