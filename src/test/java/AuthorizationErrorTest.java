import static io.restassured.RestAssured.given;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import io.restassured.response.Response;

public class AuthorizationErrorTest {
    private static Response response;
    private static final Logger LOGGER = LogManager.getLogger(AuthorizationErrorTest.class);

    @Test
    public void wrongKeyTest() {
        try {
            response = given().get(Consts.URL + Consts.LIVE_ENDPOINT + "?access_key=lalala");
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
}
