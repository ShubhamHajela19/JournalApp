# Journal App

A simple Spring Boot REST API for creating, reading, updating, and deleting journal entries.

The application currently stores journal entries in memory using a `HashMap`, so all data is lost when the application stops or restarts.

## Tech Stack

- Java 26
- Spring Boot 4.0.6
- Maven
- Spring Web MVC

## Project Structure

```text
journalApp/
+-- pom.xml
+-- src/main/java/com/shubham/journalApp/
|   +-- JournalApplication.java
|   +-- controller/
|   |   +-- HealthCheck.java
|   |   +-- JournalEntryController.java
|   +-- entity/
|       +-- JournalEntry.java
+-- src/main/resources/
    +-- application.properties
```

## Requirements

- JDK 26
- Maven, or use the included Maven wrapper

## Run The Application

From the `journalApp` directory:

```bash
./mvnw spring-boot:run
```

On Windows PowerShell:

```powershell
.\mvnw.cmd spring-boot:run
```

The app starts on:

```text
http://localhost:8080
```

## API Endpoints

### Health Check

```http
GET /health-check
```

Response:

```text
OK
```

### Get All Journal Entries

```http
GET /journal
```

Response example:

```json
[
  {
    "id": 1,
    "title": "First Entry",
    "content": "Today I started my journal app."
  }
]
```

### Create A Journal Entry

```http
POST /journal
Content-Type: application/json
```

Request body:

```json
{
  "id": 1,
  "title": "First Entry",
  "content": "Today I started my journal app."
}
```

Response:

```json
true
```

### Get Journal Entry By ID

```http
GET /journal/id/{myId}
```

Example:

```http
GET /journal/id/1
```

Response example:

```json
{
  "id": 1,
  "title": "First Entry",
  "content": "Today I started my journal app."
}
```

### Update Journal Entry By ID

```http
PUT /journal/id/{id}
Content-Type: application/json
```

Example:

```http
PUT /journal/id/1
```

Request body:

```json
{
  "id": 1,
  "title": "Updated Entry",
  "content": "This entry has been updated."
}
```

Response:

The current implementation returns the previous journal entry stored at that ID. If no entry existed before, it returns `null`.

### Delete Journal Entry By ID

```http
DELETE /journal/id/{myId}
```

Example:

```http
DELETE /journal/id/1
```

Response:

The deleted journal entry. If the ID does not exist, it returns `null`.

## Example cURL Commands

Create an entry:

```bash
curl -X POST http://localhost:8080/journal \
  -H "Content-Type: application/json" \
  -d '{"id":1,"title":"First Entry","content":"Today I started my journal app."}'
```

Get all entries:

```bash
curl http://localhost:8080/journal
```

Get one entry:

```bash
curl http://localhost:8080/journal/id/1
```

Update an entry:

```bash
curl -X PUT http://localhost:8080/journal/id/1 \
  -H "Content-Type: application/json" \
  -d '{"id":1,"title":"Updated Entry","content":"This entry has been updated."}'
```

Delete an entry:

```bash
curl -X DELETE http://localhost:8080/journal/id/1
```

## Run Tests

From the `journalApp` directory:

```bash
./mvnw test
```

On Windows PowerShell:

```powershell
.\mvnw.cmd test
```

## Notes

- This project does not currently use a database.
- Journal entries are stored only while the application is running.
- There is no validation yet for missing IDs, duplicate IDs, empty titles, or empty content.
- There is no authentication or authorization yet.
