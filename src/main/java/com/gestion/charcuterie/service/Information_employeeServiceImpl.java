package com.gestion.charcuterie.service;

import com.gestion.charcuterie.model.*;
import com.gestion.charcuterie.repository.*;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Information_employeeServiceImpl implements Information_employeeService {

    @Autowired
    private Information_employeeRepository repo;


    @Autowired
    private RoleService roleService ; 

    
    @Autowired
    private EmployeeService employeeService ; 

       
    @Autowired
    private CandidatureService cs1 ; 

  


    public List<Information_employee> getAll() {
        return repo.findAll();
    }


    public void CandidateToEmployee( Candidature candidature ) { 
        Utilisateur ux = candidature.getUtilisateur() ;
        Detail_candidature dc =  cs1.getDetail( candidature.getId() );
        Annonce annonce  = candidature.getAnnonce() ; 
        Employee emp = new Employee() ;
        emp.setUsername(ux.getUsername()) ; 
        emp.setPassword(ux.getPassword());
        emp.setDepartement(annonce.getDepartement());
        emp.setRole(roleService.getById(4));
        employeeService.save(emp) ;
        
        Information_employee infoEmp = new Information_employee() ; 
        infoEmp.setEmployee(emp) ;
        infoEmp.setAddress(null);
        infoEmp.setCin(dc.getCin()) ; 
        infoEmp.setCv(dc.getCv()) ; 
        infoEmp.setDate_creation(LocalDateTime.now()) ; 
        infoEmp.setEmail(null) ; 
        infoEmp.setResidence(dc.getAddress())  ; 
        infoEmp.setContrat(annonce.getType_contrat()) ; 
        infoEmp.setFiliere( dc.getFiliere()) ; 
        infoEmp.setNiveau(dc.getNiveau());
        repo.save(infoEmp);
            
    }

    public Information_employee getById(Integer id) {
        return repo.findById(id).orElse(null);
    }

    public void save(Information_employee obj) {
        repo.save(obj);
    }

    public void delete(Integer id) {
        repo.deleteById(id);
    }

}