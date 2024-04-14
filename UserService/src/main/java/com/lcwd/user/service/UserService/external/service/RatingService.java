package com.lcwd.user.service.UserService.external.service;

import com.lcwd.user.service.UserService.entities.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@Service
@FeignClient(name="RATING-SERVICE")
public interface RatingService {

//    Create Rating
    @PostMapping("api/ratings")
    public Rating createRating(Rating values);

//    Update Rating
    @PutMapping("api/ratings/{ratingId}")
    public Rating updateRating(@PathVariable("ratingId") String ratingId, Rating rating);

//    Get Single Rating
    @GetMapping("/api/ratings/{ratingId}")
    Rating getRating(@PathVariable("ratingId") String ratingId);

//    Get All Rating

//    Delete Rating
    @DeleteMapping("api/ratings/{ratingId}")
    public void deleteRating(@PathVariable String ratingId);
}
