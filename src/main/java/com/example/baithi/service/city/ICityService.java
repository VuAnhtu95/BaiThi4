package com.example.baithi.service.city;

import com.example.baithi.model.City;
import com.example.baithi.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICityService extends IGeneralService<City> {
    Page<City> findAllByNameContaining(String name, Pageable pageable);
    Page<City> findAllByCountry(Long countryid, Pageable pageable);
}
