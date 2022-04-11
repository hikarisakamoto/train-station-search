package com.sakamoto.trainstationsearch.repositories;

import com.sakamoto.trainstationsearch.repositories.interfaces.ITrainStationRepository;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class TrainStationRepository implements ITrainStationRepository {

    @Override
    public List<String> fetch() {
        return List.of("Avanca",
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
    }
}
