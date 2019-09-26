package com.codegym.service;

import com.codegym.model.Company;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CompanyService {
    Page<Company> findAll(Pageable pageable);
}
