package com.vineet.Taxi.Booking.Application.service;

import com.vineet.Taxi.Booking.Application.model.ContactForm;

import java.util.List;

public interface ContactFormService {
    public ContactForm saveContactFormService(ContactForm contactForm);

    public List<ContactForm> readAllContactService();

    public void deleteContactService(int id);



}
