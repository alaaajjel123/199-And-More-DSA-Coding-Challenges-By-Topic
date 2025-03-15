import java.util.List;

public class PowerSum {
    public static int powerSum(List<Object> array, int power) {
        int sum = 0;
        for (Object element : array) {
            if (element instanceof List) {
                sum += powerSum((List<Object>) element, power + 1);
            } else {
                sum += (int) element;
            }
        }
        return (int) Math.pow(sum, power);
    }

    public static void main(String[] args) {
        List<Object> array = List.of(1, List.of(2, 3), 4);
        System.out.println(powerSum(array, 1));
    }
}