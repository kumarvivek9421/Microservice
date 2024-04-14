package com.lcwd.user.service.UserService.service.impl;

import ch.qos.logback.core.net.server.Client;
import com.lcwd.user.service.UserService.entities.Hotel;
import com.lcwd.user.service.UserService.entities.Rating;
import com.lcwd.user.service.UserService.entities.User;
import com.lcwd.user.service.UserService.exception.ResourceNotFoundException;
import com.lcwd.user.service.UserService.external.service.HotelService;
import com.lcwd.user.service.UserService.repositories.UserRepository;
import com.lcwd.user.service.UserService.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private HotelService hotelService;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    private RestTemplate restTemplate;

    private Logger logger= LoggerFactory.getLogger(UserServiceImpl.class);


    @Override
    public User saveUser(User user) {
//        Generate uniqe userId (randam userId)
        String randomUserId = UUID.randomUUID().toString();
        user.setUserId(randomUserId);

        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
//        implement RATING SERVICE Call Using Rest Template
//        ArrayList<Rating> forObject = restTemplate.getForObject("http://USER-SERVICE/api/ratings/users", ArrayList.class);
//        logger.info("{} ", forObject);
//        user.setRating(forObject);
        return userRepository.findAll();
    }

    @Override
    public User getSingleUser(String userId) {
//        Optional<User> user = userRepository.findById(userId);
//        return user.get();
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User with given id is not found on server !! " + userId));

//        fetch rating of the above user from RATING SERVICE
//        http://localhost:8082/api/ratings/users/070c9f61-ee75-46b3-bee2-a9d65e89229f

        Rating[] ratingsOfUser = restTemplate.getForObject("http://RATING-SERVICE/api/ratings/users/"+ user.getUserId(), Rating[].class);
        logger.info("{} ",ratingsOfUser);

        List<Rating> ratings= Arrays.stream(ratingsOfUser).collect(Collectors.toList());

        List<Rating> ratingList = ratings.stream().map(rating -> {
//           api call to hotel service to get the hotel
//           http://localhost:8081/api/hotel/b4ee1af1-e3e3-4c7b-b474-6df1d9a40fd2
//          ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTEL-SERVICE/api/hotel/"+ rating.getHotelId(), Hotel.class);
//          Hotel hotel = forEntity.getBody();

         // Using Feign Client to communicate two service each other
            Hotel hotel = hotelService.getHotel(rating.getHotelId());

//            logger.info("response status code: {} ",forEntity.getStatusCode());
//           set the hotel to rating
            rating.setHotel(hotel);
//           return the rating

            return rating;

        }).collect(Collectors.toList());

        user.setRatings(ratingList);

        return user;
    }

    @Override
    public void deleteById(String id) {
        userRepository.deleteById(id);
    }

    @Override
    public User updateUser(User user, String id) {
        return userRepository.save(user);
    }

}
