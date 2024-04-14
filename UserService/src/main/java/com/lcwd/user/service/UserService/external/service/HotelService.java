package com.lcwd.user.service.UserService.external.service;

import com.lcwd.user.service.UserService.entities.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "HOTEL-SERVICE")
public interface HotelService {

//    Create Hotel

//    Update Hotel

//    Get Single Hotel
    @GetMapping("/api/hotel/{hotelId}")
    Hotel getHotel(@PathVariable("hotelId") String hotelId);

//    Get All Hotel

//    Delete Hotel


}
