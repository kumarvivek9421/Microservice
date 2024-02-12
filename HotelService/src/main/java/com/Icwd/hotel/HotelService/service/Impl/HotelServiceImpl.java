package com.Icwd.hotel.HotelService.service.Impl;

import com.Icwd.hotel.HotelService.entities.Hotel;
import com.Icwd.hotel.HotelService.exception.ResourceNotFoundException;
import com.Icwd.hotel.HotelService.repositories.HotelRepository;
import com.Icwd.hotel.HotelService.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService {
    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public Hotel createHotel(Hotel hotel) {
//        Generate uniqe userId
        String randomhotelId = UUID.randomUUID().toString();
        hotel.setId(randomhotelId);

        return hotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> getAllHotel() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel getSingleHotel(String id) {
        return hotelRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("hotel with given id not found !!"));
    }
}
