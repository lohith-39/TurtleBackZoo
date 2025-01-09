package com.app.tbz.Service;

import com.app.tbz.DTO.EmployeeDTO;
import com.app.tbz.Entity.*;
import com.app.tbz.Exception.EmployeeNotFoundException;
import com.app.tbz.Exception.InsertCannotBeDoneException;
import com.app.tbz.Exception.UpdateCannotBeDoneException;
import com.app.tbz.Repository.ConcessionRepository;
import com.app.tbz.Repository.EmployeeRepository;
import com.app.tbz.Repository.HourlyRateRepository;
import com.app.tbz.Repository.ZooAdmissionRepository;
import com.app.tbz.Request.EmployeeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private HourlyRateRepository hourlyRateRepository;

    @Autowired
    private ConcessionRepository concessionRepository;

    @Autowired
    private ZooAdmissionRepository zooAdmissionRepository;

    @Override
    public EmployeeDTO createEmployee(EmployeeRequest request) throws InsertCannotBeDoneException {
        Employee employee = employeeRepository.save(toEmployeeEntity(request));
        return EmployeeDTO.builder()
                .e_id(employee.getEId())
                .startDate(employee.getStartDate())
                .jobType(employee.getJobType())
                .first(employee.getFirst())
                .minit(employee.getMinit())
                .last(employee.getLast())
                .street(employee.getStreet())
                .city(employee.getCity())
                .state(employee.getState())
                .zip(employee.getZip())
                .h_id(employee.getHId())
                .conc_id(employee.getConcId())
                .za_id(employee.getZaId()).build();
    }

    private Employee toEmployeeEntity(EmployeeRequest request) {
        return Employee.builder()
                .startDate(request.getStartDate())
                .jobType(request.getJobType())
                .first(request.getFirst())
                .minit(request.getMinit())
                .last(request.getLast())
                .street(request.getStreet())
                .city(request.getCity())
                .state(request.getState())
                .zip(request.getZip())
                .hId(request.getH_id())
                .concId(request.getConc_id())
                .zaId(request.getZa_id())
                .build();
    }

    @Override
    public EmployeeDTO getEmployee(Integer e_id) throws EmployeeNotFoundException {
        Optional<Employee> optional = employeeRepository.findById(e_id);
        if(optional.isEmpty()){
            throw new EmployeeNotFoundException("Employee Not Found");
        }
        return EmployeeDTO.builder()
                .e_id(optional.get().getEId())
                .startDate(optional.get().getStartDate())
                .jobType(optional.get().getJobType())
                .first(optional.get().getFirst())
                .minit(optional.get().getMinit())
                .last(optional.get().getLast())
                .street(optional.get().getStreet())
                .city(optional.get().getCity())
                .state(optional.get().getState())
                .zip(optional.get().getZip())
                .h_id(optional.get().getHId())
                .conc_id(optional.get().getConcId())
                .za_id(optional.get().getZaId())
                .build();
    }

    @Override
    public EmployeeDTO updateEmployee(Integer e_id, EmployeeRequest request) throws EmployeeNotFoundException, UpdateCannotBeDoneException {
        Optional<Employee> existingEmployee= employeeRepository.findById(e_id);
        if(existingEmployee.isEmpty()){
            throw new EmployeeNotFoundException("Employee Not Found");
        }
        if(request.getStartDate() != null) {
            existingEmployee.get().setStartDate(request.getStartDate());
        }
        if(request.getJobType() != null) {
            existingEmployee.get().setJobType(request.getJobType());
        }
        if(request.getFirst() != null) {
            existingEmployee.get().setFirst(request.getFirst());
        }
        if(request.getMinit() != null) {
            existingEmployee.get().setMinit(request.getMinit());
        }
        if(request.getLast() != null) {
            existingEmployee.get().setLast(request.getLast());
        }
        if(request.getStreet() != null) {
            existingEmployee.get().setStreet(request.getStreet());
        }
        if(request.getCity() != null) {
            existingEmployee.get().setCity(request.getCity());
        }
        if(request.getState() != null) {
            existingEmployee.get().setState(request.getState());
        }
        if(request.getZip() != null) {
            existingEmployee.get().setZip(request.getZip());
        }
        if(request.getH_id() != null) {
            Optional<HourlyRate> hourlyRate = hourlyRateRepository.findById(request.getH_id());
            if(hourlyRate.isEmpty()){
                throw new UpdateCannotBeDoneException("Hourly Rate ID Not Present in the Species Table");
            }
            existingEmployee.get().setHId(request.getH_id());
        }
        if(request.getConc_id() != null) {
            Optional<Concession> concession = concessionRepository.findById(request.getConc_id());
            if(concession.isEmpty()){
                throw new UpdateCannotBeDoneException("Concession ID Not Present in the Species Table");
            }
            existingEmployee.get().setConcId(request.getConc_id());
        }
        if(request.getZa_id() != null) {
            Optional<ZooAdmission> zooAdmission = zooAdmissionRepository.findById(request.getZa_id());
            if(zooAdmission.isEmpty()){
                throw new UpdateCannotBeDoneException("Zoo Admission ID Not Present in the Species Table");
            }
            existingEmployee.get().setZaId(request.getZa_id());
        }

        Employee employee = employeeRepository.save(existingEmployee.get());

        return EmployeeDTO.builder()
                .e_id(employee.getEId())
                .startDate(employee.getStartDate())
                .jobType(employee.getJobType())
                .first(employee.getFirst())
                .minit(employee.getMinit())
                .last(employee.getLast())
                .street(employee.getStreet())
                .city(employee.getCity())
                .state(employee.getState())
                .zip(employee.getZip())
                .h_id(employee.getHId())
                .conc_id(employee.getConcId())
                .za_id(employee.getZaId()).build();
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
}
