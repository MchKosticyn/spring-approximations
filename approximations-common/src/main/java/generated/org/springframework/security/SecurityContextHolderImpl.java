package generated.org.springframework.security;

import org.jacodb.approximation.annotation.Approximate;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextImpl;

@Approximate(SecurityContextHolder.class)
public class SecurityContextHolderImpl {
    public static SecurityContext getContext() {
        return new SecurityContextImpl();
    }
}
