package com.vineet.Taxi.Booking.Application.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "bookingform")
public class BookingForm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Name cannot be empty")
    @NotBlank(message = "Name cannot be blank")
    @Size(min = 3, max=30, message = "Invalid name")
    @Column(length = 30)
    private String name;

    @NotEmpty(message = "Source cannot be empty")
    @NotBlank(message = "Source cannot be blank")
    @Size(min = 3, max=100, message = "Invalid Source")
    @Column(length = 100, name = "source")
    private String from;

    @NotEmpty(message = "Email cannot be empty")
    @NotBlank(message = "Email cannot be blank")
    @Size(min = 7, max=50, message = "Invalid Email")
    @Column(length = 50)
    private String email;

    @NotEmpty(message = "Destination cannot be empty")
    @NotBlank(message = "Destination cannot be blank")
    @Size(min = 3, max=100, message = "Invalid Destination")
    @Column(length = 100, name = "destination")
    private String to;

    @NotNull(message = "Please Select Time")
    @Column
    private LocalTime time;

    @NotNull(message = "Please Select Date")
    @Column
    private LocalDate date;

    @NotEmpty(message = "Please Select Your Comfort")
    @Column
    private String comfort;

    @Min(value = 1)
    @Max(value = 3)
    @Column
    private int adult;

    @Max(value = 2)
    @Column
    private int children;

    @Column(length = 500)
    private String message;

}
