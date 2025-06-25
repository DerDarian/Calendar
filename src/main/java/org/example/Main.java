package org.example;

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

        String[] januar = buildMonth(0, 31);
        int indexDay = januar.length % 7;

        String[] februar = buildMonth(indexDay, 28);
        indexDay = februar.length % 7 ;

        String[] maerz = buildMonth(indexDay, 31);
        indexDay = maerz.length  % 7;

        String[] april = buildMonth(indexDay, 30);
        indexDay = april.length % 7;

        String[] mai = buildMonth(indexDay, 31);
        indexDay = mai.length % 7;

        String[] juni = buildMonth(indexDay, 30);
        indexDay = juni.length % 7 ;

        String[] juli = buildMonth(indexDay, 31);
        indexDay = juli.length  % 7;

        String[] august = buildMonth(indexDay, 31);
        indexDay = august.length % 7;

        String[] september = buildMonth(indexDay, 30);
        indexDay = september.length % 7;

        String[] oktober = buildMonth(indexDay, 31);
        indexDay = oktober.length % 7 ;

        String[] november = buildMonth(indexDay, 30);
        indexDay = november.length  % 7;

        String[] dezember = buildMonth(indexDay, 31);


        printMonth(januar, "Januar");
        printMonth(februar, "Februar");
        printMonth(maerz, "März");
        printMonth(april, "April");
        printMonth(mai, "Mai");
        printMonth(juni, "Juni");
        printMonth(juli, "Juli");
        printMonth(august, "August");
        printMonth(september, "September");
        printMonth(oktober, "Oktober");
        printMonth(november, "November");
        printMonth(dezember, "Dezember");
    }
}