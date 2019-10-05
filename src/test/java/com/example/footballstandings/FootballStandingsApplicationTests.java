package com.example.footballstandings;


//import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Ignore;
//import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.footballStandings.exception.InvalidInputException;
import com.example.footballStandings.service.FootballStandingService;

@SpringBootTest
class FootballApplicationTests {

	@Autowired
	private FootballStandingService footballService;

	/*@IgnoreTest
	void null_all_params() throws Exception {
		assertThrows(InvalidInputException.class, () -> {
			footballService.getStandingDetails(null, null, null);
		});
	}

	@Ignore
	void null_country_name() throws Exception {
		assertThrows(InvalidInputException.class, () -> {
			footballService.getStandingDetails(null, "test", "test");
		});
	}
*/


}
