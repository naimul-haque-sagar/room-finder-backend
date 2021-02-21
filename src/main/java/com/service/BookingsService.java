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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class BookingsService {
    private BookingsRepository bookingsRepository;
    private RoomRepository roomRepository;

    public ResponseEntity<String> saveBooking(BookingDto bookingDto) {
        Room room =roomRepository.findById(bookingDto.getRoomId()).orElseThrow();
        List<Bookings> bookings1= bookingsRepository.findAllByBookingDateAndRoom(LocalDate.parse(bookingDto.getBookDate()),
                room);
        System.out.println("all booking"+bookings1);
        if(bookings1.size()<room.getWorkingPlace()){
            Bookings bookings=new Bookings();
            bookings.setBookingDate(LocalDate.parse(bookingDto.getBookDate()));
            bookings.setUserName(bookingDto.getUserName());
            bookings.setRoom(roomRepository.findById(bookingDto.getRoomId()).orElseThrow());
            bookingsRepository.save(bookings);
            return new ResponseEntity("We booked successfully a place in " +
                    " ["+room.getRoomName()+"] on "+bookingDto.getBookDate()+" for you",HttpStatus.OK);
        }else return new ResponseEntity(sendMessage(bookings1,bookingDto.getBookDate()),HttpStatus.OK);
    }

    private String sendMessage(List<Bookings> bookings1,String bookingDate) {
        List<String> nameList = new ArrayList<>();
        bookings1.stream().forEach(s-> nameList.add(s.getUserName()));
        HashMap<String,Integer> hashMap= getAvailableRooms(bookingDate);
        List<String> list=new ArrayList<>();
        for(Map.Entry<String,Integer> m : hashMap.entrySet()){
            if(m.getValue() != 0){
                list.add(m.getKey()+" with open places"+m.getValue());
            }
        }
        return "Room is already booked out by "+nameList+" "+"on this day. Try room(s) "+list+" ";
    }

    private HashMap<String,Integer> getAvailableRooms(String bookingDate) {
        List<String> list=new ArrayList<>();
        List<Bookings> bookingsList= bookingsRepository.findAllByBookingDate(LocalDate.parse(bookingDate));
        HashMap<String,Integer> map=new HashMap();
        for(Bookings bookings:bookingsList){
            if(!map.containsKey(bookings.getRoom().getId())){
                int count=bookings.getRoom().getWorkingPlace();
                map.put(bookings.getRoom().getId(),--count);
            }else{
                int id= (int) map.get(bookings.getRoom().getId());
                map.put(bookings.getRoom().getId(),--id);
            }
        }
        return map;
    }

    public double getPercentage(String bookingDate){
        int totalRoom=0;
        HashMap<String,Integer> hashMap=new HashMap<>();
        List<Room> room= roomRepository.findAll();
        for(Room room1: room){
            totalRoom+=room1.getWorkingPlace();
            hashMap.put(room1.getId(),room1.getWorkingPlace());
        }

        List<Bookings> bookingsList= bookingsRepository.findAllByBookingDate(LocalDate.parse(bookingDate));
        for(Bookings bookings: bookingsList){
            if(hashMap.containsKey(bookings.getRoom().getId())){
               int id= hashMap.get(bookings.getRoom().getId());
               hashMap.put(bookings.getRoom().getId(),--id);
            }
        }
        Integer x=0;
        for(Map.Entry<String,Integer> m : hashMap.entrySet()){
            x = x+m.getValue();
        }
        double PD1 = (x * 100 / totalRoom);
        return PD1;
    }

    public void deleteById(String bookingId) {
        bookingsRepository.deleteById(bookingId);
    }

}
