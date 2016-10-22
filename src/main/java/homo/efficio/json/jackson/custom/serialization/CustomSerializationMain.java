package homo.efficio.json.jackson.custom.serialization;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import homo.efficio.json.jackson.custom.serialization.domain.CellPhone;
import homo.efficio.json.jackson.custom.serialization.domain.FamilyMember;
import homo.efficio.json.jackson.custom.serialization.domain.MobileVendor;
import homo.efficio.json.jackson.custom.serialization.serializer.CellPhoneSerializer;
import homo.efficio.json.jackson.custom.serialization.serializer.FamilyMemberSerializer;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by hanmomhanda on 2016-10-22.
 */
public class CustomSerializationMain {

    public static void main(String[] args) throws JsonProcessingException {

        ObjectMapper objectMapper = getObjectMapper();

        FamilyMember 천하대장군 = getFamilyMember();

        System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(천하대장군));
    }

    private static ObjectMapper getObjectMapper() {

        ObjectMapper objectMapper = new ObjectMapper();

        SimpleModule simpleModule = new SimpleModule();
        simpleModule.addSerializer(FamilyMember.class, new FamilyMemberSerializer());
        simpleModule.addSerializer(CellPhone.class, new CellPhoneSerializer());

        objectMapper.registerModule(simpleModule);

        return objectMapper;
    }

    private static FamilyMember getFamilyMember() {

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
