package generated.org.springframework.boot;

import org.jacodb.approximation.annotation.Approximate;
import org.springframework.core.MethodParameter;
import org.springframework.lang.Nullable;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.ModelAndViewContainer;

@SuppressWarnings("unused")
@Approximate(org.springframework.web.method.annotation.ErrorsMethodArgumentResolver.class)
public class ErrorsMethodArgumentResolverImpl {

    @SuppressWarnings("RedundantThrows")
    public Object resolveArgument(MethodParameter parameter, @Nullable ModelAndViewContainer mavContainer, NativeWebRequest webRequest, @Nullable WebDataBinderFactory binderFactory) throws Exception {
        Assert.state(mavContainer != null, "Errors/BindingResult argument only supported on regular handler methods");
        ModelMapImpl model = (ModelMapImpl) (Object) mavContainer.getModel();
        String lastKey = model.lastKey;
        SpringUtils._internalLog("ErrorsMethodArgumentResolverImpl.resolveArgument.lastKey =", lastKey);
        if (lastKey != null && lastKey.startsWith(BindingResult.MODEL_KEY_PREFIX)) {
            return model.get(lastKey);
        } else {
            throw new IllegalStateException("An Errors/BindingResult argument is expected to be declared immediately after the model attribute, the @RequestBody or the @RequestPart arguments to which they apply: " + parameter.getMethod());
        }
    }
}
