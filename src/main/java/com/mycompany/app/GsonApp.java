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
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.ext.web.Router;




public class GsonApp {

	public static void main(String[] args) throws IOException {
		Employee emp = createEmployee();

		// Get Gson object
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		Path dot = Paths.get(".");
		// read JSON file data as String
		String fileData = new String(Files.readAllBytes(Paths.get("./employee.json")));

		// parse json string to object
		Employee emp1 = gson.fromJson(fileData, Employee.class);

		// print object data
		System.out.println("\n\nEmployee Object\n\n" + emp1);

		// create JSON String from Object
		String jsonEmp = gson.toJson(emp);
		System.out.print(jsonEmp);

		/***************************        Following part is the REST API ******************************/
		//// It is very similar to nodejs which you have coded before
		//// I choose Vert.x framework to build this REST API. It is a simple REST framework. 
		//// You can write Groovy on this framework and you can Groovy manual on their site. 

		System.out.println("\n\n REST API \n\n");

		System.out.println("Server is running on 127.0.0.1:8080 \n\n");

		System.out.println("\n\n You can access the API via browser with following URL: localhost:8080/employee \n\n");


		Vertx vertx = Vertx.vertx();
		HttpServer server = vertx.createHttpServer();

		Router router = Router.router(vertx);

		router.route("/employee").handler(routingContext -> {

			// This handler will be called for every request
			HttpServerResponse response = routingContext.response();
			response.setChunked(true);
			response.putHeader("content-type", "text/json");
			response.write(jsonEmp).end();
		
		});

		server.requestHandler(router::accept).listen(8080);

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