package generated.org.springframework.boot;

import generated.java.util.map.LinkedHashMapImpl;
import org.jacodb.approximation.annotation.Approximate;
import org.springframework.core.Conventions;
import org.springframework.lang.Nullable;
import org.springframework.ui.ModelMap;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;
import org.usvm.api.Engine;

import java.util.Collection;
import java.util.Map;

@SuppressWarnings("serial")
@Approximate(ModelMap.class)
public class ModelMapImpl extends LinkedHashMapImpl<String, Object> {

    public String lastKey = null;

    public ModelMapImpl() {
    }

    public ModelMapImpl(Map<String, Object> map, String lastKey) {
        super(map);
        this.lastKey = lastKey;
    }

    public ModelMapImpl addAttribute(String attributeName, @Nullable Object attributeValue) {
        Assert.notNull(attributeName, "Model attribute name must not be null");
        put(attributeName, attributeValue);
        lastKey = attributeName;
        SpringUtils._internalLog("addAttribute, lastKey = ", lastKey);
        return this;
    }

    public ModelMapImpl addAttribute(Object attributeValue) {
        Assert.notNull(attributeValue, "Model object must not be null");
        if (attributeValue instanceof Collection<?>) {
            Collection<?> collection = (Collection<?>) attributeValue;
            if (collection.isEmpty())
                return this;
        }
        return addAttribute(Conventions.getVariableName(attributeValue), attributeValue);
    }

    public ModelMapImpl addAllAttributes(@Nullable Collection<?> attributeValues) {
        if (attributeValues != null) {
            for (Object attributeValue : attributeValues) {
                addAttribute(attributeValue);
            }
            if (attributeValues instanceof ModelMapImpl) {
                lastKey = ((ModelMapImpl) attributeValues).lastKey;
            }
            SpringUtils._internalLog("addAllAttributes(Collection), lastKey = ", lastKey);
        }
        return this;
    }

    public ModelMapImpl addAllAttributes(@Nullable Map<String, ?> attributes) {
        if (attributes != null) {
            putAll(attributes);
            if (attributes instanceof ModelMapImpl) {
                lastKey = ((ModelMapImpl) attributes).lastKey;
            } else {
                lastKey = CollectionUtils.lastElement(attributes.keySet());
            }
            SpringUtils._internalLog("addAllAttributes(Map), lastKey = ", lastKey);
        }
        return this;
    }

    public ModelMapImpl mergeAttributes(@Nullable Map<String, ?> attributes) {
        if (attributes != null) {
            attributes.forEach((key, value) -> {
                if (!containsKey(key)) {
                    put(key, value);
                }
            });
            if (attributes instanceof ModelMapImpl) {
                lastKey = ((ModelMapImpl) attributes).lastKey;
            } else {
                lastKey = CollectionUtils.lastElement(attributes.keySet());
            }
            SpringUtils._internalLog("mergeAttributes, lastKey = ", lastKey);
        }
        return this;
    }

    @SuppressWarnings("EqualsDoesntCheckParameterClass")
    public boolean equals(Object other) {
        return Engine.typeIs(other, ModelMapImpl.class) && super._equals(other);
    }
}
