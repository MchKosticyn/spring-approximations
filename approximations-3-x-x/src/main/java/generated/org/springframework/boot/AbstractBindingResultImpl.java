package generated.org.springframework.boot;

import org.jacodb.approximation.annotation.Approximate;

import java.util.Map;

import static org.springframework.validation.BindingResult.MODEL_KEY_PREFIX;

@Approximate(org.springframework.validation.AbstractBindingResult.class)
public abstract class AbstractBindingResultImpl {

    private final String objectName = null;

    public abstract Object getTarget();

    public String getObjectName() {
        return this.objectName;
    }

    public Map<String, Object> getModel() {
        ModelMapImpl model = new ModelMapImpl();
        // Mapping from name to target object.
        model.put(getObjectName(), getTarget());
        // Errors instance, even if no errors.
        String bindingResultKey = MODEL_KEY_PREFIX + getObjectName();
        model.put(bindingResultKey, this);
        model.lastKey = bindingResultKey;
        SpringUtils.internalLog("getModel, lastKey = ", bindingResultKey);
        return model;
    }
}
