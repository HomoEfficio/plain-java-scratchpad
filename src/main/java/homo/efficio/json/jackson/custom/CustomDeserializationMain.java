package homo.efficio.json.jackson.custom;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import homo.efficio.json.jackson.custom.deserializer.CellPhoneDeserializer;
import homo.efficio.json.jackson.custom.deserializer.FamilyMemberDeserializer;
import homo.efficio.json.jackson.custom.domain.CellPhone;
import homo.efficio.json.jackson.custom.domain.FamilyMember;
import homo.efficio.json.jackson.custom.helper.TestDataGenerator;

import java.io.IOException;

/**
 * Created by hanmomhanda on 2016-10-22.
 */
public class CustomDeserializationMain {

    public static void main(String[] args) throws IOException {

        ObjectMapper om = new ObjectMapper();
        FamilyMember 천하대장군 = TestDataGenerator.getFamilyMember();
        String json = om.writerWithDefaultPrettyPrinter().writeValueAsString(천하대장군);

        ObjectMapper objectMapper = getObjectMapper();
        FamilyMember deserializedFamilyMember = objectMapper.readValue(json, FamilyMember.class);

        System.out.println(천하대장군.equals(deserializedFamilyMember));
    }

    private static ObjectMapper getObjectMapper() {

        ObjectMapper objectMapper = new ObjectMapper();

        SimpleModule simpleModule = new SimpleModule();
        simpleModule.addDeserializer(CellPhone.class, new CellPhoneDeserializer());
        simpleModule.addDeserializer(FamilyMember.class, new FamilyMemberDeserializer());

        objectMapper.registerModule(simpleModule);

        return objectMapper;
    }


}
