package nl.chibb.subscriber;

import com.google.gson.Gson;
import nl.chibb.model.sensor.SensorData;
import nl.chibb.repository.SensorDataRepository;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;


/**
 * Created by dewijones on 9-5-2017.
 */

@Service
public class DataHandler implements MqttCallback, InitializingBean {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SensorDataRepository sensorDataRepository;


    @Autowired
    private MqttClient mqttClient;

    /**
     * set client to subscribe to the topic
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        mqttClient.setCallback(this);
        mqttClient.subscribe("topic");

    }

    @Override
    public void connectionLost(Throwable throwable) {

    }

    /**
     *
     * @param topic is for debug
     * @param message is for debug purpose
     * @throws Exception
     */
    @Override
    public void messageArrived(String topic, MqttMessage message) throws Exception {
        // Called when a message arrives from the server that matches any
        // subscription made by the client
        String time = new Timestamp(System.currentTimeMillis()).toString();
        System.out.println("Time:\t" +time + "  Topic:\t" + topic + "  Message:\t" + new String(message.getPayload()) + "  QoS:\t" + message.getQos());

        Gson gson = new Gson();

        SensorData data = gson.fromJson(new String(message.getPayload()), SensorData.class);

        sensorDataRepository.save(data);
//        sensorDataRepository.deleteAll();
    }


    @Override
    public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {

    }
}
