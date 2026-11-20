import java.time.LocalDate;

public record Weirdo(String lastName, String firstName, LocalDate dob) {
    public Weirdo(String firstName, String lastName) {
        this(lastName, firstName, null);
    }

    public Weirdo {
        if(lastName == null || lastName.isBlank()) {
            throw new IllegalArgumentException("lastname required");
        }
    }

    public String sayHello() {
        return "Hello, world";
    }
}
