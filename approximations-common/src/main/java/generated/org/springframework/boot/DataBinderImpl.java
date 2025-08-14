package generated.org.springframework.boot;

import org.jacodb.approximation.annotation.Approximate;
import org.springframework.lang.Nullable;
import org.springframework.validation.DataBinder;

@Approximate(DataBinder.class)
public class DataBinderImpl {

    @Nullable
    protected Object target;

    @Nullable
    protected String[] disallowedFields;
}
