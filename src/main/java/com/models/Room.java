package com.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
public class Room {
    @Id
    private String id;
    private String roomName;
    private  int workingPlace;
//    private List<Bookings> bookingsList;
}
