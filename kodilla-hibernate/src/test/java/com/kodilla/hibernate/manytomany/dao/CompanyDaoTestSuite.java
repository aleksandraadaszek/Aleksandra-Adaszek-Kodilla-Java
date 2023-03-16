package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
public class CompanyDaoTestSuite {

    @Autowired
    private CompanyDao companyDao;
    @Autowired
    private EmployeeDao employeeDao;


    @Test
    void testSaveManyToMany() {
        //Given
        Employee johnSmith = new Employee("John", "Smith");
        Employee stephanieClarkson = new Employee("Stephanie", "Clarkson");
        Employee lindaKovalsky = new Employee("Linda", "Kovalsky");

        Company softwareMachine = new Company("Software Machine");
        Company dataMasters = new Company("Data Masters");
        Company greyMatter = new Company("Grey Matter");

        softwareMachine.getEmployees().add(johnSmith);
        dataMasters.getEmployees().add(stephanieClarkson);
        dataMasters.getEmployees().add(lindaKovalsky);
        greyMatter.getEmployees().add(johnSmith);
        greyMatter.getEmployees().add(lindaKovalsky);

        johnSmith.getCompanies().add(softwareMachine);
        johnSmith.getCompanies().add(greyMatter);
        stephanieClarkson.getCompanies().add(dataMasters);
        lindaKovalsky.getCompanies().add(dataMasters);
        lindaKovalsky.getCompanies().add(greyMatter);

        //When
        companyDao.save(softwareMachine);
        int softwareMachineId = softwareMachine.getId();
        companyDao.save(dataMasters);
        int dataMastersId = dataMasters.getId();
        companyDao.save(greyMatter);
        int greyMatterId = greyMatter.getId();
        employeeDao.save(stephanieClarkson);
        int stephanieClarksonId = stephanieClarkson.getId();

        //Then
        assertNotEquals(0, softwareMachineId);
        assertNotEquals(0, dataMastersId);
        assertNotEquals(0, greyMatterId);
        assertNotEquals(0, stephanieClarksonId);

        //CleanUp
        try {
            companyDao.deleteById(softwareMachineId);
            companyDao.deleteById(dataMastersId);
            companyDao.deleteById(greyMatterId);
        } catch (Exception e) {
            System.out.println("The exception " + e + " has been caught.");
        }
    }

    @Test
    void testNamedQueries() {
        //Given
        Employee anitta = new Employee("Anitta", "Vascuzes");
        Employee brad = new Employee("Brad", "Johnson");
        Employee elizabeth = new Employee("Elizabeth", "Stringfield");
        Employee john = new Employee("John", "Stringfield");

        Company rockingScience = new Company("Rocking Science");
        Company codingMasters = new Company("Coding Masters");
        Company outstandingProgramming = new Company("Outstanding Programming");
        Company codeExcellence = new Company("Code Excellence");

        rockingScience.getEmployees().add(anitta);
        rockingScience.getEmployees().add(john);
        codingMasters.getEmployees().add(anitta);
        codingMasters.getEmployees().add(elizabeth);
        codingMasters.getEmployees().add(brad);
        outstandingProgramming.getEmployees().add(brad);
        codeExcellence.getEmployees().add(elizabeth);
        codeExcellence.getEmployees().add(john);

        anitta.getCompanies().add(rockingScience);
        anitta.getCompanies().add(codingMasters);
        brad.getCompanies().add(codingMasters);
        brad.getCompanies().add(outstandingProgramming);
        elizabeth.getCompanies().add(codingMasters);
        elizabeth.getCompanies().add(codeExcellence);
        john.getCompanies().add(rockingScience);
        john.getCompanies().add(codeExcellence);

        companyDao.save(rockingScience);
        int rockingScienceId = rockingScience.getId();
        companyDao.save(codingMasters);
        int codingMastersId = codingMasters.getId();
        companyDao.save(outstandingProgramming);
        int outstandingProgrammingId = outstandingProgramming.getId();
        companyDao.save(codeExcellence);
        int codeExcellenceId = codeExcellence.getId();

        employeeDao.save(anitta);
        int anittaId = anitta.getId();
        employeeDao.save(brad);
        int bradId = brad.getId();
        employeeDao.save(elizabeth);
        int elizabethId = elizabeth.getId();
        employeeDao.save(john);
        int johnId = john.getId();

        //When
        List<Company> companiesStartingWithSpecificCharacters = companyDao.retrieveFirstThreeSpecificLettersOfACompanyName("Cod");
        List<Employee> employeesWithASpecificLastname = employeeDao.retrieveEmployeesWithASpecificLastname("Stringfield");

        //Then
        assertEquals(2, companiesStartingWithSpecificCharacters.size());
        assertEquals(2, employeesWithASpecificLastname.size());
        try {
            //CleanUp
            deleteCompanies(rockingScienceId, codingMastersId, outstandingProgrammingId, codeExcellenceId);
            employeeDao.deleteById(anittaId);
            employeeDao.deleteById(bradId);
            employeeDao.deleteById(elizabethId);
            employeeDao.deleteById(johnId);
        } catch (Exception e) {
            System.out.println("The exception " + e + " has been caught.");
        }
    }

    private void deleteCompanies(int... ids) {
        for (int id : ids) {
            try {
                companyDao.deleteById(id);
            } catch (Exception e) {
                System.out.println("The exception" + e);
            }
        }
    }
}


