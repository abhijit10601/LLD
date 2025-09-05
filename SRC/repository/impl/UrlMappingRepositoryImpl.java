package SRC.repository.impl;

import java.util.HashMap;
import java.util.Map;

import SRC.entity.UrlMapping;
import SRC.repository.UrlMappingRepository;

public class UrlMappingRepositoryImpl implements UrlMappingRepository {
    private final Map<String, UrlMapping> byShortCode = new HashMap<>();
    private final Map<String, UrlMapping> byOriginalUrl = new HashMap<>();

    @Override
    public void save(UrlMapping mapping) {
        byShortCode.put(mapping.getShortCode(), mapping);
        byOriginalUrl.put(mapping.getOriginalUrl(), mapping);
    }

    @Override
    public UrlMapping findByShortCode(String shortCode) {
        return byShortCode.get(shortCode);
    }

    @Override
    public UrlMapping findByOriginalUrl(String originalUrl) {
        return byOriginalUrl.get(originalUrl);
    }
}
