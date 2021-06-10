package model.application;

import java.util.List;

import javax.swing.JOptionPane;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("=== TEST 1: department findById ====");
		Department department = departmentDao.findById(3);
		System.out.println(department);

		System.out.println("\n=== TEST 2: department findAll ====");
		List<Department> list = departmentDao.findAll();
		for (Department obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n=== TEST 3: department insert ====");
		Department newDepartment = new Department(null, "Music");
		departmentDao.insert(newDepartment);
		System.out.println("Inserted! New Id = " + newDepartment.getId());

		
		System.out.println("\n=== TEST 4: department update ====");
		department = departmentDao.findById(10);
		department.setName("Music");
		departmentDao.update(department);
		System.out.println("Updated Completed");
		
		System.out.println("\n=== TEST 5: department delete ====");
		int id = Integer.parseInt(JOptionPane.showInputDialog("Enter id for delete test:"));
		departmentDao.deleteById(id);
		System.out.println("Delete completed");
	}
}
