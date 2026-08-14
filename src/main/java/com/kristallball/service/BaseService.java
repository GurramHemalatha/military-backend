package com.kristallball.service;

import com.kristallball.entity.Base;
import com.kristallball.repository.BaseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BaseService {

    private final BaseRepository baseRepository;

    public BaseService(BaseRepository baseRepository) {
        this.baseRepository = baseRepository;
    }

    public List<Base> getAllBases() {
        return baseRepository.findAll();
    }

    public Base saveBase(Base base) {
        return baseRepository.save(base);
    }

    public void deleteBase(Long id) {
        baseRepository.deleteById(id);
    }
}