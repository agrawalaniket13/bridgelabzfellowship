package com.day26;

public class Hotel {
    private String hotelName;
    private int rating;
    private int regularWeekDay;
    private int regularWeekEnd;

    public Hotel(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getRegularWeekDay() {
        return regularWeekDay;
    }

    public void setRegularWeekDay(int regularWeekDay) {
        this.regularWeekDay = regularWeekDay;
    }

    public int getRegularWeekEnd() {
        return regularWeekEnd;
    }

    public void setRegularWeekEnd(int regularWeekEnd) {
        this.regularWeekEnd = regularWeekEnd;
    }
}
