package nl.chibb.publisher;

import com.google.gson.Gson;
import nl.chibb.model.SensorData;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Random;



/**
 * Created by djones on 3/7/17.
 */

@Component
public class LivingRoomTempSensor {

    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Autowired
    private MqttClient mqttClient;

    /**
     * Generate random data for testing.
     * @throws MqttException
     */
    @Scheduled(fixedDelay = 8000)
    public void sendLivingRoomData() throws MqttException {
        try {

            Random random = new Random();
            LocalDateTime localDateTime = LocalDateTime.now();

            int MaxTempValue = 20;
            int MinTempValue = 10;

            SensorData sensorData = new SensorData("Living Room", random.nextDouble() + Math.random() * ( MaxTempValue - MinTempValue ), localDateTime);
            Gson gson = new Gson();
            String jsonFormat = gson.toJson(sensorData);

            mqttClient.publish(
                    "topic", // topic
                    jsonFormat.getBytes(StandardCharsets.UTF_8),
                    2, // QoS
                    false);

            log.info("My time is now {}", dateFormat.format(new Date()));


        } catch (MqttException e) {
            e.printStackTrace();
            log.info(e.getMessage());
        }
    }
}
