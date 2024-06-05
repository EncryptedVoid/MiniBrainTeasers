import java.util.List;

public class java_find_sum_of_list_recursion {

    public static int sum(List<Integer> list) {
        return sum(list, 0);
    }

    private static int sum(List<Integer> list, int index) {
        if (index == list.size()) {
            return 0;
        } else {
            return list.get(index) + sum(list, index + 1);
        }
    }

    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, 5);
        System.out.println("Sum: " + sum(list));
    }

}
