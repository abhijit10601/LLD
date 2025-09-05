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
  https://www.example.com -> 1234abcd
  https://openai.com -> abcd5678
  https://github.com -> efgh9012

Cache after shortening (most-recent last):
  1234abcd
  abcd5678

Retrieving URLs:
  Code: abcd5678 maps to https://openai.com
  Code: 1234abcd maps to https://www.example.com

Cache after retrievals (most-recent last):
  abcd5678
  1234abcd
```

*(Short codes will be random in your output)*

---

- Main entry point: [`SRC.Main`](SRC/Main.java)
- LRU cache