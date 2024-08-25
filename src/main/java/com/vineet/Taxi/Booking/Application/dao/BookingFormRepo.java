package com.vineet.Taxi.Booking.Application.dao;

import com.vineet.Taxi.Booking.Application.model.BookingForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingFormRepo extends JpaRepository<BookingForm, Integer> {

}
