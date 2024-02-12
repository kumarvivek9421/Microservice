package com.lwcd.rating.repositories;

import com.lwcd.rating.entities.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RatingRepository extends JpaRepository<Rating, String> {

//    custom finder methods
    List<Rating> findRatingByUserId(String userId);
    List<Rating>findRatingByHotelId(String hotelId);

}
