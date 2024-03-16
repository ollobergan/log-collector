package uz.ollobergan.appcollector.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import uz.ollobergan.appcollector.dto.ExceptionData;

public interface ElasticSearchMessageRepository extends ElasticsearchRepository<ExceptionData, String> {
}