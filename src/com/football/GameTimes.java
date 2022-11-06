package com.football;

import java.util.Random;

public class GameTimes {
    Random random = new Random();
    public double passTime() {

        return Math.round(((random.nextInt(10)+1)/10.0)*100)/100.0;
    }

    public double outFieldTime() {
        return Math.round(((random.nextInt(10)+1)/10.0)*100)/100.0;
    }

    public double goalTime() {
        return Math.round(((random.nextInt(10)+1)/10.0)*100)/100.0;
    }
}
