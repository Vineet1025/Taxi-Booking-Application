package com.vineet.Taxi.Booking.Application.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "contactform")
public class ContactForm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Name cannot be empty")
    @Size(min = 3, max= 30, message = "Invalid Name")
    @Column(length = 30)
    private String name;

    @NotEmpty(message = "Email cannot be empty")
    @Size(min = 5, max= 50, message = "Invalid Email")
    @Column(length = 50)
    private String email;

    @NotNull(message = "Phone cannot be empty")
    @Min(value = 1000000000, message = "Invalid")
    @Max(value = 9999999999L, message = "Invalid")
    @Column(length = 10)
    private Long phone;

    @Column(length = 500)
    private String message;
}
