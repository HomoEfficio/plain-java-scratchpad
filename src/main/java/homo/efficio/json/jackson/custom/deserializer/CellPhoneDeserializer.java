package homo.efficio.json.jackson.custom.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import homo.efficio.json.jackson.custom.domain.CellPhone;
import homo.efficio.json.jackson.custom.domain.MobileVendor;

import java.io.IOException;

/**
 * Created by hanmomhanda on 2016-10-23.
 */
public class CellPhoneDeserializer extends JsonDeserializer<CellPhone> {

    private final ObjectMapper objectMapper;

    public CellPhoneDeserializer() {
        this.objectMapper = new ObjectMapper();
    }

    @Override
    public CellPhone deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {

        ObjectCodec objectCodec = p.getCodec();
        JsonNode jsonNode = objectCodec.readTree(p);

        final String number = jsonNode.get("number").asText();
        final MobileVendor vendor = objectMapper.convertValue(jsonNode.get("vendor"), MobileVendor.class);

        return new CellPhone(number, vendor);
    }
}
