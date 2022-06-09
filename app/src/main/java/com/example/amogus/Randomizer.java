package com.example.amogus;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Randomizer {
    private Integer[][] array;

    private int counter;
    public Randomizer(){
        array = new Integer[3][3];
        genImpostor();
        counter = 10;
    }

    public void genImpostor(){
        Integer[] shuffle= new Integer[9];
        for(int i = 0; i < 9 ; i++){
            shuffle[i] = i+1;
        }
        List<Integer> list = Arrays.asList(shuffle);
        Collections.shuffle(list);
        shuffle = list.toArray(shuffle);

        for (int i = 0, count = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++, count++) {
                array[i][j] = shuffle[count];
            }
        }
    }

    public void newGame(){
        genImpostor();
        resetCounter();
    }

    public boolean correct(int x, int y){
        if(array[x][y] == getCounter()-1){
            decCount();
            return true;
        }
        resetCounter();
        return false;
    }
    public int getCounter() {
        return counter;
    }
    public void decCount(){
        counter--;
    }
    public void resetCounter(){
        counter = 10;
    }

}
