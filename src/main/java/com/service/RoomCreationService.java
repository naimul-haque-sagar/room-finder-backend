package com.service;

import com.dto.RoomCreateDto;
import com.models.Room;
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

    @Transactional
    public Room createRoom(RoomCreateDto roomCreateDto){
        Room room=new Room();
        room.setRoomName(roomCreateDto.getRoomName());
        room.setWorkingPlace(roomCreateDto.getCapacity());
//        room.setBookingsList(Collections.emptyList());
        return roomRepository.save(room);
    }

    public HttpStatus deleteRoom(String roomId) {
        roomRepository.deleteById(roomId);
        return HttpStatus.OK;
    }

    public List<Room> getAll() {
        return roomRepository.findAll();
    }
}
