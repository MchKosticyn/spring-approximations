package generated.com.fasterxml.jackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import org.usvm.api.Engine;

import java.io.IOException;

public class StdScalarDeserializerImpl<T> {


    @SuppressWarnings("unchecked")
    public T deserialize(JsonParser p, DeserializationContext ctxt, T intoValue) throws IOException {
        Object newValue = Engine.makeSymbolic(intoValue.getClass());
        return (T)newValue;
    }
}
