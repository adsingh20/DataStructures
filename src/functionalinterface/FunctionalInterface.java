package functionalinterface;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FunctionalInterface {

    public static void main(String args[]) {

        List<User> users = new ArrayList<>();
        User user;
        for (int i = 0; i < 5 ; i++) {
            user = new User("Aman".concat(String.valueOf(i)),new Random().nextInt(2) == 1);
            users.add(user);
        }

        System.out.println(users);

        ConsumerExample(users);
        System.out.println(users);

        SupplierExample();

        Stream<BigInteger> incomeAfterTax = FunctionExample(users);
        System.out.println(Arrays.toString(incomeAfterTax.toArray()));

        PredicateExample(users);
        System.out.println(users);

    }

    static void PredicateExample(List<User> users ) {

        users.removeIf(new Predicate<User>() {
            @Override
            public boolean test(User user) {
                return !user.getActive();
            }
        });

        users.removeIf(user1 -> {
            return !user1.getActive();
        });
        users.removeIf(user2 -> !user2.getActive());
    }

    // Consumer takes an input, performs action and no output is returned
    static void ConsumerExample(List<User> users ) {
        users.stream().forEach(FunctionalInterface::calculateTax);
    }

    //Function Takes T as input, performs action and returns R as output
    static Stream<BigInteger> FunctionExample(List<User> users) {
        return users.stream().map(FunctionalInterface::calculateIncomeAfterTax);
    }

    //Function no input, performs action and returns an output
    static IntStream SupplierExample() {
        return IntStream.generate(FunctionalInterface::getNextRandomNumber);
    }

    private static Integer getNextRandomNumber() {
        return new Random().nextInt(10000);
    }

    private static BigInteger calculateIncomeAfterTax(User user) {
        return user.getSalary().subtract(user.getTax().unscaledValue());
    }

    private static void calculateTax(User user) {
        BigDecimal tax = new BigDecimal(user.getSalary()
                .subtract(BigInteger.valueOf(2000))
                .divide(BigInteger.valueOf(20)));
        user.setTax(tax.compareTo(BigDecimal.ZERO) > 0 ? tax : BigDecimal.ZERO);
    }

    static boolean filterAnyMatchExample(UUID userId, List<User> users) {
        return users.stream().anyMatch(user -> user.getUserId().compareTo(userId) == 0);
    }


}
