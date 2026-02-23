import java.util.Objects;

public class PatientRecord implements Comparable<PatientRecord> {
    private final String ssn;
    private int age;
    private String fullName;

    public PatientRecord(String ssn, int age, String fullName) {
        if (ssn == null || ssn.isBlank()) {
            throw new IllegalArgumentException("SSN cannot be null/blank");
        }
        this.ssn = ssn;
        this.age = age;
        this.fullName = fullName;
    }

    public String getSsn() {
        return ssn;
    }

    public int getAge() {
        return age;
    }

    public String getFullName() {
        return fullName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public int compareTo(PatientRecord other) {
        return digitsOnly(this.ssn).compareTo(digitsOnly(other.ssn));
    }

    private static String digitsOnly(String ssn) {
        return ssn.replaceAll("\\D", "");
    }

    @Override
    public String toString() {
        return "PatientRecord{ssn='" + ssn + "', age=" + age + ", fullName='" + fullName + "'}";
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof PatientRecord)) return false;
        PatientRecord that = (PatientRecord) o;
        return age == that.age
                && Objects.equals(ssn, that.ssn)
                && Objects.equals(fullName, that.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ssn, age, fullName);
    }
}