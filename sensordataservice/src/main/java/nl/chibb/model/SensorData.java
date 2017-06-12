package nl.chibb.model;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

/**
 * Created by dewijones on 9-5-2017.
 */

public class SensorData {

    @Id
    private String id;

    private String name;
    private double inputData;
    private LocalDateTime localDateTime;

    public SensorData(String name, double inputData, LocalDateTime localDateTime) {
        this.name = name;
        this.inputData = inputData;
        this.localDateTime = localDateTime;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getInputData() {
        return inputData;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    @Override
    public String toString() {
        return String.format("Customer[id=%s, firstName='%s', inputData='%2.2f']", id, name, inputData);
    }



}
