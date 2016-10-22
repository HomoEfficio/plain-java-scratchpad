package homo.efficio.json.jackson.custom.serialization.domain;

/**
 * Created by hanmomhanda on 2016-10-22.
 */
public class CellPhone {

    private String number;

    private MobileVendor vendor;

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
}
