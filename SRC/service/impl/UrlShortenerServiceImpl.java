package SRC.service.impl;

import java.util.*;

import SRC.entity.UrlMapping;
import SRC.repository.UrlMappingRepository;
import SRC.service.UrlShortenerService;

public class UrlShortenerServiceImpl implements UrlShortenerService {
    private final UrlMappingRepository repository;
    private final LinkedHashMap<String, String> cache;

    /**
     * @param repository underlying repository
     * @param cacheCapacity maximum number of entries in LRU cache
     */
    public UrlShortenerServiceImpl(UrlMappingRepository repository, final int cacheCapacity) {
        this.repository = repository;
        this.cache = new LinkedHashMap<String, String>(cacheCapacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<String, String> eldest) {
                return size() > cacheCapacity;
            }
        };
    }

    @Override
    public String shortenUrl(String originalUrl) {
        // Check if already mapped
        UrlMapping existing = repository.findByOriginalUrl(originalUrl);
        if (existing != null) {
            cache.put(existing.getShortCode(), originalUrl);
            return existing.getShortCode();
        }
        // Generate new short code
        String shortCode = generateShortCode();
        UrlMapping mapping = new UrlMapping(shortCode, originalUrl);
        repository.save(mapping);
        cache.put(shortCode, originalUrl);
        return shortCode;
    }

    @Override
    public String getOriginalUrl(String shortCode) {
        // Try cache first
        if (cache.containsKey(shortCode)) {
            return cache.get(shortCode);
        }
        UrlMapping mapping = repository.findByShortCode(shortCode);
        if (mapping == null) {
            throw new RuntimeException("Short code not found: " + shortCode);
        }
        String originalUrl = mapping.getOriginalUrl();
        cache.put(shortCode, originalUrl);
        return originalUrl;
    }

    private String generateShortCode() {
        // Simple UUID-based code; in production use a better base62 encoder
        return "https://short.ly/" + UUID.randomUUID().toString().substring(0, 8);
    }

    /**
     * For demonstration: view current cache keys in LRU order (least-recent first).
     */
    public Set<String> getCacheKeys() {
        return Collections.unmodifiableSet(cache.keySet());
    }
}
