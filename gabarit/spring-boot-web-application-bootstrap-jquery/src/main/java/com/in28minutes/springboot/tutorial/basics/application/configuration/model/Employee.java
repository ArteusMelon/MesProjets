package com.in28minutes.springboot.tutorial.basics.application.configuration.model;
 
import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
 
@Entity
@Table(name = "\"Employee\"")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_generator")
    @SequenceGenerator(name = "employee_generator", sequenceName = "employee_seq", allocationSize = 1)
    @Column(name="\"EmployeeId\"")
    private Long employeeId;
    @Column(name="\"LastName\"")
 
    private String lastName;
    @Column(name="\"FirstName\"")
 
    private String firstName;
    @Column(name="\"Title\"")
 
    private String title;
    @Column(name="\"ReportsTo\"",nullable = true)
 
    private Integer reportsTo;
    @Column(name="\"BirthDate\"")
 
    private Date birthDate;
    @Column(name="\"HireDate\"")
 
    private Date hireDate;
    @Column(name="\"Address\"")
 
    private String address;
    @Column(name="\"City\"")
 
    private String city;
    @Column(name="\"State\"")
 
    private String state;
    @Column(name="\"Country\"")
 
    private String country;
    @Column(name="\"PostalCode\"")
 
    private String postalCode;
    @Column(name="\"Phone\"")
 
    private String phone;
    @Column(name="\"Fax\"")
 
    private String fax;
    @Column(name="\"Email\"")
 
    private String email;
 
 
    public Employee
() {
        super();
    }
 
 
    public Employee
(String lastName, String firstName, String title, Integer reportsTo,
            Date birthDate, Date hireDate, String address, String city, String state, String country,
            String postalCode, String phone, String fax, String email) {
       
        this.lastName = lastName;
        this.firstName = firstName;
        this.title = title;
        this.reportsTo = reportsTo;
        this.birthDate = birthDate;
        this.hireDate = hireDate;
        this.address = address;
        this.city = city;
        this.state = state;
        this.country = country;
        this.postalCode = postalCode;
        this.phone = phone;
        this.fax = fax;
        this.email = email;
    }
 
 
    public Long getEmployeeId
() {
        return employeeId;
    }
 
 
    public void setEmployeeId
(Long employeeId) {
        this.employeeId = employeeId;
    }
 
 
    public String getLastName
() {
        return lastName;
    }
 
 
    public void setLastName
(String lastName) {
        this.lastName = lastName;
    }
 
 
    public String getFirstName
() {
        return firstName;
    }
 
 
    public void setFirstName
(String firstName) {
        this.firstName = firstName;
    }
 
 
    public String getTitle
() {
        return title;
    }
 
 
    public void setTitle
(String title) {
        this.title = title;
    }
 
 
    public Integer getReportsTo
() {
        return reportsTo;
    }
 
 
    public void setReportsTo
(Integer reportsTo) {
        this.reportsTo = reportsTo;
    }
 
 
    public Date getBirthDate
() {
        return birthDate;
    }
 
 
    public void setBirthDate
(Date birthDate) {
        this.birthDate = birthDate;
    }
 
 
    public Date getHireDate
() {
        return hireDate;
    }
 
 
    public void setHireDate
(Date hireDate) {
        this.hireDate = hireDate;
    }
 
 
    public String getAddress
() {
        return address;
    }
 
 
    public void setAddress
(String address) {
        this.address = address;
    }
 
 
    public String getCity
() {
        return city;
    }
 
 
    public void setCity
(String city) {
        this.city = city;
    }
 
 
    public String getState
() {
        return state;
    }
 
 
    public void setState
(String state) {
        this.state = state;
    }
 
 
    public String getCountry
() {
        return country;
    }
 
 
    public void setCountry
(String country) {
        this.country = country;
    }
 
 
    public String getPostalCode
() {
        return postalCode;
    }
 
 
    public void setPostalCode
(String postalCode) {
        this.postalCode = postalCode;
    }
 
 
    public String getPhone
() {
        return phone;
    }
 
 
    public void setPhone
(String phone) {
        this.phone = phone;
    }
 
 
    public String getFax
() {
        return fax;
    }
 
 
    public void setFax
(String fax) {
        this.fax = fax;
    }
 
 
    public String getEmail
() {
        return email;
    }
 
 
    public void setEmail
(String email) {
        this.email = email;
    }
 
 
    @Override
 
    public String toString
() {
        return "Employee [EmployeeId=" + employeeId + ", lastName=" + lastName + ", firstName=" + firstName + ", title="
 
                + title + ", reportsTo=" + reportsTo + ", birthDate=" + birthDate + ", hireDate=" + hireDate
                + ", Address=" + address + ", city=" + city + ", state=" + state + ", country=" + country
                + ", postalCode=" + postalCode + ", phone=" + phone + ", fax=" + fax + ", email=" + email + "]";
    }
 
 
   
}