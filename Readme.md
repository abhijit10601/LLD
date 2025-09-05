# URL Shortener (Java)

A simple URL shortener implementation in Java with an in-memory LRU cache.

## Project Structure

```
SRC/
  Main.java
  entity/
    UrlMapping.java
  repository/
    UrlMappingRepository.java
    impl/
      UrlMappingRepositoryImpl.java
  service/
    UrlShortenerService.java
    impl/
      UrlShortenerServiceImpl.java
bin/
  (compiled .class files will be placed here)
```

## How to Compile

1. Open a terminal in the root project directory (where `SRC/` is located).
2. Run the following command to compile all Java files and output to `bin/`:

   ```sh
   javac -d bin SRC/Main.java SRC/entity/UrlMapping.java SRC/repository/UrlMappingRepository.java SRC/repository/impl/UrlMappingRepositoryImpl.java SRC/service/UrlShortenerService.java SRC/service/impl/UrlShortenerServiceImpl.java
   ```

   - This will create the necessary directory structure and `.class` files under `bin/`.

## How to Run

1. After compiling, run the main class using:

   ```sh
   java -cp bin SRC.Main
   ```

   - Make sure you are in the root directory (the one containing `bin/`).

## Example Output

```
Shortening URLs:
  https://www.example.com -> https://short.ly/3f1755e8
  https://openai.com -> https://short.ly/43a2c069
  https://github.com -> https://short.ly/ec158a91

Cache after shortening (most-recent last):
  https://short.ly/43a2c069
  https://short.ly/ec158a91

Retrieving URLs:
  Code: https://short.ly/43a2c069 maps to https://openai.com
  Code: https://short.ly/3f1755e8 maps to https://www.example.com

Cache after retrievals (most-recent last):
  https://short.ly/43a2c069
  https://short.ly/3f1755e8
```

*(Short codes will be random in your output)*

---

- Main entry point: [`SRC.Main`](SRC/Main.java)
- LRU cache

- FROKED REPO
