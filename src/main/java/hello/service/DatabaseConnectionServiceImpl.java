package hello.service;

import hello.repository.DatabaseConnectionRepository;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.cache.Cache;
import javax.cache.CacheManager;
import javax.cache.Caching;
import javax.cache.configuration.MutableConfiguration;
import javax.cache.spi.CachingProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class DatabaseConnectionServiceImpl implements DatabaseConnectionService {

    private final DatabaseConnectionRepository databaseConnectionRepository;
    private final Cache<String, List<Map<String, Object>>> cache;

    @Autowired
    public DatabaseConnectionServiceImpl(DatabaseConnectionRepository databaseConnectionRepository, CacheManager cacheManager) {
        this.databaseConnectionRepository = Objects.requireNonNull(databaseConnectionRepository);
        CachingProvider cachingProvider = Caching.getCachingProvider();
        CacheManager cm = cachingProvider.getCacheManager();
        MutableConfiguration<String, List<Map<String, Object>>> config = new MutableConfiguration<>();
        cache = cm.createCache("queryResults", config);
    }

    @Override
    public List<Map<String, Object>> queryAll(String query, Object[] params) {
        if (query == null || query.isEmpty() || params == null) {
            throw new IllegalArgumentException("Invalid input parameters");
        }
        try {
            List<Map<String, Object>> cachedResults = cache.get(query);
            if (cachedResults != null) {
                return cachedResults;
            }
            List<Map<String, Object>> results = databaseConnectionRepository.queryAll(query, params);
            if (!CollectionUtils.isEmpty(results)) {
                cache.put(query, results);
            }
            return results;
        } catch (Exception e) {
            throw new RuntimeException("Error executing query", e);
        }
    }
}