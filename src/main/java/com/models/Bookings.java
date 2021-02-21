package com.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@Document
public class Bookings {
    @Id
    private String id;
    private LocalDate bookingDate;
    private String userName;
    @DBRef
    private Room room;
}
