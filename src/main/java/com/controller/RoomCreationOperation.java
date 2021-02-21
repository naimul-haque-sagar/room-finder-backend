package com.controller;

import com.dto.RoomCreateDto;
import com.models.Room;
import com.service.RoomCreationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/room")
@AllArgsConstructor
public class RoomCreationOperation {
    private RoomCreationService roomCreationService;

    @PostMapping()
    public ResponseEntity<Room> create(@Valid @RequestBody RoomCreateDto roomCreateDto){
        return ResponseEntity.status(HttpStatus.OK).body(roomCreationService.createRoom(roomCreateDto));
    }

    @GetMapping()
    public ResponseEntity<List<Room>> getAllRoom(){
        return ResponseEntity.status(HttpStatus.OK).body(roomCreationService.getAll());
    }

    @DeleteMapping("/{roomId}")
    public ResponseEntity<HttpStatus> deleteRoom(@PathVariable String roomId){
        return ResponseEntity.status(HttpStatus.OK).body(roomCreationService.deleteRoom(roomId));
    }
}
