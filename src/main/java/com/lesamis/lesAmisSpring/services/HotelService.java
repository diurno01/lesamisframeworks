package com.lesamis.lesAmisSpring.services;

import com.lesamis.lesAmisSpring.models.HotelModel;
import com.lesamis.lesAmisSpring.models.VueloModel;
import com.lesamis.lesAmisSpring.repositories.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class HotelService {

    @Autowired
    HotelRepository hotelRepository;


    public ArrayList<HotelModel> obtenerHoteles(){
        return (ArrayList<HotelModel>) hotelRepository.findAll();
    }

    public HotelModel agregarHotel(HotelModel hotel){
        return hotelRepository.save(hotel);
    }

    public Optional<HotelModel> obtenerHotelPorId(Long id){
        return hotelRepository.findById(id);
    }

    public boolean eliminarHotel(Long id) {
        try{
            hotelRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }
}
