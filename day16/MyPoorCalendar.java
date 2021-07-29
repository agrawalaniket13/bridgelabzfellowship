package com.day16;

public class MyPoorCalendar {
    public static void main(String[] args) {
        int firstday = 1;
        int mycalendar[][] = new int[6][7];
        String nameOfTheWeeks = "Mon\t" + "Tue\t" + "Wed\t" + "Thu\t" + "Fri\t" + "Sat\t" + "Sun\t";
        System.out.println(nameOfTheWeeks);

        //initializing
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                mycalendar[i][j] = firstday++;
                if (firstday > 31) {
                    break;
                }
            }
        }
        //printing
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(mycalendar[i][j] + "\t");
                if (j == 6) {
                    System.out.println();
                }
            }
        }
    }
}
