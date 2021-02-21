package com.controller;
import com.dto.BookingDto;
import com.service.BookingsService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/bookings")
@AllArgsConstructor
public class BookingsController {
    private BookingsService bookingsService;

    @PostMapping()
    public ResponseEntity<String> saveBookings(@Valid @RequestBody BookingDto bookingDto){
        return bookingsService.saveBooking(bookingDto);
    }
}
