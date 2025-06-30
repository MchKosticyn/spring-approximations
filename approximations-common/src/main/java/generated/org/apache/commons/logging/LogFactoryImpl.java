package generated.org.apache.commons.logging;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.impl.NoOpLog;
import org.jacodb.approximation.annotation.Approximate;

@Approximate(org.apache.commons.logging.LogFactory.class)
public abstract class LogFactoryImpl {

    public static Log getLog(Class<?> clazz) {
        return new NoOpLog();
    }

    public static Log getLog(String name) {
        return new NoOpLog();
    }
}
