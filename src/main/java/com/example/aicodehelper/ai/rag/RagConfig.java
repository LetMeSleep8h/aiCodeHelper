package com.example.aicodehelper.ai.rag;
import dev.langchain4j.data.document.loader.FileSystemDocumentLoader;
import dev.langchain4j.data.document.splitter.DocumentSplitters;
import dev.langchain4j.data.segment.TextSegment;
import dev.langchain4j.model.embedding.EmbeddingModel;
import dev.langchain4j.rag.content.retriever.ContentRetriever;
import dev.langchain4j.rag.content.retriever.EmbeddingStoreContentRetriever;
import dev.langchain4j.store.embedding.EmbeddingStore;
import dev.langchain4j.store.embedding.EmbeddingStoreIngestor;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ResourceLoader;


@Configuration
public class RagConfig {

    @Resource
    private EmbeddingModel qwenEmbeddingModel;

    @Resource
    private EmbeddingStore<TextSegment> embeddingStore;

    @Resource
    private ResourceLoader resourceLoader;

    @Bean
    public ContentRetriever contentRetriever() {
        // 1. 加载文档
        var documents = FileSystemDocumentLoader.loadDocuments("src/main/resources/docs");

        // 2. 文档切割（新版替代 DocumentByParagraphSplitter）
        var paragraphSplitter = DocumentSplitters.recursive(1000, 200);

        // 3. 构建 Ingestor
        var ingestor = EmbeddingStoreIngestor.builder()
                .documentSplitter(paragraphSplitter)
                // 核心：方法名 + TextSegment 创建方式变更
                .textSegmentTransformer(textSegment -> {
                    String fileName = textSegment.metadata().getString("file_name");
                    String newText = fileName + "\n" + textSegment.text();
                    return TextSegment.from(newText, textSegment.metadata());
                })
                .embeddingModel(qwenEmbeddingModel)
                .embeddingStore(embeddingStore)
                .build();

        // 4. 执行 ingestion
        ingestor.ingest(documents);

        // 5. 返回 ContentRetriever
        return EmbeddingStoreContentRetriever.builder()
                .embeddingModel(qwenEmbeddingModel)
                .embeddingStore(embeddingStore)
                .maxResults(5)
                .minScore(0.75)
                .build();
    }
}