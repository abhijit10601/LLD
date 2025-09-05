package SRC.repository;

import SRC.entity.UrlMapping;

public interface UrlMappingRepository {
    void save(UrlMapping mapping);
    UrlMapping findByShortCode(String shortCode);
    UrlMapping findByOriginalUrl(String originalUrl);
}