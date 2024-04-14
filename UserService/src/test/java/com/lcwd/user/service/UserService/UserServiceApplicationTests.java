package com.lcwd.user.service.UserService;

import com.lcwd.user.service.UserService.entities.Rating;
import com.lcwd.user.service.UserService.external.service.RatingService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest

class UserServiceApplicationTests {

	@Autowired
	private RatingService ratingService;

//	@Test
//	void createRating(){
//		Rating rating = Rating.builder().rating(10).userId(" ").hotelId(" ").feedback("this is crated by feign clint").build();
//		Rating savedRating = ratingService.createRating(rating);
//
//		System.out.println("new rating crated...");
//	}










	Calculater cal= new Calculater();
	@Test
	void contextLoads() {

	}
	@Test
	void testSum(){

		int expectedResult= 49;

		int actualResult= cal.sum(12, 15, 22);

		assertThat(actualResult).isEqualTo(expectedResult);
	}
	@Test
	@Disabled
	void testMulti(){
		int expectedResult= 50;

		int actualResult= cal.doMulti(5,10);

		assertThat(actualResult).isEqualTo(expectedResult);
	}
	@Test
	void testCompare(){
		Boolean expectedResult= true;

		Boolean actualResult= cal.camparission(15, 15);

//		assertThat(actualResult).isTrue();
		assertEquals(expectedResult, actualResult);
	}

}
