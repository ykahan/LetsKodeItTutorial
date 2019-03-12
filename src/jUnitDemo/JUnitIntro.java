package jUnitDemo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class JUnitIntro {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("Executed before the class");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		System.out.println("Executed after the class");
	}

	@BeforeEach
	void setUp() throws Exception {
		System.out.println("*************************");
	}

	@AfterEach
	void tearDown() throws Exception {
		System.out.println("-------------------------");
	}

	@Test
	void test1() {
		System.out.println("test1 executed");
	}

	@Test
	void test2() {
		System.out.println("test2 executed");
	}

}
