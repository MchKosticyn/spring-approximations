package generated.org.slf4j;

import org.jacodb.approximation.annotation.Approximate;
import org.slf4j.Logger;
import org.slf4j.helpers.NOPLogger;

@SuppressWarnings("unused")
@Approximate(org.slf4j.LoggerFactory.class)
public abstract class LogFactoryImpl {

    public static Logger getLogger(String name) {
        return NOPLogger.NOP_LOGGER;
    }

    public static Logger getLogger(Class<?> clazz) {
        return NOPLogger.NOP_LOGGER;
    }
}
