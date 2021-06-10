package com.company;

import com.company.PassOne.PassOne;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        PassOne passOne = new PassOne();
        passOne.parseFile("input4.asm");

        System.out.println(passOne.getIC());
        System.out.println(passOne.getSymbolTable());
        System.out.println(passOne.getLiteralTable());
        System.out.println(passOne.getPoolTable());
    }

}
