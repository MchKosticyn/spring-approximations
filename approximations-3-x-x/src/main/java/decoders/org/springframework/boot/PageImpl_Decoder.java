package decoders.org.springframework.boot;

import org.jacodb.api.jvm.*;
import org.springframework.data.domain.PageImpl;
import org.usvm.api.decoder.DecoderApi;
import org.usvm.api.decoder.DecoderFor;
import org.usvm.api.decoder.ObjectData;
import org.usvm.api.decoder.ObjectDecoder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@DecoderFor(PageImpl.class)
public class PageImpl_Decoder implements ObjectDecoder {
    private volatile JcMethod cached_PageImpl_full_ctor = null;
    private volatile JcMethod cached_PageImpl_content_ctor = null;
    private volatile JcField cached_Content_field = null;
    private volatile JcField cached_Pageable_field = null;
    private volatile JcField cached_Total_filed = null;

    @Override
    public <T> T createInstance(
            JcClassOrInterface approximation,
            ObjectData<T> objectData,
            DecoderApi<T> decoder
    ) {
        JcMethod m_full_ctor = cached_PageImpl_content_ctor;
        JcMethod m_content_ctor = cached_PageImpl_full_ctor;
        // TODO: add synchronization if needed
        if (m_full_ctor == null) {
            final List<JcMethod> methodList = approximation.getDeclaredMethods();   
            final int methodCount = methodList.size();
            JcMethod[] methods = new JcMethod[methodCount];
            methods = methodList.toArray(methods);

            for (int i = 0; i != methodCount; i++) {
                JcMethod m = methods[i];

                if (m.isConstructor()) {
                    List<JcParameter> params = m.getParameters();
                    if (params.size() == 3) cached_PageImpl_full_ctor = m_full_ctor = m;
                    if (params.size() == 1) cached_PageImpl_content_ctor = m_content_ctor = m;
                }
            }

            final List<JcField> fields = approximation.getDeclaredFields();
            for (int i = 0, c = fields.size(); i != c; i++) {
                JcField f = fields.get(i);
                if ("content".equals(f.getName())) {
                    cached_Content_field = f;
                }
                if ("pageable".equals(f.getName())) {
                    cached_Pageable_field = f;
                }
                if ("total".equals(f.getName())) {
                    cached_Total_filed = f;
                }
            }
        }

        // prepare parameters "in-place" and construct a new call
        final ArrayList<T> args = new ArrayList<>();
        if (objectData.getObjectField(cached_Content_field) != null) {
            T content = objectData.decodeField(cached_Content_field);
            T pageable = objectData.decodeField(cached_Pageable_field);
            T total = objectData.decodeField(cached_Total_filed);
            args.add(content);
            args.add(pageable);
            args.add(total);
            return decoder.invokeMethod(m_full_ctor, args);
        }

        args.add(createEmptyList(approximation.getClasspath(), decoder));
        return decoder.invokeMethod(m_content_ctor, args);
    }

    @SuppressWarnings("unchecked")
    private <T> T createEmptyList(JcClasspath classPath, DecoderApi<T> decoder) {
        JcClassOrInterface listClass = classPath.findClassOrNull("java.util.ArrayList");
        List<JcMethod> methods = listClass.getDeclaredMethods();
        JcMethod emptyCtor = null;
        for (JcMethod method : methods) {
            if (method.isConstructor() && method.getParameters().isEmpty()) {
                emptyCtor = method;
                break;
            }
        }
        return decoder.invokeMethod(emptyCtor, (List<T>) Collections.EMPTY_LIST);
    }

    @Override
    public <T> void initializeInstance(
            JcClassOrInterface jcClassOrInterface,
            ObjectData<T> objectData,
            T t,
            DecoderApi<T> decoderApi
    ) {
    }
}
