package homo.efficio.json.jackson.custom.serialization.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import homo.efficio.json.jackson.custom.serialization.domain.CellPhone;

import java.io.IOException;

/**
 * Created by hanmomhanda on 2016-10-22.
 */
public class CellPhoneSerializer extends JsonSerializer<CellPhone> {

    @Override
    public void serialize(CellPhone value, JsonGenerator gen, SerializerProvider serializers) throws IOException, JsonProcessingException {

        gen.writeStartObject();

        gen.writeFieldName("phoneNumber");
        gen.writeString(value.getNumber());

        gen.writeEndObject();
    }
}
