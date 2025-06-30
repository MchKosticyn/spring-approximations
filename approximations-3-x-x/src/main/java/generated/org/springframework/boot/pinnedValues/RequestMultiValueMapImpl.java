package generated.org.springframework.boot.pinnedValues;

import org.jacodb.approximation.annotation.Approximate;
import stub.RequestMultiValueMap;

@Approximate(RequestMultiValueMap.class)
public class RequestMultiValueMapImpl extends RequestMultiValueMap {
    private final PinnedValueSource source;

    public RequestMultiValueMapImpl(PinnedValueSource source) { this.source = source; }

    public String[] get(Object key) {
        return PinnedValueStorage.getPinnedValue(source, (String)key, String[].class);
    }
}
