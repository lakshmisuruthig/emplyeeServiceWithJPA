package com.practise.employeeService.service;

import ch.qos.logback.classic.spi.IThrowableProxy;
import com.practise.employeeService.dao.EmployeeRepository;
import com.practise.employeeService.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository repository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository repository){
        this.repository=repository;
    }
    @Override
    public List<Employee> findAll() {
        return repository.findAll();
    }

    @Override
    public Employee findById(int id) {
        Optional<Employee> result = repository.findById(id);
        return result.orElseThrow(() -> new RuntimeException("Did not Find Employee of  "+ id));
    }

    @Override
    @Transactional
    public Employee save(Employee emp) {
        return repository.save(emp);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        repository.deleteById(id);
    }
}
