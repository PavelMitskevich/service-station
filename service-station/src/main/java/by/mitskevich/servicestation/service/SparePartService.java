package by.mitskevich.servicestation.service;

import by.mitskevich.servicestation.repository.SparePartPriceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SparePartService {

    private final SparePartPriceRepository repository;
}
