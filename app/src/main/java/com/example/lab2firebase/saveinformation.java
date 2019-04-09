package com.example.lab2firebase;

public class saveinformation {
   public String Weekday;
   public String hourfrom,hourto,hourfrom1,hourto1;
   public saveinformation(){

   }

    public saveinformation(String weekday, String hourfrom, String hourto, String hourfrom1, String hourto1) {
        Weekday = weekday;
        this.hourfrom = hourfrom;
        this.hourto = hourto;
        this.hourfrom1 = hourfrom1;
        this.hourto1 = hourto1;
    }
}
