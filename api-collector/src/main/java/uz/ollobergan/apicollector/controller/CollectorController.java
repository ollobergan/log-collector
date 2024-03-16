package uz.ollobergan.apicollector.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import uz.ollobergan.apicollector.dto.MessageDto;
import uz.ollobergan.apicollector.helper.CompressHelper;
import uz.ollobergan.apicollector.service.RabbitMqProducerService;

@RestController
public class CollectorController {
    @Autowired
    RabbitMqProducerService rabbitMqProducerService;

    @PostMapping(value = "/send/{appName}/{priority}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity sendMessage(@RequestBody Object message,
                                      @PathVariable("appName") String appName,
                                      @PathVariable("priority") int priority
                                      ) throws Exception {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(message);
        System.out.println(json);
        MessageDto messageDto = CompressHelper.CompressMessageDto(appName,priority,message);
        rabbitMqProducerService.pushMessage(messageDto);
        return ResponseEntity.ok().build();
    }
}
