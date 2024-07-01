package com.iaschowrai.HotelBooking.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.iaschowrai.HotelBooking.entity.Room;
import com.iaschowrai.HotelBooking.entity.User;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookingDTO {
    private long id;

    private LocalDateTime checkInDate;
    private LocalDateTime checkOutDate;

    private int numOfAdults;
    private int numOfChildren;
    private int totalNumOfGuest;

    private String bookingConfirmationCode;

    private UserDTO user;
    private RoomDTO room;

}
