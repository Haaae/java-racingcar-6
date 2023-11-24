package racingcar.repoitory;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import racingcar.entity.Entity;

/**
entity의 상태를 update하는 메서드는 별도로 존재하지 않는다.
entity를 update할 때는 entity를 find하여 엔티티 내부의 메서드를 사용해 상태를 변경한다.
또한 되도록 entity의 값은 불변 값으로 하여 값을 변경하는 일 자체를 없도록 한다.
 */
public class Repoitory<T extends Entity> {
    private final Map<Long, T> repository = new LinkedHashMap<>();

    public T save(final T t) {
        return repository.put(
                t.getId(),
                t
        );
    }

    public void save(final List<T> entities) {
        entities.forEach(this::save);
    }

    public T remove(final T t) {
        return remove(t.getId());
    }

    public T remove(final Long id) {
        return repository.remove(id);
    }

    public void remove(final List<T> entities) {
        entities.forEach(this::remove);
    }

    public T find(final Long id) {
        return repository.get(id);
    }

    public List<T> finaAll() {
        return repository.values()
                .stream()
                .toList();
    }

    public boolean contains(final T t) {
        return repository.containsKey(
                t.getId()
        );
    }
}
