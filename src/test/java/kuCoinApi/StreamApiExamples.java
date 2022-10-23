package kuCoinApi;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StreamApiExamples {

    public List<TickerData> getTickers() {
        return given()
                .contentType(ContentType.JSON)
                .when()
                .get("https://api.kucoin.com" + "/api/v1/market/allTickers")
                .then()
                .extract().jsonPath().getList("data.ticker", TickerData.class);
    }

    @Test
    public void checkCrypto() {
        List<TickerData> usdTickers = getTickers().stream().filter(x -> x.getSymbol().endsWith("USDT")).toList();
        assertTrue(usdTickers.stream().allMatch(x -> x.getSymbol().endsWith("USDT")));
    }

    @Test
    public void sortHighToLow() {
        List<TickerData> highToLow = getTickers().stream().filter(x -> x.getSymbol().endsWith("USDT")).sorted((o1, o2) -> o2.getChangeRate().compareTo(o1.getChangeRate())).toList();
        List<TickerData> top10 = highToLow.stream().limit(10).toList();
        int t = 9;
    }

    @Test
    public void sortLowToHigh() {
        List<TickerData> lowToHigh = getTickers().stream().filter(x -> x.getSymbol().endsWith("USDT"))
                .sorted(new TickerComparatorLow()).limit(10).toList();
        int a = 0;
    }

    @Test
    public void changeMap(){
        Map<String, Float> usd = new HashMap<>();
        List<String> lowerCases = getTickers().stream().map(x -> x.getSymbol().toLowerCase()).toList();
//        getTickers().forEach(x-> usd.put(x.getSymbol(), Float.parseFloat(x.getChangeRate())));
        List<TickerShort> shortList = new ArrayList<>();
        getTickers().forEach(x->shortList.add(new TickerShort(x.getSymbol(), Float.parseFloat(x.getChangeRate()))));
        int a = 0;
    }
}
