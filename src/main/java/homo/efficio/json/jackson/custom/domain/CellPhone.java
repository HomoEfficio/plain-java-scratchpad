package homo.efficio.json.jackson.custom.domain;

/**
 * Created by hanmomhanda on 2016-10-22.
 */
public class CellPhone {

    private String number;

    private MobileVendor vendor;

    public CellPhone() {
    }

    public CellPhone(String number, MobileVendor vendor) {
        this.number = number;
        this.vendor = vendor;
    }

    public String getNumber() {
        return number;
    }

    public MobileVendor getVendor() {
        return vendor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CellPhone cellPhone = (CellPhone) o;

        if (number != null ? !number.equals(cellPhone.number) : cellPhone.number != null) return false;
        return vendor == cellPhone.vendor;

    }

    @Override
    public int hashCode() {
        int result = number != null ? number.hashCode() : 0;
        result = 31 * result + (vendor != null ? vendor.hashCode() : 0);
        return result;
    }
}
