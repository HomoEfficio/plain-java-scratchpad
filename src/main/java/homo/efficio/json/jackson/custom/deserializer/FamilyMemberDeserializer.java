package homo.efficio.json.jackson.custom.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import homo.efficio.json.jackson.custom.domain.CellPhone;
import homo.efficio.json.jackson.custom.domain.FamilyMember;

import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by hanmomhanda on 2016-10-22.
 */
public class FamilyMemberDeserializer extends JsonDeserializer<FamilyMember> {

    private final ObjectMapper objectMapper;

    public FamilyMemberDeserializer() {
        this.objectMapper = new ObjectMapper();
        SimpleModule simpleModule = new SimpleModule();
        simpleModule.addDeserializer(CellPhone.class, new CellPhoneDeserializer());
        this.objectMapper.registerModule(simpleModule);
    }

    @Override
    public FamilyMember deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {

        ObjectCodec objectCodec = p.getCodec();
        JsonNode jsonNode = objectCodec.readTree(p);

        final Long id = jsonNode.get("id").asLong();
        final String name = jsonNode.get("name").asText();
        final CellPhone cellPhone = objectMapper.convertValue(jsonNode.get("cellPhone"), CellPhone.class);
        final Set<FamilyMember> children = objectMapper.convertValue(jsonNode.get("children"), new TypeReference<LinkedHashSet<FamilyMember>>() {
        });

        return new FamilyMember(id, name, cellPhone, children);
    }
}
