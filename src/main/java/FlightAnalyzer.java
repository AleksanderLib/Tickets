public class FlightAnalyzer {

    public static void main(String[] args) {
        MinFly fj = new MinFly();
        System.out.println("Минимальное время полета между городами Владивосток и Тель-Авив:");
        System.out.println(fj.toString());
        System.out.println("Разницу между средней ценой  и медианой");
        differenceFly df = new differenceFly();
        System.out.println(df.toString());
    }
}
