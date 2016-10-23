package homo.efficio.json.jackson.custom.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import homo.efficio.json.jackson.custom.domain.CellPhone;

import java.io.IOException;

/**
 * Created by hanmomhanda on 2016-10-22.
 */
public class CellPhoneSerializer extends JsonSerializer<CellPhone> {

    @Override
    public void serialize(CellPhone value, JsonGenerator gen, SerializerProvider serializers) throws IOException, JsonProcessingException {

        gen.writeStartObject();

        gen.writeFieldName("phoneNumber");  // 원래 number 인 필드 이름을 phoneNumber로 변경
        gen.writeString(value.getNumber());

        // vendor를 serialize에서 제외
//        gen.writeFieldName("vendor");
//        gen.writeObject(value.getVendor());

        gen.writeEndObject();
    }
}
