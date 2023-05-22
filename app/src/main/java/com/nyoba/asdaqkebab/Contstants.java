package com.nyoba.asdaqkebab;

import java.util.ArrayList;

public class Contstants {
    public static ArrayList<Items> getItemsData() {
        ArrayList<Items> itemList = new ArrayList<>();
        Items lap1 = new Items("20.11.2003", "Jember", 200000 );
        itemList.add(lap1);
        Items lap2 = new Items("21.11.2003", "Probolinggo", 300000 );
        itemList.add(lap2);
        Items lap3 = new Items("22.11.2003", "Bali", 250000 );
        itemList.add(lap3);
        Items lap4 = new Items("23.11.2003", "Malang", 300000 );
        itemList.add(lap4);
        Items lap5 = new Items("24.11.2003", "Situbondo", 400000 );
        itemList.add(lap5);
        Items lap6 = new Items("25.11.2003", "Bondowoso", 600000 );
        itemList.add(lap6);
        Items lap7 = new Items("26.11.2003", "Kalimantan Tengah", 210000 );
        itemList.add(lap7);
        return itemList;
    }
}
