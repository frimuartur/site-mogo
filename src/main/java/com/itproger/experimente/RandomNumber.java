package com.itproger.experimente;

public class RandomNumber {
    public String randomNumber(){
        int rand = (int)((Math.random()) * 100);
        String number = String.valueOf(rand);
        return number;
    }

}
