package com.example.baithi.service.country;

import com.example.baithi.model.Country;
import com.example.baithi.repository.ICountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CountryService implements ICountryService{

    @Autowired
    private ICountryRepository iCountryRepository;

    @Override
    public Iterable<Country> findAll() {
        return iCountryRepository.findAll();
    }

    @Override
    public Country save(Country country) {
        return null;
    }

    @Override
    public Page<Country> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Optional<Country> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public void remove(Long id) {

    }
}
