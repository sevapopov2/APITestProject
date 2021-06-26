import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import io.restassured.response.Response;

public class LiveEndpointTest {
    private static Response response;
    private static final Logger LOGGER = LogManager.getLogger(LiveEndpointTest.class);

    @BeforeAll
    public static void setup() {
        try {
            response = given().get(Consts.URL + Consts.LIVE_ENDPOINT + Consts.TOKEN);
            System.out.println(response.asString());
            LOGGER.info("Printing the info: " + response.asString());
            response.then().statusCode(200);
            LOGGER.info(response.then().statusCode(200));
        }
        catch (Exception err) {
            System.out.println("You have not supplied a valid API Access Key.");
            response.then().statusCode(101);
        }
    }

    @Test
    public void turmsTest() {
        response.then().body("terms", notNullValue());
    }

    @Test
    public void currencyReturnTest() {
        response = given().get(Consts.URL + Consts.LIVE_ENDPOINT + Consts.TOKEN + "&currencies=USDRUB");
        System.out.println(response.asString());
        LOGGER.info(response.asString());
    }

}
