package com.jobapp.service;

import com.jobapp.entity.Company;

import java.util.List;

public interface CompanyService {
    List<Company> getAllCompany();
    boolean updateCompany(Long id, Company company);
    void addCompany(Company company);
    boolean deleteComapany(Long id);
    Company getCompanyById(Long id);

}
