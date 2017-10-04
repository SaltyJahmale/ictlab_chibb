package nl.chibb.repository;

import nl.chibb.model.sensor.SensorData;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

/**
 * Created by dewijones on 9-5-2017.
 */
public interface SensorDataRepository extends MongoRepository<SensorData, String> {

    List<SensorData> getAllByName(String name);
//    List<SensorData> getAllBySensorId(String name);
}
