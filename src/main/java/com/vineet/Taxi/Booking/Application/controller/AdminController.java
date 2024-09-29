package com.vineet.Taxi.Booking.Application.controller;

import com.vineet.Taxi.Booking.Application.model.BookingForm;
import com.vineet.Taxi.Booking.Application.model.ContactForm;
import com.vineet.Taxi.Booking.Application.model.ServiceForm;
import com.vineet.Taxi.Booking.Application.service.AdminCredentialsService;
import com.vineet.Taxi.Booking.Application.service.BookingFormService;
import com.vineet.Taxi.Booking.Application.service.ContactFormService;
import com.vineet.Taxi.Booking.Application.service.ServiceFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("admin")
public class AdminController {

    private ServiceFormService serviceFormService;
    @Autowired
    public void setServiceFormService(ServiceFormService serviceFormService) {
        this.serviceFormService = serviceFormService;
    }

    private AdminCredentialsService adminCredentialsService;
    @Autowired
    public void setAdminCredentialsService(AdminCredentialsService adminCredentialsService) {
        this.adminCredentialsService = adminCredentialsService;
    }

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


    @GetMapping(path={"admin", "dashboard"})
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


    @GetMapping("readallbookings")
    public String readAllBookings(Model model){
        List<BookingForm> allBookingService= bookingFormService.readAllBookingService();
        model.addAttribute("allbookings", allBookingService);
        return "admin/readallbookings";
    }

    @GetMapping("deleteBooking/{id}")
    public String deleteBooking(@PathVariable int id, RedirectAttributes redirectAttributes){
        bookingFormService.deleteBookingService(id);
        redirectAttributes.addFlashAttribute("message", "BOOKING DELETED SUCCESSFULLY");
        return "redirect:/admin/readallbookings";
    }


    @GetMapping("changecredentials")
    public String changeCredentialspage(){
        return "admin/changecredentials";
    }

    @PostMapping("changecredentials")
    public String changeCredentials(
            @RequestParam("oldusername") String oldusername,
            @RequestParam("oldpassword") String oldpassword,
            @RequestParam("newusername") String newusername,
            @RequestParam("newpassword") String newpassword,
            RedirectAttributes redirectAttributes
            ){
        String result = adminCredentialsService.checkAdminCredentials(oldusername, oldpassword);
        if(result.equals("SUCCESS")){
            result=adminCredentialsService.updateAdminCredentials(newusername, newpassword, oldusername);

                redirectAttributes.addFlashAttribute("message", result);
        }else {
            redirectAttributes.addFlashAttribute("message", result);
        }
        return "redirect:/admin/dashboard";
    }


    @GetMapping("addservice")
    public String addServicepage(){
        return "admin/addservice";
    }

    @InitBinder
    public void stopBinding(WebDataBinder webDataBinder) {
        webDataBinder.setDisallowedFields("image");
    }

    @PostMapping("addservice")
    public String addService(@ModelAttribute ServiceForm serviceForm ,
                             @RequestParam("image") MultipartFile multipartFile, RedirectAttributes redirectAttributes  ) {

        String originalFilename = multipartFile.getOriginalFilename();
        serviceForm.setImage(originalFilename);

        try {

            ServiceForm service = serviceFormService.addService(serviceForm, multipartFile);
            if(service!=null) {
                redirectAttributes.addFlashAttribute("msg","Service Added Successfully");
            }else {
                redirectAttributes.addFlashAttribute("msg","Something went wrong");
            }

        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("msg","Something went wrong");
        }


        return "redirect:/admin/addservice";
    }

}
