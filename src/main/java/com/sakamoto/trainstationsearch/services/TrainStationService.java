package com.sakamoto.trainstationsearch.services;

import static java.util.stream.Collectors.toList;
import static org.apache.commons.lang3.StringUtils.isBlank;

import com.sakamoto.trainstationsearch.repositories.interfaces.ITrainStationRepository;
import com.sakamoto.trainstationsearch.services.interfaces.ITrainStationService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TrainStationService implements ITrainStationService {

    private final ITrainStationRepository repository;

    @Override
    public List<String> search(String name) {
        if (isBlank(name)) {
            return repository.fetch();
        }

        return filterStations(name);
    }

    private List<String> filterStations(String name) {
        var stations = repository.fetch();

        return stations.stream()
                .filter(station -> station.startsWith(name))
                .collect(toList());
    }
}
