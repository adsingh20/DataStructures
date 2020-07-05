package functionalinterface;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Random;
import java.util.UUID;

public class User {
    private UUID userId;
    private String name;
    private Boolean active;
    private BigInteger salary;
    private BigDecimal tax;

    public User(String name, Boolean active) {
        this.userId = UUID.nameUUIDFromBytes(name.concat(active.toString()).getBytes());
        this.name = name;
        this.active = active;
        this.salary = BigInteger.valueOf(new Random().nextInt(10000));
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public BigInteger getSalary() {
        return salary;
    }

    public void setSalary(BigInteger salary) {
        this.salary = salary;
    }

    public BigDecimal getTax() {
        return tax;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", active=" + active +
                ", salary=" + salary +
                ", tax=" + tax +
                '}';
    }
}
