# Spring AI RAG with Ollama

A demo project integrating **Spring Boot + Ollama + RAG (Retrieval-Augmented Generation)**.

🚀 Features
- Chat endpoint powered by Ollama (LLMs running locally).
- Document upload and chunking with Spring AI.
- Ready for vector store integration (Postgres + pgvector or others).
- REST APIs tested with Postman.

## ⚙️ Tech Stack
- Java 21 / Spring Boot 3
- Spring AI
- Ollama (local LLMs)
- PostgreSQL + pgvector (optional, for embeddings)
- Maven

## 🛠️ Running the Project
1. Start Ollama locally:
   ```bash
   ollama run mistral
   
2.Clone this repo:
   bash
   git clone https://github.com/Sreenivasulu-03/spring-ai-rag.git
cd spring-ai-rag

3.Run the app:
   bash
   ./mvnw spring-boot:run

4.POST http://localhost:8080/chat
Body: { "message": "Hello AI!" }


📌 Future Improvements

Add frontend (React chat UI).
Store and query documents with pgvector.
Deploy with Docker Compose.


