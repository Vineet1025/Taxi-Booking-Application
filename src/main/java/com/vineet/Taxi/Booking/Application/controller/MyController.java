package com.vineet.Taxi.Booking.Application.controller;

import com.vineet.Taxi.Booking.Application.model.BookingForm;
import com.vineet.Taxi.Booking.Application.model.ContactForm;
import com.vineet.Taxi.Booking.Application.service.BookingFormService;
import com.vineet.Taxi.Booking.Application.service.ContactFormService;
import com.vineet.Taxi.Booking.Application.service.ContactFormServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MyController {

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

    @GetMapping(path = {"/", "home", "welcome", "index" })
     public String homepage(Model m){
        m.addAttribute("bookingForm", new  BookingForm());
        return "index";
     }
    @GetMapping("about")
    public String aboutpage(){
        return "about";
    }
    @GetMapping("cars")
    public String carspage(){
        return "cars";
    }
    @GetMapping("services")
    public String servicespage(){
        return "services";
    }
    @GetMapping("contacts")
    public String contactspage(Model m){
    m.addAttribute("contactForm", new ContactForm());
        return "contacts";
    }
    @PostMapping("contactform")
    public String contactform(@Valid @ModelAttribute ContactForm contactForm, BindingResult bindingResult, Model m, RedirectAttributes redirectAttributes){
     if(bindingResult.hasErrors()){
         m.addAttribute("bindingResult", bindingResult);
         return "contacts";
     }
    ContactForm saveContactFormService = contactFormService.saveContactFormService(contactForm);
     if (saveContactFormService!=null){
         redirectAttributes.addFlashAttribute("message", "Message sent successfully");
     }else {
         redirectAttributes.addFlashAttribute("message", "Something went wrong");
     }
        return "redirect:/contacts";
    }

    @PostMapping("bookingform")
    public String bookingform(@Valid @ModelAttribute BookingForm bookingForm, BindingResult bindingResult, Model m, RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors()){
            m.addAttribute("bindingResult", bindingResult);
            return "index";
        } else if (bookingForm.getAdult()+bookingForm.getChildren()>4) {
            m.addAttribute("message", "!! Total number of Adult and children cannot be more than 4 !!");
            return "index";
        }
         BookingForm saveBookingFormService = bookingFormService.saveBookingFormService(bookingForm);
        if (saveBookingFormService!=null){
            redirectAttributes.addFlashAttribute("message1", "Booking successfully");
        }else {
            redirectAttributes.addFlashAttribute("message1", "Something went wrong");
        }
//        System.out.println(bookingForm);
        return "redirect:/index";
    }
}
