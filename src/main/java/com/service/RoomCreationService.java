package com.service;

import com.dto.RoomCreateDto;
import com.models.Room;
import com.repository.BookingsRepository;
import com.repository.RoomRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Service
@AllArgsConstructor
public class RoomCreationService {
    private RoomRepository roomRepository;
    private BookingsRepository bookingsRepository;

    @Transactional
    public Room createRoom(RoomCreateDto roomCreateDto){
        Room room=new Room();
        room.setRoomName(roomCreateDto.getRoomName());
        room.setWorkingPlace(roomCreateDto.getCapacity());
        return roomRepository.save(room);
    }

    public HttpStatus deleteRoom(String roomId) {
        bookingsRepository.deleteByRoom(roomRepository.findById(roomId));
        roomRepository.deleteById(roomId);
        return HttpStatus.OK;
    }

    public List<Room> getAll() {
        return roomRepository.findAll();
    }
}
