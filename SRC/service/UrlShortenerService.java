package SRC.service;


public interface UrlShortenerService {
    /**
     * Shortens the given original URL.
     * If already shortened, returns existing short code.
     */
    String shortenUrl(String originalUrl);

    /**
     * Retrieves the original URL for the given short code.
     * Throws RuntimeException if not found.
     */
    String getOriginalUrl(String shortCode);
}