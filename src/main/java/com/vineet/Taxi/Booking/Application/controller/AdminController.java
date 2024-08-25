package com.vineet.Taxi.Booking.Application.controller;

import com.vineet.Taxi.Booking.Application.model.ContactForm;
import com.vineet.Taxi.Booking.Application.service.BookingFormService;
import com.vineet.Taxi.Booking.Application.service.ContactFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("admin")
public class AdminController {

    private ContactFormService contactFormService;
    @Autowired
    public void setContactFormService(ContactFormService contactFormService) {
        this.contactFormService = contactFormService;
    }
    private BookingFormService bookingFormService;
    @Autowired
    public void setBookingFormService(BookingFormService bookingFormService) {
        this.bookingFormService = bookingFormService;
    }


    @GetMapping("dashboard")
    public String adminpage(){
        return "admin/dashboard";
    }

    @GetMapping("readallcontacts")
    public String readAllContacts(Model model){
        model.addAttribute("allcontacts", contactFormService.readAllContactService());
        return "admin/readallcontacts";
    }

    @GetMapping("deleteContact/{id}")
    public String deleteContact(@PathVariable int id, RedirectAttributes redirectAttributes){
        contactFormService.deleteContactService(id);
        redirectAttributes.addFlashAttribute("message", "CONTACT DELETED SUCCESSFULLY");
       return "redirect:/admin/readallcontacts";
    }
}
