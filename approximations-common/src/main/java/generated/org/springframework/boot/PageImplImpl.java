package generated.org.springframework.boot;

import org.jacodb.approximation.annotation.Approximate;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.usvm.api.Engine;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Approximate(org.springframework.data.domain.PageImpl.class)
public class PageImplImpl<T> {

    private final ArrayList<T> content;

    private final long total;

    private final Pageable pageable;

    public PageImplImpl(List<T> content, Pageable pageable, long total) {
        Engine.assume(content != null);
        Engine.assume(pageable != null);
        this.pageable = pageable;
        this.content = new ArrayList<>(content);
        this.total = pageable.toOptional().filter(it -> !content.isEmpty())
                .filter(it -> it.getOffset() + it.getPageSize() > total)
                .map(it -> it.getOffset() + content.size())
                .orElse(total);
    }

    private void _assume() {
        Engine.assume(this.content != null);
        Engine.assume(this.pageable != null);
        Engine.assume(this.total >= 0);
        Engine.assume(this.total <= 20);
    }

    public int getTotalPages() {
        _assume();
        return getSize() == 0 ? 1 : (int) Math.ceil((double) total / (double) getSize());
    }

    public int getSize() {
        _assume();
        return pageable.isPaged() ? pageable.getPageSize() : content.size();
    }

    public int getNumberOfElements() {
        _assume();
        return content.size();
    }

    public int getNumber() {
        _assume();
        return pageable.isPaged() ? pageable.getPageNumber() : 0;
    }

    public boolean hasPrevious() {
        _assume();
        return getNumber() > 0;
    }

    public boolean isFirst() {
        _assume();
        return !hasPrevious();
    }

    public boolean isLast() {
        _assume();
        return !hasNext();
    }

    public boolean hasNext() {
        _assume();
        return getNumber() + 1 < getTotalPages();
    }

    public Pageable nextPageable() {
        _assume();
        return hasNext() ? pageable.next() : Pageable.unpaged();
    }

    public Pageable previousPageable() {
        _assume();
        return hasPrevious() ? pageable.previousOrFirst() : Pageable.unpaged();
    }

    public boolean hasContent() {
        _assume();
        return !content.isEmpty();
    }

    public List<T> getContent() {
        _assume();
        return content;
    }

    public Pageable getPageable() {
        _assume();
        return pageable;
    }

    public Sort getSort() {
        _assume();
        return pageable.getSort();
    }

    public Iterator<T> iterator() {
        _assume();
        return content.iterator();
    }

    public List<T> toList() {
        _assume();
        return content;
    }
}
