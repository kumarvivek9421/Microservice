package com.lwcd.rating.controller;

import com.lwcd.rating.entities.Rating;
import com.lwcd.rating.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ratings")
public class RatingController {

    @Autowired
    private RatingService ratingService;

//    create Rating (URL= http://localhost:8082/api/ratings/create )
    @PostMapping("/create")
    public ResponseEntity<Rating> createRating(@RequestBody Rating rating){
        return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.createRating(rating));
    }

//    getAll Rating (URL= http://localhost:8082/api/ratings )
    @GetMapping
    public ResponseEntity<List<Rating>> getAllRating(){
        return ResponseEntity.ok(ratingService.getAllRating());
    }

//    getAll Rating By UserId (URL= http://localhost:8082/api/ratings/userId )
    @GetMapping("/{userId}")
    public ResponseEntity<List<Rating>> getAllRatingByUserId(String userId){
        return ResponseEntity.ok(ratingService.getRatingByUserId(userId));
    }

//    getAll Rating By HotelId (URL= http://localhost:8082/api/ratings/hotelId )
    @GetMapping("/{hotelId}")
    public ResponseEntity<List<Rating>> getAllRatingByHotelId(String hotelId){
        return ResponseEntity.ok(ratingService.getRatingByHotelId(hotelId));
    }

//    update Rating (URL= http://localhost:8082/api/ratings/ratingId )
    @PutMapping("/{ratingId}")
    public  ResponseEntity<Rating> updateRating(@RequestBody Rating rating, @PathVariable String ratingId){
        Rating updateRating = ratingService.updateRating(rating, ratingId);
        return new ResponseEntity<>(updateRating, HttpStatus.OK);
    }

//    delete Rating (URL= http://localhost:8082/api/ratings/ratingId )
    @DeleteMapping("/{ratingId}")
    public ResponseEntity<String> deleteRating(@PathVariable String ratingId){
        ratingService.deleteRating(ratingId);
        return new ResponseEntity<>("Rating is deleted", HttpStatus.OK);
    }

}
