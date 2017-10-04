package nl.chibb.model.node;

import lombok.Data;
import lombok.NoArgsConstructor;
import nl.chibb.model.sensor.SensorDataType;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by djones on 10/1/17.
 */

@Data
@NoArgsConstructor
@Entity
public class SensorNode implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String ip;
    private String topic;
    @Enumerated(EnumType.STRING)
    private SensorNodeStatus sensorNodeStatus = SensorNodeStatus.OK;
    @Enumerated(EnumType.STRING)
    private SensorDataType sensorDataType;
    @Enumerated(EnumType.STRING)
    private ConnectionStatus connectionStatus = ConnectionStatus.DISCONNECTED;

}
