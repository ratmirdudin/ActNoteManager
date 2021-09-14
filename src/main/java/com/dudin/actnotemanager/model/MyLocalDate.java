package com.dudin.actnotemanager.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class MyLocalDate {
    private final int year;
    private final int month;
    private final int day;

    public String getMyLocalDate(){
        return (this.day < 10 ? "0" + this.day : this.day) + "." + (this.month < 10 ? "0" + this.month : this.month) + "." + this.year;
    }

    public MyLocalDate() {
        LocalDate localDate = LocalDate.now();
        this.year = localDate.getYear();
        this.month = localDate.getMonthValue();
        this.day = localDate.getDayOfMonth();
    }
}
