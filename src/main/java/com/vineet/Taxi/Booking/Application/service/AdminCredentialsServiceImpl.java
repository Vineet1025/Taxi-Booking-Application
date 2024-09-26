package com.vineet.Taxi.Booking.Application.service;

import com.vineet.Taxi.Booking.Application.dao.AdminRepo;
import com.vineet.Taxi.Booking.Application.model.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class AdminCredentialsServiceImpl implements AdminCredentialsService {

    private AdminRepo adminRepo ;
    private PasswordEncoder passwordEncoder;
   @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Autowired
    public void setAdminRepo(AdminRepo adminRepo) {
        this.adminRepo = adminRepo;
    }

    @Override
    public String checkAdminCredentials(String oldusername, String oldpassword) {
        Optional<Admin> byUsername = adminRepo.findByUsername(oldusername);
        if(byUsername.isPresent()){
            Admin admin =byUsername.get();
            boolean matches= passwordEncoder.matches(oldpassword, admin.getPassword());
            if(matches){
                return "SUCCESS";
            }else{
                return "WORNG OLD CREDENTIALS";
            }
        }else {
            return "WORNG OLD CREDENTIALS";
        }
    }

    @Override
    public String updateAdminCredentials(String newusername, String newpassword, String oldusername) {
        int updateCredentials=adminRepo.updateCredentials(newusername, passwordEncoder.encode(newpassword), oldusername);
        if (updateCredentials==1){
            return "CREDENTIALS UPDATED SUCCESSFULLY!";
        }else{
            return "FAILED!";
        }


    }
}
