package com.company.PassTwo;

import com.company.support.TableRow;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class PassTwo {
    private final ArrayList<TableRow> symbolTable;
    private final ArrayList<TableRow> literalTable;
    private final ArrayList<Integer> poolTable;

    public PassTwo() throws IOException {
        symbolTable = new ArrayList<>();
        literalTable = new ArrayList<>();
        poolTable = new ArrayList<>();

        String line;
        BufferedReader br = new BufferedReader(new FileReader("SymbolTable.txt"));
        while((line=br.readLine())!=null) {
            String[] parts = line.split("\\s+");
            symbolTable.add(new TableRow(parts[1],Integer.parseInt(parts[2]),Integer.parseInt(parts[0])));
        }

        br = new BufferedReader(new FileReader("LiteralTable.txt"));
        while((line=br.readLine())!=null) {
            String[] parts = line.split("\\s+");
            literalTable.add(new TableRow(parts[1],Integer.parseInt(parts[2]),Integer.parseInt(parts[0])));
        }

        br = new BufferedReader(new FileReader("PoolTable.txt"));
        while((line=br.readLine())!=null) {
            poolTable.add(Integer.parseInt(line));
        }
    }

    public String getMachineCode() throws IOException {
        String line;
        BufferedReader br = new BufferedReader(new FileReader("IC.txt"));
        while((line = br.readLine()) != null) {
            String[] parts = line.split("\\s+");
            for (String part : parts) {
                System.out.print(part + " ");
            }
            System.out.println();
        }
        return "boku wa tobi";
    }

    public String getSymbolTable() {
        StringBuilder temp = new StringBuilder();
        temp.append("\n**********************SYMBOL TABLE**********************\n");
        temp.append("Index\tSymbol\tAddress\n");
        for(TableRow tableRow : symbolTable) {
            String symbol = tableRow.getSymbol();
            int address = tableRow.getAddress();
            int index = tableRow.getIndex();
            temp.append(index).append("\t\t").append(symbol).append("\t\t").append(address).append("\n");
        }
        return temp.toString();
    }

    public String getLiteralTable() {
        StringBuilder temp = new StringBuilder();
        temp.append("\n**********************LITERAL TABLE**********************\n");
        temp.append("Index\tLiteral\tAddress\n");
        for(TableRow tableRow : literalTable) {
            String symbol = tableRow.getSymbol();
            int address = tableRow.getAddress();
            int index = tableRow.getIndex();
            temp.append(index).append("\t\t").append(symbol).append("\t\t").append(address).append("\n");
        }
        return temp.toString();
    }

    public String getPoolTable() {
        StringBuilder temp = new StringBuilder();
        temp.append("\n**********************POOL TABLE**********************\n");
        temp.append("Index\n");
        for(Integer i : poolTable) {
            temp.append(i).append("\n");
        }
        return temp.toString();
    }
}
