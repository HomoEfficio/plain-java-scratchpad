package homo.efficio.json.jackson.custom.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import homo.efficio.json.jackson.custom.domain.FamilyMember;

import java.io.IOException;

/**
 * Created by hanmomhanda on 2016-10-22.
 */
public class FamilyMemberSerializer extends JsonSerializer<FamilyMember> {

    @Override
    public void serialize(FamilyMember value, JsonGenerator gen, SerializerProvider serializers) throws IOException, JsonProcessingException {

        gen.writeStartObject();

        gen.writeFieldName("id");
        gen.writeString(String.valueOf(value.getId()));

        gen.writeFieldName("name");
        gen.writeString(value.getName());

        gen.writeFieldName("cellPhone");
        gen.writeObject(value.getCellPhone());  // 이게 결국 CellPhoneSerializer를 호출

        gen.writeFieldName("children");
        gen.writeObject(value.getChildren());

        gen.writeEndObject();
    }
}
