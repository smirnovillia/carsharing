package com.itacademy.jd2.is.carsharing.web.converter;

import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.itacademy.jd2.is.carsharing.dao.api.entity.IBrand;
import com.itacademy.jd2.is.carsharing.service.IBrandService;
import com.itacademy.jd2.is.carsharing.web.dto.BrandDTO;

@Component
public class BrandFromDTOConverter implements Function<BrandDTO, IBrand>{
    @Autowired
    private IBrandService brandService;

    @Override
    public IBrand apply(final BrandDTO dto) {
        final IBrand entity = brandService.createEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        return entity;
    }
}
