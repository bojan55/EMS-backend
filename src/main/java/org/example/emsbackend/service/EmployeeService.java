package org.example.emsbackend.service;

import org.example.emsbackend.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeService {

    EmployeeDTO createEmployee(EmployeeDTO employeeDTO);
    EmployeeDTO getEmployeeById(Long employeeId);
    List<EmployeeDTO> getAllEmployees();
}
