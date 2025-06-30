package generated.com.fasterxml.jackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.deser.DefaultDeserializationContext;
import org.jacodb.approximation.annotation.Approximate;

import java.io.IOException;
import java.io.Reader;
import java.io.Serial;

@Approximate(ObjectReader.class)
public class ObjectReaderImpl extends ObjectReader {
    @Serial
    private static final long serialVersionUID = 1L;
    
    protected ObjectReaderImpl(ObjectMapper mapper, DeserializationConfig config) {
        super(mapper, config);
    }

    @SuppressWarnings("unchecked")
    public <T> T readValue(Reader src) throws IOException
    {
        return (T) _bindAndClose(_considerFilter(createParser(src), false));
    }
    
    protected Object _bindAndClose(JsonParser p0) throws IOException
    {
        try (JsonParser p = p0) {
            Object result;

            final DefaultDeserializationContext ctxt = createDeserializationContext(p);
            result = ctxt.readRootValue(p, _valueType, _findRootDeserializer(ctxt), _valueToUpdate);

            return result;
        }
    }
}
