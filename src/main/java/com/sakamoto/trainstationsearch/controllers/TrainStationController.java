package com.sakamoto.trainstationsearch.controllers;

import com.sakamoto.trainstationsearch.services.interfaces.ITrainStationService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("v1/train-stations")
public class TrainStationController {

    private final ITrainStationService service;

    @GetMapping
    public List<String> getStations(@RequestParam(name = "name") String name) {
        return service.search(name);
    }
}
