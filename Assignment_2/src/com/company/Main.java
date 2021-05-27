package com.company;

import com.company.PassTwo.PassTwo;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        PassTwo passTwo = new PassTwo();

        System.out.println(passTwo.getMachineCode());
    }
}
