import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public interface BasicDao<K, V> {
    Optional<V> get(UUID id);
    Map<K, V> getAll();
    void save(V t);
    void saveAll();
    void update(V t);
    void delete(V t);
}