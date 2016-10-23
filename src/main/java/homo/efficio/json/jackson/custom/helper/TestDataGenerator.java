package homo.efficio.json.jackson.custom.helper;

import homo.efficio.json.jackson.custom.domain.CellPhone;
import homo.efficio.json.jackson.custom.domain.FamilyMember;
import homo.efficio.json.jackson.custom.domain.MobileVendor;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by hanmomhanda on 2016-10-23.
 */
public class TestDataGenerator {

    public static FamilyMember getFamilyMember() {

        FamilyMember 손녀딸1 = new FamilyMember(
                31L, "손녀딸", null, null
        );
        FamilyMember 손자2 = new FamilyMember(
                32L, "손자2", null, null
        );

        Set<FamilyMember> childrens1 = new LinkedHashSet<>();
        childrens1.add(손녀딸1);
        childrens1.add(손자2);
        FamilyMember 아들1 = new FamilyMember(
                21L, "아들1", new CellPhone("01087879898", MobileVendor.KT), childrens1
        );
        FamilyMember 며느리1 = new FamilyMember(
                22L, "며느리1", new CellPhone("01082825353", MobileVendor.SKT), childrens1
        );

        Set<FamilyMember> childrens = new LinkedHashSet<>();
        childrens.add(아들1);
        childrens.add(며느리1);
        return new FamilyMember(
                21L, "천하대장군", new CellPhone("01056561253", MobileVendor.LGT), childrens
        );
    }
}
