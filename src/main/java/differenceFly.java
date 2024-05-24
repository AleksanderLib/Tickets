import org.json.simple.JSONObject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
// Класс для разницы между средней ценой и медианой
public class differenceFly extends FlightJson {
    List<Integer> prices = new ArrayList<>();
    private int price;
    private double averagePrice;
    private double medianPrice;
    public differenceFly() {
        calculateDifference();
    }
    private void calculateDifference()
    {
        for (int i = 0; i < flights.size(); i++) {
            JSONObject flight = (JSONObject) flights.get(i);
            price = ((Long) flight.get("price")).intValue();
            prices.add(price);
        }

        averagePrice = prices.stream().mapToInt(Integer::intValue).average().orElse(0);
        Collections.sort(prices);
        if (prices.size() % 2 == 0) {
            medianPrice = (prices.get(prices.size() / 2 - 1) + prices.get(prices.size() / 2)) / 2.0;
        } else {
            medianPrice = prices.get(prices.size() / 2);
        }
    }

    public void outDifference() {
        System.out.println("Разница между средней ценой и медианой: " + (averagePrice - medianPrice));
    }
}
