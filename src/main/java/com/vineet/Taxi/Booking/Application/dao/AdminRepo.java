package com.vineet.Taxi.Booking.Application.dao;

import com.vineet.Taxi.Booking.Application.model.Admin;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface AdminRepo extends JpaRepository<Admin, Integer> {
   Optional<Admin> findByUsername(String username);
   @Modifying
   @Transactional
   @Query(value = "update admin set username=:newusername, password=:newpassword where username=:oldusername", nativeQuery = true)
   public int updateCredentials(
           @Param("newusername") String newusername,
           @Param("newpassword") String newpassword,
           @Param("oldusername") String oldusername
   );
}
