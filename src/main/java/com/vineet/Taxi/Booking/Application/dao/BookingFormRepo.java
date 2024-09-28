package com.vineet.Taxi.Booking.Application.dao;

import com.vineet.Taxi.Booking.Application.model.BookingForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingFormRepo extends JpaRepository<BookingForm, Integer> {

    @Override
    public List<BookingForm> findAll();

    @Override
    public void deleteById(Integer id);

}
