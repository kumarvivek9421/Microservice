package com.Icwd.hotel.HotelService.service;

import com.Icwd.hotel.HotelService.entities.Hotel;

import java.util.List;

public interface HotelService {

//    createHotel
    Hotel createHotel(Hotel hotel);


//    getAllHotel
    List<Hotel> getAllHotel();

//    getSingleHotel
    Hotel getSingleHotel(String id);
}
