package uz.ollobergan.apicollector.service;

import uz.ollobergan.apicollector.dto.MessageDto;

public interface RabbitMqProducerService {

    public void pushMessage(MessageDto rawMessageDto);

}
