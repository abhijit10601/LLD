package SRC;

import SRC.repository.UrlMappingRepository;
import SRC.repository.impl.UrlMappingRepositoryImpl;
import SRC.service.impl.UrlShortenerServiceImpl;

public class Main {
    public static void main(String[] args) {
        // Initialize repository and service with small cache capacity = 2
        UrlMappingRepository repo = new UrlMappingRepositoryImpl();
        UrlShortenerServiceImpl service = new UrlShortenerServiceImpl(repo, 2);

        // Sample URLs
        String[] urls = {
            "https://www.example.com",
            "https://openai.com",
            "https://github.com"
        };

        // Shorten each URL
        System.out.println("Shortening URLs:");
        for (String url : urls) {
            String code = service.shortenUrl(url);
            System.out.printf("  %s -> %s%n", url, code);
        }

        // Show cache contents
        System.out.println("\nCache after shortening (most-recent last):");
        service.getCacheKeys().forEach(k -> System.out.println("  " + k));

        // Access some URLs to demonstrate LRU behavior
        System.out.println("\nRetrieving URLs:");
        System.out.println("  Code: " + service.shortenUrl(urls[1]) + " maps to " + service.getOriginalUrl(service.shortenUrl(urls[1])));
        System.out.println("  Code: " + service.shortenUrl(urls[0]) + " maps to " + service.getOriginalUrl(service.shortenUrl(urls[0])));

        // Show cache contents after accesses
        System.out.println("\nCache after retrievals (most-recent last):");
        service.getCacheKeys().forEach(k -> System.out.println("  " + k));
    }
}
