package com.iaschowrai.HotelBooking.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.iaschowrai.HotelBooking.entity.Booking;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO {

    private String id;
    private String email;
    private String name;
    private String phoneNumber;
    private String role;
    private List<Booking> bookings = new ArrayList<>();


}
