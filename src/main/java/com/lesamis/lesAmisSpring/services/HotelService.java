package com.lesamis.lesAmisSpring.services;

import com.lesamis.lesAmisSpring.models.HotelModel;
import com.lesamis.lesAmisSpring.models.VueloModel;
import com.lesamis.lesAmisSpring.repositories.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HotelService {

    @Autowired
    HotelRepository hotelRepository;


    public List<HotelModel> obtenerHoteles(){
        return hotelRepository.findAll();
    }

//    public ArrayList<HotelModel> obtenerHoteles(){
//        return (ArrayList<HotelModel>) hotelRepository.findAll();
//    }

    public Optional<HotelModel> obtenerHotelPorId(Long id){
        return hotelRepository.findById(id);
    }

    public Optional<HotelModel> obtenerPorNombre(String nombre){
        return hotelRepository.findByNombre(nombre);
    }

    public void agregarHotel(HotelModel hotel){
        hotelRepository.save(hotel);
    }

    public void delete(Long id){
        hotelRepository.deleteById(id);
    }

    public boolean existsById(Long id){
        return hotelRepository.existsById(id);
    }

    public boolean existsByNombre(String nombre){
        return hotelRepository.existsByNombre(nombre);
    }

//    public Optional<HotelModel> obtenerHotelPorId(Long id){
//        return hotelRepository.findById(id);
//    }


//    public boolean eliminarHotel(Long id) {
//        try{
//            hotelRepository.deleteById(id);
//            return true;
//        }catch(Exception err){
//            return false;
//        }
//    }
}
