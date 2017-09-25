package nl.chibb.config;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by dewijones on 9-6-2017.
 */

@Configuration
public class MqttConfig {

    /**
     * One instance of mqttClient for every class to use.
     * @return sampleClient
     * @throws MqttException
     */
    @Bean
    public MqttClient mqttClient() throws MqttException {

        final String broker = "tcp://172.18.0.3:1883"   ;
        final String clientId = MqttClient.generateClientId();
        final MemoryPersistence persistence = new MemoryPersistence();
        final MqttClient sampleClient = new MqttClient(broker, clientId, persistence);
        final MqttConnectOptions connOpts = new MqttConnectOptions();
        connOpts.setCleanSession(true);
        sampleClient.connect(connOpts);

        return sampleClient;

    }
}
