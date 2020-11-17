package rc.springbootmongodb.controller;


import org.springframework.web.bind.annotation.*;
import rc.springbootmongodb.repository.HotelRepository;
import rc.springbootmongodb.entity.Hotel;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    private HotelRepository hotelRepository;

    public HotelController(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }
    @GetMapping("/all")
    public List<Hotel> getAll(){
        List<Hotel> hotels = this.hotelRepository.findAll();
        return hotels;
    }
    @PostMapping
    public void insert(@RequestBody Hotel hotel){
        this.hotelRepository.insert(hotel);
    }

    @PutMapping
    public void update(@RequestBody Hotel hotel){
        this.hotelRepository.save(hotel);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id){
        this.hotelRepository.deleteById(id);
    }

    @GetMapping("/{id}")
    public Optional<Hotel> getById(@PathVariable ("id") String id){

        Optional<Hotel> hotel = this.hotelRepository.findById(id);

        return hotel;

    }

    @GetMapping("/price/{maxPrice}")
    public List<Hotel> getByPricePerNight(@PathVariable("maxPrice") int maxPrice){
        List<Hotel> hotels = this.hotelRepository.findByPricePerNightIsLessThan(maxPrice);
        return  hotels;
    }

    @GetMapping("address/{city}")
    public List<Hotel> getByCity(@PathVariable("city") String city){
        List<Hotel> hotels = this.hotelRepository.findByCity(city);
        return hotels;
    }

    @GetMapping("country/{country}")
    public List<Hotel> getByCountry(@PathVariable("country") String country){
        List<Hotel> hotels = this.hotelRepository.findByCountry(country);
        return hotels;
    }

    @GetMapping("review/{rating}")
    public List<Hotel> getByReview(@PathVariable("rating") int rating){
        List<Hotel> hotels = this.hotelRepository.findByReviewsRating(rating);
        return hotels;
    }

    @GetMapping("recommended")
    public List<Hotel> getRecommended(){
        List<Hotel> hotels = this.hotelRepository.findRecommended();
        return hotels;
    }


}
