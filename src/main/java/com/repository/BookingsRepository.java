package com.repository;

import com.models.Bookings;
import com.models.Room;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface BookingsRepository extends MongoRepository<Bookings,String> {
    Bookings findByBookingDate(LocalDate parse);

    List<Bookings> findAllByBookingDate(LocalDate parse);

    List<Bookings> findAllByBookingDateAndRoom(LocalDate parse, Room room);

    void deleteByRoom(Optional<Room> byId);
}
