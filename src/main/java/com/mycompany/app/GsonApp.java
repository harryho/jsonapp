package com.mycompany.app;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mycompany.gson.model.*;
// import com.journaldev.json.model.Employee;

public class GsonApp {

	public static void main(String[] args) throws IOException {
		Employee emp = createEmployee();

		// Get Gson object
		Gson gson =   new GsonBuilder().setPrettyPrinting().create();
	    Path dot =	Paths.get(".");
		// read JSON file data as String
		String fileData = new String(Files.readAllBytes(Paths.get("./employee.txt")));

		// parse json string to object
		Employee emp1 = gson.fromJson(fileData, Employee.class);

		// print object data
		System.out.println("\n\nEmployee Object\n\n" + emp1);

		// create JSON String from Object
		String jsonEmp = gson.toJson(emp);
		System.out.print(jsonEmp);

	}

	public static Employee createEmployee() {

		Employee emp = new Employee();
		emp.setId(1);
		emp.setName("James");
		emp.setPermanent(false);
		emp.setPhoneNumbers(new long[] { 123456, 987654 });
		emp.setRole("Manager");

		Address add = new Address();
		add.setCity("Bangalore");
		add.setStreet("200 High Street");
		add.setZipcode(8975);
		emp.setAddress(add);

		List<String> cities = new ArrayList<String>();
		cities.add("Sydney");
		cities.add("Brisbane");
		emp.setCities(cities);

		Map<String, String> props = new HashMap<String, String>();
		props.put("salary", "1000 Rs");
		props.put("age", "34 years");
		emp.setProperties(props);

		return emp;
	}
}