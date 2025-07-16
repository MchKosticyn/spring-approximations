package generated.org.springframework.security;

import org.jacodb.approximation.annotation.Approximate;
import org.springframework.security.access.expression.SecurityExpressionRoot;
import org.springframework.security.core.GrantedAuthority;
import org.usvm.api.Engine;
import org.usvm.spring.api.SpringEngine;

import java.util.Collection;

@Approximate(SecurityExpressionRoot.class)
public class SecurityExpressionRootImpl {

    @SuppressWarnings("unchecked")
    private Collection<GrantedAuthority> getAuthoritySet() {
        return (Collection<GrantedAuthority>) new SecurityContextImplImpl().getAuthentication().getAuthorities();
    }

    private boolean hasAnyAuthorityName(String prefix, String... roles) {
        SpringEngine.println("Attempting to check authorities:");
        for (String neededRole : roles) {
            SpringEngine.println(neededRole);
        }

        Collection<GrantedAuthority> roleSet = getAuthoritySet();
        for (String neededRole : roles) {
            for (Object authority : roleSet) {
                Engine.assume(authority != null);
                Engine.assume(authority instanceof GrantedAuthority);

                String authorityString = ((GrantedAuthority)authority).getAuthority();
                Engine.assume(authorityString != null);

                if (authorityString.equals(roleWithPrefix(prefix, neededRole)))
                    return true;
            }
        }

        Engine.assume(false);
        return false;
    }

    private String roleWithPrefix(String prefix, String role) {
        if (prefix == null) return role;
        return prefix + role;
    }
}
