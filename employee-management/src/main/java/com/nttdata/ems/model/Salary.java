package com.nttdata.ems.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "salary")
public class Salary {

	@Id
	@Column(name = "payslip_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int payslipID;

	@Column(name = "emp_name")
	private String empName;

	@Column(name = "salary_amount")
	private double salaryAmount;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "employee_id")
	private Employee employee;

	public Salary() {

	}

	public Salary(int payslipID, String empName, double salaryAmount, Employee employee) {
		super();
		this.payslipID = payslipID;
		this.empName = empName;
		this.salaryAmount = salaryAmount;
		this.employee = employee;
	}

	public int getPayslipID() {
		return payslipID;
	}

	public void setPayslipID(int payslipID) {
		this.payslipID = payslipID;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public double getSalaryAmount() {
		return salaryAmount;
	}

	public void setSalaryAmount(double salaryAmount) {
		this.salaryAmount = salaryAmount;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "Salary [payslipID=" + payslipID + ", empName=" + empName + ", salaryAmount=" + salaryAmount
				+ ", employee=" + employee + "]";
	}

}
