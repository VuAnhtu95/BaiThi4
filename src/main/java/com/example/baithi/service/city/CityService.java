package com.example.baithi.service.city;

import com.example.baithi.model.City;
import com.example.baithi.repository.ICityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CityService implements ICityService {

    @Autowired
    private ICityRepository iCityRepository;

    @Override
    public Iterable<City> findAll() {
        return iCityRepository.findAll();
    }

    @Override
    public City save(City city) {
        return iCityRepository.save(city);
    }

    @Override
    public Page<City> findAll(Pageable pageable) {
        return iCityRepository.findAll(pageable);
    }

    @Override
    public Optional<City> findById(Long id) {
        return iCityRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
        iCityRepository.deleteById(id);
    }

    @Override
    public Page<City> findAllByNameContaining(String name, Pageable pageable) {
        return null;
    }

    @Override
    public Page<City> findAllByCountry(Long countryid, Pageable pageable) {
        return null;
    }
}
