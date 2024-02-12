package com.lwcd.rating.service.Impl;

import com.lwcd.rating.entities.Rating;
import com.lwcd.rating.exception.ResourceNotFoundException;
import com.lwcd.rating.repositories.RatingRepository;
import com.lwcd.rating.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    private RatingRepository ratingRepository;


    public RatingServiceImpl(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    @Override
    public Rating createRating(Rating rating) {
    //      Generate uniqe userId
        String randomRatingId = UUID.randomUUID().toString();
        rating.setRatingId(randomRatingId);

        return ratingRepository.save(rating);
    }

    @Override
    public List<Rating> getAllRating() {
        return ratingRepository.findAll();
    }

    @Override
    public List<Rating> getRatingByUserId(String userId) {
        return ratingRepository.findRatingByUserId(userId);
    }

    public List<Rating> getRatingByHotelId(String hotelId){
        return ratingRepository.findRatingByHotelId(hotelId);
    }
    @Override
    public Rating updateRating(Rating rating, String ratingId) {
        return ratingRepository.save(rating);
    }

    @Override
    public void deleteRating(String ratignId) {
         ratingRepository.deleteById(ratignId);
    }
}
