package homo.efficio.json.jackson.custom;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import homo.efficio.json.jackson.custom.domain.CellPhone;
import homo.efficio.json.jackson.custom.domain.FamilyMember;
import homo.efficio.json.jackson.custom.helper.TestDataGenerator;
import homo.efficio.json.jackson.custom.serializer.CellPhoneSerializer;
import homo.efficio.json.jackson.custom.serializer.FamilyMemberSerializer;

/**
 * Created by hanmomhanda on 2016-10-22.
 */
public class CustomSerializationMain {

    public static void main(String[] args) throws JsonProcessingException {

        ObjectMapper objectMapper = getObjectMapper();

        FamilyMember 천하대장군 = TestDataGenerator.getFamilyMember();

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
}
