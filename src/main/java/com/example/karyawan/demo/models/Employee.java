package com.example.karyawan.demo.models;

import javax.persistence.Entity;
import javax.persistence.*;

@Entity
@Table(name= "Employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "employee_nip", nullable = false)
    private String EmployeeNip;

    @Column(name = "employee_name", nullable = false)
    private String EmployeeName;

    @Column(name = "employee_dob", nullable = false)
    private String EmployeeDob;

    @Column(name = "employee_pob", nullable = false)
    private String EmployeePob;

    @Column(name = "employee_hp", nullable = false)
    private String EmployeeHp;

    @Column(name = "employee_email", nullable = false)
    private String EmployeeEmail;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmployeeNip() {
        return EmployeeNip;
    }

    public void setEmployeeNip(String employeeNip) {
        EmployeeNip = employeeNip;
    }

    public String getEmployeeName() {
        return EmployeeName;
    }

    public void setEmployeeName(String employeeName) {
        EmployeeName = employeeName;
    }

    public String getEmployeeDob() {
        return EmployeeDob;
    }

    public void setEmployeeDob(String employeeDob) {
        EmployeeDob = employeeDob;
    }

    public String getEmployeePob() {
        return EmployeePob;
    }

    public void setEmployeePob(String employeePob) {
        EmployeePob = employeePob;
    }

    public String getEmployeeHp() {
        return EmployeeHp;
    }

    public void setEmployeeHp(String employeeHp) {
        EmployeeHp = employeeHp;
    }

    public String getEmployeeEmail() {
        return EmployeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        EmployeeEmail = employeeEmail;
    }

    public String getEmployeeAgama() {
        return EmployeeAgama;
    }

    public void setEmployeeAgama(String employeeAgama) {
        EmployeeAgama = employeeAgama;
    }

    public long getSisaCuti() {
        return SisaCuti;
    }

    public void setSisaCuti(long sisaCuti) {
        SisaCuti = sisaCuti;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public long getPositionId() {
        return PositionId;
    }

    public void setPositionId(long positionId) {
        PositionId = positionId;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public long getRoleId() {
        return RoleId;
    }

    public void setRoleId(long roleId) {
        RoleId = roleId;
    }

    @Column(name = "employee_agama", nullable = false)
    private String EmployeeAgama;

    @Column(name = "sisa_cuti")
    private long SisaCuti = 12;

    @ManyToOne
    @JoinColumn(name = "position_id", insertable = false, updatable = false)
    public Position position;

    @Column(name = "position_id")
    private long PositionId;

    @ManyToOne
    @JoinColumn(name = "role_id", insertable = false, updatable = false)
    public Role role;

    @Column(name = "role_id")
    private long RoleId;




}
