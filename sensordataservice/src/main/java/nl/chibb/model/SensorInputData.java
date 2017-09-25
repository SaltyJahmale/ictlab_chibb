package nl.chibb.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Created by djones on 9/25/17.
 */
@Data
@NoArgsConstructor
public class SensorInputData {

    private SensorDataType sensorDataType;
    private SensorMeasurementType sensoreMeasurement;
    private double inputData;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonSerialize
    @JsonDeserialize
    private LocalDateTime localDateTime;
}
