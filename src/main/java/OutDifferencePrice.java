public class OutDifferencePrice {
    public OutDifferencePrice(DifferencePrice differencePrice) {
        out(differencePrice);
    }

    public static void out(DifferencePrice differencePrice) {
        System.out.println("Разницу между средней ценой  и медианой");
        System.out.println(differencePrice.difference);

    }
}
