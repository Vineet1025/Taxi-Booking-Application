package com.vineet.Taxi.Booking.Application.Config.security;

import com.vineet.Taxi.Booking.Application.dao.AdminRepo;
import com.vineet.Taxi.Booking.Application.model.Admin;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private AdminRepo adminRepo;
    private PasswordEncoder passwordEncoder;
    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Autowired
    public void setAdminRepo(AdminRepo adminRepo) {
        this.adminRepo = adminRepo;
    }

    @PostConstruct
    public void init(){

        long count =adminRepo.count();
        if(count==0){
            Admin admin=new Admin();
            admin.setUsername("admin");
            admin.setPassword(passwordEncoder.encode("admin123"));
            adminRepo.save(admin);
        }

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Admin> byUsername = adminRepo.findByUsername(username);
        Admin admin =byUsername.orElseThrow(()-> new UsernameNotFoundException("!! Admin does not exist !!"));
        return User.withUsername(admin.getUsername()).password(admin.getPassword()).build();

    }
}
