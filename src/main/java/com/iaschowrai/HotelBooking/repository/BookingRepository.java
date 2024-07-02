package com.iaschowrai.HotelBooking.repository;

import com.iaschowrai.HotelBooking.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    List<Booking> findByRoomId (long  roomId);

    List<Booking> findByBookingConfirmationCode(String confirmationCode);

    List<Booking> findByUserId(long id);

}
