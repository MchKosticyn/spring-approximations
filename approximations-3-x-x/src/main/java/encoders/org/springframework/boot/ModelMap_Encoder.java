package encoders.org.springframework.boot;

import generated.org.springframework.boot.ModelMapImpl;
import org.springframework.ui.ModelMap;
import org.springframework.util.CollectionUtils;
import org.usvm.api.encoder.EncoderFor;
import org.usvm.api.encoder.ObjectEncoder;

@SuppressWarnings("unused")
@EncoderFor(ModelMap.class)
public class ModelMap_Encoder implements ObjectEncoder {

    @Override
    public Object encode(Object object) {
        ModelMap model = (ModelMap) object;
        String lastKey = null;
        if (!model.isEmpty())
            lastKey = CollectionUtils.lastElement(model.keySet());

        return new ModelMapImpl(model, lastKey);
    }
}
