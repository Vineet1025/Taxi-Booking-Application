package com.vineet.Taxi.Booking.Application.dao;

import com.vineet.Taxi.Booking.Application.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepo extends JpaRepository<Admin, Integer> {
   Optional<Admin> findByUsername(String username);
}
