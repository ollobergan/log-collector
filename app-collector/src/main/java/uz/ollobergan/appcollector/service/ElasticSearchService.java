package uz.ollobergan.appcollector.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.ollobergan.appcollector.dto.ExceptionData;
import uz.ollobergan.appcollector.repository.ElasticSearchMessageRepository;

@Service
public class ElasticSearchService {
    @Autowired
    private ElasticSearchMessageRepository messageRepository;

    public void saveMessage(ExceptionData message) {
        messageRepository.save(message);
    }
}
