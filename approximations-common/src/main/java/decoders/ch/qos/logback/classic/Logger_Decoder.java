package decoders.ch.qos.logback.classic;

import org.jacodb.api.jvm.JcClassOrInterface;
import org.jacodb.api.jvm.JcField;
import org.jacodb.api.jvm.JcMethod;
import org.jacodb.api.jvm.JcParameter;
import org.usvm.api.decoder.DecoderApi;
import org.usvm.api.decoder.DecoderFor;
import org.usvm.api.decoder.ObjectData;
import org.usvm.api.decoder.ObjectDecoder;

import java.util.ArrayList;
import java.util.List;

@DecoderFor(ch.qos.logback.classic.Logger.class)
public class Logger_Decoder implements ObjectDecoder {

    private volatile JcMethod cached_Logger_ctor = null;
    private volatile JcField cached_Logger_name = null;
    private volatile JcField cached_Logger_parent = null;
    private volatile JcField cached_Logger_loggerContext = null;

    @Override
    public <T> T createInstance(final JcClassOrInterface approximation,
                                final ObjectData<T> approximationData,
                                final DecoderApi<T> decoder) {
        // TODO: implement
        JcMethod ctor = cached_Logger_ctor;
        // TODO: add synchronization if needed
        if (ctor == null) {
            // looking for constructor and data field
            final List<JcMethod> methods = approximation.getDeclaredMethods();
            for (int i = 0, c = methods.size(); i != c; i++) {
                JcMethod m = methods.get(i);

                if (!m.isConstructor()) continue;

                cached_Logger_ctor = ctor = m;
                break;
            }

            final List<JcField> fields = approximation.getDeclaredFields();
            for (int i = 0, c = fields.size(); i != c; i++) {
                JcField f = fields.get(i);
                if ("name".equals(f.getName())) {
                    cached_Logger_name = f;
                    continue;
                }

                if ("parent".equals(f.getName())) {
                    cached_Logger_parent = f;
                    continue;
                }

                if ("loggerContext".equals(f.getName())) {
                    cached_Logger_loggerContext = f;
                }
            }
        }

        T name = approximationData.decodeField(cached_Logger_name);
//        T parent = approximationData.decodeField(cached_Logger_parent);
        T parent = null;
//        T loggerContext = approximationData.decodeField(cached_Logger_loggerContext);
        T loggerContext = null;

        final List<T> args = new ArrayList<>();
        args.add(name);
        args.add(parent);
        args.add(loggerContext);
        return decoder.invokeMethod(ctor, args);
    }

    @Override
    public <T> void initializeInstance(final JcClassOrInterface approximation,
                                       final ObjectData<T> approximationData,
                                       final T outputInstance,
                                       final DecoderApi<T> decoder) {
        // nothing
    }
}
