package nl.chibb.publisher;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Created by djones on 3/7/17.
 */

@Component
public class PahoDemo {

    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 3000)
    public void doDemo() {
        try {
            MqttClient client = new MqttClient("tcp://0.0.0.0:1883", MqttClient.generateClientId(), new MemoryPersistence());

            client.connect();

            client.publish(
                    "topic", // topic
                    "6".getBytes(),
                    0, // QoS
                    false);
            log.info("The time is now {}", dateFormat.format(new Date()));


        } catch (MqttException e) {
            e.printStackTrace();
            log.info(e.getMessage());
        }
    }
}
