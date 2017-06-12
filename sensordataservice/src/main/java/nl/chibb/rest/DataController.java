package nl.chibb.rest;

import nl.chibb.model.SensorData;
import nl.chibb.repository.SensorDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by dewijones on 22-5-2017.
 */

@RestController
public class DataController {

    @Autowired
    private SensorDataRepository sensorDataRepository;

    /**
     *
     * @param name of the value in de database
     * @return All names in the list with the specific name value
     */
    @CrossOrigin
    @RequestMapping(value = "/data/{name}", method = RequestMethod.GET)
    public List<SensorData> getAllDataList(@PathVariable String name) {
        return sensorDataRepository.getAllByName(name);
    }
}
