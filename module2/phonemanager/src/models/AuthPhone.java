package models;

public class AuthPhone extends Phone {
    private int guaranteeByYear;
    private String code;

    public AuthPhone(int id, String name, Double price, String manufacturer, int guaranteeByYear, String code) {
        super(id, name, price, manufacturer);
        this.guaranteeByYear = guaranteeByYear;
        this.code = code;
    }

    public int getGuaranteeByYear() {
        return guaranteeByYear;
    }

    public void setGuaranteeByYear(int guaranteeByYear) {
        this.guaranteeByYear = guaranteeByYear;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "AuthPhone{" + super.toString() +
                " guarantee='" + guaranteeByYear + '\'' +
                ", code='" + code + '\'' +
                '}';
    }

    public String toData(String delimiter) {
        return "AuthPhone:" + delimiter + super.toData(delimiter) + delimiter + guaranteeByYear + delimiter + code;
    }
}
