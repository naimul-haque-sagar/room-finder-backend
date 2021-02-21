package com.controller;
import com.dto.BookingDto;
import com.service.BookingsService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @DeleteMapping("{bookingId}")
    public ResponseEntity<String> deleteBooking(@PathVariable String bookingId){
        bookingsService.deleteById(bookingId);
        return new ResponseEntity<>("Booking deleted", HttpStatus.OK);
    }

    @GetMapping("{percentageDate}")
    public ResponseEntity<Double> getPercentageOfEmptyRooms(@PathVariable("percentageDate") String date){
        return ResponseEntity.status(HttpStatus.OK).body(bookingsService.getPercentage(date));
    }
}
