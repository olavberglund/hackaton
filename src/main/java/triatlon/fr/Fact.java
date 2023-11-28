package triatlon.fr;

import java.util.Objects;

public final class Fact {
    private final String name;
    private final String value;

    public Fact(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, value);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Fact fact = (Fact) obj;
        return Objects.equals(name, fact.name) && Objects.equals(value, fact.value);
    }

    @Override
    public String toString() {
        return "Fact{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
