package rc.springbootmongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import rc.springbootmongodb.entity.Hotel;

import java.util.List;
import java.util.Optional;

@Repository
public interface HotelRepository extends MongoRepository<Hotel,String> {

    public Optional<Hotel> findById (String id);

    List<Hotel> findByPricePerNightIsLessThan(int maxPrice);

    @Query(value = "{'address.city':?0}")
    List<Hotel> findByCity(String city);

    @Query(value = "{'address.country':?0}")
    List<Hotel> findByCountry(String country);

    @Query(value = "{'reviews.rating':?0}")
    List<Hotel> findByReviewsRating(int rating);

    @Query(value = "{'reviews.rating':{$gt: 7}}")
    List<Hotel> findRecommended();
}
