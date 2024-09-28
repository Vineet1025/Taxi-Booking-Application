package com.vineet.Taxi.Booking.Application.service;

import com.vineet.Taxi.Booking.Application.model.BookingForm;
import com.vineet.Taxi.Booking.Application.model.ContactForm;

import java.util.List;


public interface BookingFormService {
    public BookingForm saveBookingFormService(BookingForm bookingForm);
    public List<BookingForm> readAllBookingService();

    public void deleteBookingService(int id);
}
