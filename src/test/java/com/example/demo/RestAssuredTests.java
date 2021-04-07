package com.example.demo;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import static org.hamcrest.Matchers.is;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class RestAssuredTests {

	@LocalServerPort
	private int port;

	@Test
	void tryPingEndpoint() {
		RestAssured
				.given()
				.header("Accept", "*/*")
				.when()
				.get("http:localhost:" + port + "/ping")
				.then()
				.statusCode(200)
				.body(is("pong"));
	}
}
