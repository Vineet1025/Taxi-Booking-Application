package com.vineet.Taxi.Booking.Application.service;

import com.vineet.Taxi.Booking.Application.dao.ContactFormRepo;
import com.vineet.Taxi.Booking.Application.model.ContactForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactFormServiceImpl implements ContactFormService{

    private ContactFormRepo contactFormRepo;
    @Autowired
    public void setContactFormRepo(ContactFormRepo contactFormRepo) {
        this.contactFormRepo = contactFormRepo;
    }

    @Override
    public ContactForm saveContactFormService(ContactForm contactForm) {
       return contactFormRepo.save(contactForm);

    }

    @Override
    public List<ContactForm> readAllContactService() {
        return contactFormRepo.findAll();
    }

    @Override
    public void deleteContactService(int id) {
        contactFormRepo.deleteById(id);
    }
}
