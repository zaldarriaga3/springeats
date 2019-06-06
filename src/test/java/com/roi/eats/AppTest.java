package com.roi.eats;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import com.roi.eats.domain.Category;
import com.roi.eats.domain.Dish;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * Unit test for simple App.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class AppTest {

    private final String BASE_URL = "eats/sumtin/v0/";

    @Test
    public void addMenuItem(){
        Dish newMenuItem = new Dish("Ice Tea", Category.LIQUID, "Cold Beverage", 0.50f, 4.99f);

        Dish returnedItem =
        given().contentType(MediaType.APPLICATION_JSON_VALUE) .body(newMenuItem)
                .when().post("eats/sumtin/v0/menu")
                .then()
                .statusCode(HttpStatus.CREATED.value())
                .extract().as(Dish.class);
        assertNotEquals(newMenuItem.getId(), returnedItem.getId());
    }


}
