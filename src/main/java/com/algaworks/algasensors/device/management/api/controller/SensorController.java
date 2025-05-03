package com.algaworks.algasensors.device.management.api.controller;

import com.algaworks.algasensors.device.management.api.model.SensorId;
import com.algaworks.algasensors.device.management.api.model.SensorInput;
import com.algaworks.algasensors.device.management.common.IdGenerator;
import com.algaworks.algasensors.device.management.domain.model.Sensor;
import com.algaworks.algasensors.device.management.domain.repository.SensorRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sensors")
public class SensorController {

    final SensorRepository sensorRepository;

    public SensorController(SensorRepository sensorRepository) {
        this.sensorRepository = sensorRepository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Sensor create(@RequestBody SensorInput input) {

     var sensor = Sensor
             .builder()
             .id(new SensorId(IdGenerator.genarateTSID()))
             .name(input.getName())
             .ip(input.getIp())
             .location(input.getLocation())
             .protocol(input.getProtocol())
             .model(input.getModel())
             .enabled(false)
             .build();
     return sensorRepository.saveAndFlush(sensor);
    }
}
