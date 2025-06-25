package org.example;

import java.util.HashMap;
import java.util.Map;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static String[] buildMonth(int indexDayStart, int numberDays){
        if(indexDayStart < 0 ||  indexDayStart >= 7){
            throw new IllegalArgumentException("indexWochentagStart must be between 0 and 6");
        }

        String[] month = new String[numberDays + indexDayStart];
        for(int i = 0; i < indexDayStart; i++){
            month[i] = "  ";
        }

        for(int i = indexDayStart; i < month.length; i++){
            String day = "";
            if(i + 1 - indexDayStart < 10)
                day += " ";
            day += (i + 1 - indexDayStart);
            month[i] = day;
        }

        return month;
    }

    public static void printMonth(String[] month, String name){
        System.out.println(name);
        System.out.println("Mo Di Mi Do Fr Sa So");
        StringBuilder monthString = new StringBuilder();
        for(int i = 0; i < month.length; i++){
            if(i>0 && i%7==0)
                monthString.append("\n");
            else if(i>0) monthString.append(" ");
            monthString.append(month[i]);
        }
        System.out.println(monthString);
        System.out.println();
    }



    public static void main(String[] args) {
        
        enum MONTHS{
            JANUARY("Januar", 31),
            FEBRUARY("Februar", 28),
            MARCH("März", 31),
            APRIL("April", 30),
            MAY("Mai", 31),
            JUNE("Juni", 30),
            JULY("Juli", 31),
            AUGUST("August", 31),
            SEPTEMBER("September", 30),
            OCTOBER("Oktober", 31),
            NOVEMBER("November", 30),
            DECEMBER("Dezember", 31);
            
            final String name;
            final int numberDays;
            
            MONTHS(String name, int numberDays){
                this.name = name;
                this.numberDays = numberDays;
            }
            
            public String getName(){
                return name;
            }

            public int getNumberDays() {
                return numberDays;
            }
        }
        
        Map<MONTHS, String[]> monthsMetaData = new HashMap<>();

        int indexDay = 0;
        for(MONTHS month : MONTHS.values()){
            monthsMetaData.put(month, buildMonth(indexDay, month.getNumberDays()));
            indexDay = monthsMetaData.get(month).length % 7;
        }

        for(MONTHS month : MONTHS.values()){
            printMonth(monthsMetaData.get(month), month.getName());
        }
        
    }
}