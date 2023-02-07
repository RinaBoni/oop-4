package com.example.energyinterface;

import static org.junit.jupiter.api.Assertions.*;

class EnergyTest {

    @org.junit.jupiter.api.Test
    void getBrand() {
        Energy en = new Energy();
        en.setBrand("Gorrila");
        assertEquals("Gorrila", en.getBrand());
    }

    @org.junit.jupiter.api.Test
    void setBrand() {
    }

    @org.junit.jupiter.api.Test
    void getTaste() {
        Energy en = new Energy();
        en.setTaste("Coconut");
        assertEquals("Coconut", en.getTaste());
    }

    @org.junit.jupiter.api.Test
    void setTaste() {
    }

    @org.junit.jupiter.api.Test
    void getName() {
        Energy en = new Energy();
        en.setName("Wild");
        assertEquals("Wild", en.getName());
    }

    @org.junit.jupiter.api.Test
    void setName() {
    }

    @org.junit.jupiter.api.Test
    void getEnergyValue() {
        Energy en = new Energy();
        en.setEnergyValue(440);
        assertEquals(440, en.getEnergyValue());
    }

    @org.junit.jupiter.api.Test
    void setEnergyValue() {
    }

    @org.junit.jupiter.api.Test
    void getСaffeine() {
        Energy en = new Energy();
        en.setVolume(0.5);
        assertEquals(0.5, en.getСaffeine());
    }

    @org.junit.jupiter.api.Test
    void setСaffeine() {
    }

    @org.junit.jupiter.api.Test
    void getTaurine() {
        Energy en = new Energy();
        en.setTaurine(0.7);
        assertEquals(0.7, en.getTaurine());
    }

    @org.junit.jupiter.api.Test
    void setTaurine() {
    }

    @org.junit.jupiter.api.Test
    void getPrice() {
        Energy en = new Energy();
        en.setPrice(100);
        assertEquals(100, en.getPrice());
    }

    @org.junit.jupiter.api.Test
    void setPrice() {
    }

    @org.junit.jupiter.api.Test
    void getVolume() {
        Energy en = new Energy();
        en.setVolume(499);
        assertEquals(499, en.getVolume());
    }

    @org.junit.jupiter.api.Test
    void setVolume() {
    }

   /*@org.junit.jupiter.api.Test
    void allInformation() {
       Energy en = new Energy();
       en.AllInformation();
       assertEquals(, en.AllInformation());
    }*/
}