package generated.org.springframework.boot;

import org.usvm.spring.api.SpringEngine;

public class SpringUtils {

    public static void internalLog(String... message) {
        for (String str : message) {
            SpringEngine.println(str);
        }
    }
}
