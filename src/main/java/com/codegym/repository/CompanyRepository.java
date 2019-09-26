package com.codegym.repository;

import com.codegym.model.Company;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CompanyRepository extends PagingAndSortingRepository<Company,Long> {
}
