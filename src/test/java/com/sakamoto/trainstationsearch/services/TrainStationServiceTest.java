package com.sakamoto.trainstationsearch.services;

import static org.assertj.core.api.BDDAssertions.then;
import static org.mockito.Mockito.when;

import com.sakamoto.trainstationsearch.repositories.interfaces.ITrainStationRepository;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class TrainStationServiceTest {

    @InjectMocks
    TrainStationService service;
    @Mock
    ITrainStationRepository repository;

    private final List<String> stations =List.of("Avanca",
            "Aveiro",
            "Aveleda",
            "Azambuja",
            "Baixa da Banheira",
            "Baraçal",
            "Barca da Amieira-Envendos",
            "Barcelos",
            "Barqueiros",
            "Barquinha",
            "Barragem de Belver",
            "Barreiro",
            "Barreiro-A",
            "Barrimau",
            "Barroselas",
            "Beja",
            "Belver-Gavião",
            "Belém",
            "Bemposta",
            "Bencanta",
            "Benfica",
            "Caldas da Rainha",
            "Caldas de Moledo");

    @Test
    void shouldReturnAllStationsWhenInputIsNull() {
        when(repository.fetch()).thenReturn(stations);

        final var actual = service.search(null);

        then(actual).isEqualTo(stations);
    }

    @Test
    void shouldReturnAllStationsWhenInputIsEmpty() {
        when(repository.fetch()).thenReturn(stations);

        final var actual = service.search("");

        then(actual).isEqualTo(stations);
    }

    @Test
    void shouldReturnAllStationsWithAWhenOnlyAFilled() {
        when(repository.fetch()).thenReturn(stations);

        final var actual = service.search("A");

        then(actual).containsExactly("Avanca",
                "Aveiro",
                "Aveleda",
                "Azambuja");
    }

    @Test
    void shouldReturnAllStationsWhichStartsWithSameLetters() {
        when(repository.fetch()).thenReturn(stations);

        final var actual = service.search("Ave");

        then(actual).containsExactly("Aveiro", "Aveleda");
    }

    @Test
    void shouldReturnAllStationsWhichContainsSpace() {
        when(repository.fetch()).thenReturn(stations);

        final var actual = service.search("Caldas ");

        then(actual).containsExactly("Caldas da Rainha",
                "Caldas de Moledo");
    }
}