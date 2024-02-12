package com.Icwd.hotel.HotelService.controller;

import com.Icwd.hotel.HotelService.entities.Hotel;
import com.Icwd.hotel.HotelService.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hotel")
public class HotelController {

    @Autowired
    private HotelService hotelService;

//    createHotel (URL= http://localhost:8081/api/hotel/create)
    @PostMapping("/create")
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){

        return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.createHotel(hotel));
    }

//    getSingleHotel (URL= http://localhost:8081/api/hotel/1)
    @GetMapping("/{id}")
    public ResponseEntity<Hotel> getSingleHotel(@PathVariable("id") String hotelId){

    return ResponseEntity.status(HttpStatus.OK).body(hotelService.getSingleHotel(hotelId));
}

//    getAllHotel (URL= http://localhost:8081/api/hotel)
    @GetMapping
    public ResponseEntity<List<Hotel>> getAllHotel(){
        return ResponseEntity.ok(hotelService.getAllHotel());
    }


}
