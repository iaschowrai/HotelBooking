package com.iaschowrai.HotelBooking.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "rooms")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String bookingConfirmation;
    private String roomType;
    private String roomNumber;
    private BigDecimal roomPrice;
    private String roomPhotoURL;
    private String roomDescription;
    private List<Booking> bookings = new ArrayList<>();


    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", bookingConfirmation='" + bookingConfirmation + '\'' +
                ", roomType='" + roomType + '\'' +
                ", roomNumber='" + roomNumber + '\'' +
                ", roomPrice=" + roomPrice +
                ", roomPhotoURL='" + roomPhotoURL + '\'' +
                ", roomDescription='" + roomDescription + '\'' +
                ", bookings=" + bookings +
                '}';
    }
}
