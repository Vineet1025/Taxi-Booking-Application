package com.vineet.Taxi.Booking.Application.dao;

import com.vineet.Taxi.Booking.Application.model.ServiceForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceFormRepo extends JpaRepository<ServiceForm, Integer> {
}
