package com.service;

import com.dto.BookingDto;
import com.models.Bookings;
import com.models.Room;
import com.repository.BookingsRepository;
import com.repository.RoomRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class BookingsService {
    private BookingsRepository bookingsRepository;
    private RoomRepository roomRepository;

    public ResponseEntity<String> saveBooking(BookingDto bookingDto) {
        Room room =roomRepository.findById(bookingDto.getRoomId()).orElseThrow();
        List<Bookings> bookings1= bookingsRepository.findAllByBookingDateAndRoom(LocalDate.parse(bookingDto.getBookDate()),
                room);
        if(bookings1.size()<room.getWorkingPlace()){
            Bookings bookings=new Bookings();
            bookings.setBookingDate(LocalDate.parse(bookingDto.getBookDate()));
            bookings.setUserName(bookingDto.getUserName());
            bookings.setRoom(roomRepository.findById(bookingDto.getRoomId()).orElseThrow());
            bookingsRepository.save(bookings);
            return new ResponseEntity("Room booked",HttpStatus.OK);
        }else return new ResponseEntity<>("Can't book , no working place available",HttpStatus.OK);
    }
}
