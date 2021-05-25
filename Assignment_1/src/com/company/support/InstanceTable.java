package com.company.support;

import java.util.HashMap;

public class InstanceTable {
    private static HashMap<String,String> AD;
    private static HashMap<String,String> RG;
    private static HashMap<String,String> IS;
    private static HashMap<String,String> CC;
    private static HashMap<String,String> DL;

    public InstanceTable() {
        //Initialize HashMaps
        AD = new HashMap<>();
        RG = new HashMap<>();
        IS = new HashMap<>();
        CC = new HashMap<>();
        DL = new HashMap<>();

        //Enter data in the classes
        IS.put("STOP","01");
        IS.put("ADD","02");
        IS.put("SUB","03");
        IS.put("MULTI","04");
        IS.put("MOVER","05");
        IS.put("MOVEM","06");
        IS.put("COMB","07");
        IS.put("BC","08");
        IS.put("DIV","09");
        IS.put("READ","10");
        IS.put("PRINT","11");

        AD.put("START","01");
        AD.put("END","02");
        AD.put("ORIGIN","03");
        AD.put("EQU","04");
        AD.put("LTORG","05");

        DL.put("DS","01");
        DL.put("DC","02");

        RG.put("AREG","01");
        RG.put("BREG","02");
        RG.put("CREG","03");
        RG.put("DREG","04");

        CC.put("EQ","01");
        CC.put("LT","02");
        CC.put("GT","03");
        CC.put("LE","04");
        CC.put("GE","05");
        CC.put("NE","06");
    }

    public String getType(String s) {
        s = s.toUpperCase();

        if(IS.containsKey(s)) {
            return "IS";
        }else if(AD.containsKey(s)) {
            return "AD";
        }else if(DL.containsKey(s)) {
            return "DL";
        }else if(RG.containsKey(s)) {
            return "RG";
        }else if(CC.containsKey(s)) {
            return "CC";
        }else {
            return "";
        }
    }

    public String getCode(String s) {
        s = s.toUpperCase();

        if(IS.containsKey(s)) {
            return "(IS,"+IS.get(s)+") ";
        }else if(AD.containsKey(s)) {
            return "(AD,"+AD.get(s)+") ";
        }else if(DL.containsKey(s)) {
            return "(DL,"+DL.get(s)+") ";
        }else if(RG.containsKey(s)) {
            return "(RG,"+RG.get(s)+") ";
        }else if(CC.containsKey(s)){
            return "(RG,"+CC.get(s)+") ";
        }else {
            return "-01";
        }
    }
}
