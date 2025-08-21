package com.Spring_AI_RAG.ingestion;

import org.springframework.ai.document.Document;
import org.springframework.ai.reader.tika.TikaDocumentReader;
import org.springframework.ai.transformer.splitter.TextSplitter;
import org.springframework.ai.transformer.splitter.TokenTextSplitter;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentIngestionService implements CommandLineRunner {

    @Value("classpath:/pdf/spring-boot-reference.pdf")
    private Resource resource;


    private final VectorStore vectorStore;

    public DocumentIngestionService(VectorStore vectorStore) {
        this.vectorStore = vectorStore;
    }

    @Override
    public void run(String... args) throws Exception {
        //read pdf using tika doc reader
        TikaDocumentReader tikaDocumentReader = new TikaDocumentReader(resource);

        //split pdf into chunks
        TextSplitter textSplitter = new TokenTextSplitter();
        List<Document>documents = textSplitter.split(tikaDocumentReader.read());


        // store the data into vectordb
        vectorStore.accept(documents);
    }
}
