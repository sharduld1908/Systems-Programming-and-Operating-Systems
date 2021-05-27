package com.company.PassTwo;

import com.company.support.TableRow;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class PassTwo {
    private final ArrayList<TableRow> symbolTable;
    private final ArrayList<TableRow> literalTable;

    public PassTwo() throws IOException {
        symbolTable = new ArrayList<>();
        literalTable = new ArrayList<>();

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

    }

    public String getMachineCode() throws IOException {
        String line;
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new FileReader("IC.txt"));
        while((line = br.readLine()) != null) {
            String[] parts = line.split("\\s+");
            if(parts[0].contains("AD") || parts[0].equals("(DL,01)")) {
                sb.append("__ __ ____");
            }else if(parts.length == 1) {
//                if(parts[0].contains("IS")) {
                    sb.append(getCode(parts[0])).append(" 00 0000");
//                }
            }else if(parts.length == 2) {
                if(parts[0].contains("IS")) {
                    int i = Integer.parseInt(getCode(parts[1]));
                    sb.append(getCode(parts[0])).append(" 00").append(" ").append(symbolTable.get(i-1).getAddress());
                }else if(parts[0].equals("(DL,02)")) {
                    sb.append("00 00 000").append(getCode(parts[1]));
                }
            }else {
                int i = Integer.parseInt(getCode(parts[2]));
                sb.append(getCode(parts[0])).append(" ").append(getCode(parts[1])).append(" ");
                if(parts[2].contains("L")) {
                    sb.append(literalTable.get(i-1).getAddress());
                }
                else if(parts[2].contains("S")) {
                    sb.append(symbolTable.get(i-1).getAddress());
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }


    private String getCode(String s) {
        String[] parts = s.split(",");
        parts[1] = parts[1].replace(")","");
        return parts[1];
    }

}
