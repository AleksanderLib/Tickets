public class OutMinFly {
    public OutMinFly(MinFly minFly) {
        out(minFly);
    }

    public static void out(MinFly minFly) {
        StringBuilder result = new StringBuilder();
        for (String carrier : minFly.minFlightTimeByCarrier.keySet()) {
            result.append(carrier).append(": ").append(minFly.minFlightTimeByCarrier.get(carrier)).append(" часов\n");
        }
        System.out.println(result);
    }

}

