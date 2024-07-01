package com.iaschowrai.HotelBooking.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.iaschowrai.HotelBooking.entity.Booking;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
class RoomDTO {

    private String roomType;
    private String roomNumber;
    private BigDecimal roomPrice;
    private String roomPhotoURL;
    private String roomDescription;
    private List<BookingDTO> bookings;

}
