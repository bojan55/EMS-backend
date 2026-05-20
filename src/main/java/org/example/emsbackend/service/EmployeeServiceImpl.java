package org.example.emsbackend.service;

import lombok.AllArgsConstructor;
import org.example.emsbackend.dto.EmployeeDTO;
import org.example.emsbackend.entity.Employee;
import org.example.emsbackend.exception.ResourceNotFoundException;
import org.example.emsbackend.mapper.EmployeeMapper;
import org.example.emsbackend.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {

        Employee employee = EmployeeMapper.mapToEmployee(employeeDTO);
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDTO getEmployeeById(Long employeeId) {
       Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(()-> new ResourceNotFoundException("Employee is not exist with given id : " + employeeId));
        return EmployeeMapper.mapToEmployeeDto(employee);
    }
}
