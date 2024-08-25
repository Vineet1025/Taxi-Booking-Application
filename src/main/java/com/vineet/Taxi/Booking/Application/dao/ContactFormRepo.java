package com.vineet.Taxi.Booking.Application.dao;

import com.vineet.Taxi.Booking.Application.model.ContactForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactFormRepo extends JpaRepository<ContactForm, Integer> {

    @Override
    public List<ContactForm> findAll();

    @Override
    public void deleteById(Integer id);
}
