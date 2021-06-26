import static io.restassured.RestAssured.given;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import io.restassured.response.Response;

public class APIRunTest {
    private static Response response;
    private static final Logger LOGGER = LogManager.getLogger(APIRunTest.class);

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
    public void apiRunTest() {
        LOGGER.info(response.asString());
        response.then().statusCode(200);
        LOGGER.info(response.);
    }
}
