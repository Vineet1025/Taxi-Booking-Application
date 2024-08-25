package com.vineet.Taxi.Booking.Application.service;

import com.vineet.Taxi.Booking.Application.dao.BookingFormRepo;
import com.vineet.Taxi.Booking.Application.model.BookingForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingFormServiceImpl implements BookingFormService {
    private BookingFormRepo bookingFormRepo;
    @Autowired
    public void setBookingFormRepo(BookingFormRepo bookingFormRepo) {
        this.bookingFormRepo = bookingFormRepo;
    }

    @Override
    public BookingForm saveBookingFormService(BookingForm bookingForm) {
        return bookingFormRepo.save(bookingForm);
    }
}
