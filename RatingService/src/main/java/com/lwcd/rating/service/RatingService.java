package com.lwcd.rating.service;

import com.lwcd.rating.entities.Rating;

import java.util.List;

public interface RatingService {

    //    create Rating
    Rating createRating(Rating rating);

    //    getAll Rating
    List<Rating> getAllRating();


    //    getAll Rating By UserId
    List<Rating> getRatingByUserId(String userId);

    //    getAll Rating By HotelId
    List<Rating> getRatingByHotelId(String hotelId);

    //    update Rating
    Rating updateRating(Rating rating, String ratingId);

    //    delelte Rating
    void deleteRating(String ratingId);


}
