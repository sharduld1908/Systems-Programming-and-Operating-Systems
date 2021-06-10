package com.company.PassOne;

import com.company.support.InstanceTable;
import com.company.support.TableRow;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class PassOne {
    private int locCounter;
    private int literalTable_pnt;
    private int poolTable_pnt;
    private int symbolIndex;
    private int literalIndex;

    private final LinkedHashMap<String, TableRow> symbolTable;
    private final ArrayList<TableRow> literalTable;
    private final ArrayList<Integer> poolTable;
    private final StringBuilder sb;

    public PassOne() {
        this.locCounter = 0;
        this.literalTable_pnt = 0;
        this.poolTable_pnt = 0;
        this.symbolIndex = 0;
        this.literalIndex = 0;

        symbolTable = new LinkedHashMap<>();
        literalTable = new ArrayList<>();
        poolTable = new ArrayList<>();
        poolTable.add(0);
        sb = new StringBuilder();
    }

    public void parseFile(String s) throws IOException {
        String line;
        BufferedReader br = new BufferedReader(new FileReader(s));

        while((line = br.readLine()) != null) {
            line = line.toUpperCase();
            String[] parts =line.split("\\s+");

            if(!parts[0].isEmpty()) {
                if(symbolTable.containsKey(parts[0])) {
                    symbolTable.put(parts[0], new TableRow(parts[0], locCounter, symbolTable.get(parts[0]).getIndex()));
                }else {
                    symbolTable.put(parts[0],new TableRow(parts[0], locCounter, ++symbolIndex));
                }
//                sb.append("(S,").append(symbolTable.get(parts[0]).getIndex()).append(") ");
            }
            if(parts[1].equals("START")) {
                locCounter = expr(parts[2]);
                sb.append(InstanceTable.getCode(parts[1]));
                sb.append("(C,").append(locCounter).append(") ");
            }
            if(parts[1].equals("ORIGIN")) {
                locCounter = expr(parts[2]);
                sb.append(InstanceTable.getCode(parts[1]));
                sb.append("(C,").append(locCounter).append(") ");
            }
            if(parts[1].equals("LTORG")) {
                int ptr = poolTable.get(poolTable_pnt);
                for(int j = ptr; j<literalTable_pnt; j++) {
                    sb.append(InstanceTable.getCode("DC")).append("(C,").append(literalTable.get(j).getSymbol()).append(")");
                    if(j != literalTable_pnt-1) {
                        sb.append("\n");
                    }
                    literalTable.get(j).setAddress(locCounter);
                    ++locCounter;
                }
                poolTable_pnt++;
                poolTable.add(literalTable_pnt);
            }
            if(parts[1].equals("EQU"))
            {
                int loc=expr(parts[2]);
                //below If conditions are optional as no IC is generated for them
                if(parts[2].contains("+"))
                {
                    String[] splits =parts[2].split("\\+");
                    sb.append(InstanceTable.getCode(parts[1])).append("(S,").append(symbolTable.get(splits[0]).getIndex()).append(")+").append(splits[1]);
                }
                else if(parts[2].contains("-"))
                {
                    String[] splits =parts[2].split("\\-");
                    sb.append(InstanceTable.getCode(parts[1])).append("(S,").append(symbolTable.get(splits[0]).getIndex()).append(")-").append(splits[1]);
                }
                else
                {
                    sb.append(InstanceTable.getCode(parts[1])).append("(C,").append(parts[2]);
                }
                if(symbolTable.containsKey(parts[0]))
                    symbolTable.put(parts[0], new TableRow(parts[0],loc,symbolTable.get(parts[0]).getIndex())) ;
                else
                    symbolTable.put(parts[0], new TableRow(parts[0],loc,++symbolIndex));
                ++locCounter;
            }
            if(parts[1].equals("DS")) {
                sb.append(InstanceTable.getCode(parts[1])).append("(C,").append(parts[2]).append(") ");
                locCounter = locCounter + Integer.parseInt(parts[2]);
            }
            if(parts[1].equals("DC")) {
                ++locCounter;
                int constant = Integer.parseInt(parts[2].replace("'",""));
                sb.append(InstanceTable.getCode(parts[1])).append("(C,").append(constant).append(") ");
            }
            if(InstanceTable.getType(parts[1]).equals("IS")) {
                sb.append(InstanceTable.getCode(parts[1]));
                int j = 2;
                while(j < parts.length) {
                    parts[j]=parts[j].replace(",", "");
                    if(InstanceTable.getType(parts[j]).equals("RG") || InstanceTable.getType(parts[j]).equals("CC")) {
                        sb.append(InstanceTable.getCode(parts[j]));
                    }
                    else {
                        if(parts[j].contains("=")) {
                            parts[j] = parts[j].replace("=","").replace("'","");
                            literalTable.add(new TableRow(parts[j],-1,++literalIndex));
                            ++literalTable_pnt;
                            sb.append("(L,").append(literalIndex).append(") ");
                        }else if(symbolTable.containsKey(parts[j])) {
                            int idx=symbolTable.get(parts[j]).getIndex();
                            sb.append("(S,").append(idx).append(") ");
                        }
                        else {
                            symbolTable.put(parts[j],new TableRow(parts[j],-1,++symbolIndex));
                            int idx=symbolTable.get(parts[j]).getIndex();
                            sb.append("(S,").append(idx).append(") ");
                        }
                    }
                    j++;
                }
                ++locCounter;
            }
            if(parts[1].equals("END")) {
                int ptr = poolTable.get(poolTable_pnt);
                if(ptr != literalTable_pnt) {
                    for(int j = ptr; j<literalTable_pnt; j++) {
                        sb.append(InstanceTable.getCode("LTORG")).append(InstanceTable.getCode("DC")).append("(C,").append(literalTable.get(j).getSymbol()).append(")\n");
                        literalTable.get(j).setAddress(locCounter);
                        ++locCounter;
                    }
//                    poolTable_pnt++;
//                    poolTable.add(literalTable_pnt);
                }else {
                    poolTable.remove(poolTable_pnt);
                }
                sb.append(InstanceTable.getCode(parts[1]));
            }
            sb.append("\n");
        }
    }

    public String getIC() {
        return sb.toString();
    }

    public String getSymbolTable() {
        StringBuilder temp = new StringBuilder();
        temp.append("\n**********************SYMBOL TABLE**********************\n");
        temp.append("Index\tSymbol\tAddress\n");
        for(Map.Entry<String,TableRow> mapElement : symbolTable.entrySet()) {
            TableRow tableRow = mapElement.getValue();
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

    private int expr(String str)
    {
        int temp;
        if(str.contains("+"))
        {
            String[] splits =str.split("\\+");
            temp = symbolTable.get(splits[0]).getAddress()+Integer.parseInt(splits[1]);
        }
        else if(str.contains("-"))
        {
            String[] splits =str.split("\\-");
            temp = symbolTable.get(splits[0]).getAddress()-(Integer.parseInt(splits[1]));
        }else
        {
            temp=Integer.parseInt(str);
        }
        return temp;
    }
}
