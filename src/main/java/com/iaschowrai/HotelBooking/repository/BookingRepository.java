package com.iaschowrai.HotelBooking.repository;

import com.iaschowrai.HotelBooking.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    List<Booking> findByRoomId (long  roomId);

    List<Booking> findByBookingConfirmationCode(String confirmationCode);

    List<Booking> findByBookingUserId(long userid);

}
