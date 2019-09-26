package com.codegym.service.impl;

import com.codegym.model.Company;
import com.codegym.repository.CompanyRepository;
import com.codegym.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class CompanySeviceImpl implements CompanyService {
    @Autowired
    private CompanyRepository companyRepository;
    @Override
    public Page<Company> findAll(Pageable pageable) {
        return companyRepository.findAll(pageable);
    }
}
