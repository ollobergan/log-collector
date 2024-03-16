package uz.ollobergan.appcollector.handler;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.ollobergan.appcollector.constant.RabbitMqConstants;
import uz.ollobergan.appcollector.dto.ExceptionData;
import uz.ollobergan.appcollector.dto.ExceptionDto;
import uz.ollobergan.appcollector.helper.CompressHelper;
import uz.ollobergan.appcollector.mapper.ExceptionDataMapper;
import uz.ollobergan.appcollector.service.ElasticSearchService;

@Service
public class DistributorHandler {

    @Autowired
    private ElasticSearchService elasticSearchService;
    @RabbitListener(queues = RabbitMqConstants.RABBIT_MAIN_QUEUE, containerFactory = "rabbitListenerContainerFactory")
    public void listenMessages(Message message) throws Exception {
        //Get rabbit message body
        String messageBody = new String(message.getBody(),"UTF-8");
        //Decode message to DTO
        ExceptionDto exceptionDto = CompressHelper.DecodeToDto(messageBody, ExceptionDto.class);
        String json = CompressHelper.Decompress(exceptionDto.getObject());
        ExceptionData exceptionData = ExceptionDataMapper.jsonToDto(json);
        String[] arrOfStr = (exceptionDto.get_objVersion()).split("\\.", -1);
        exceptionData.setAppName(arrOfStr[0]);
        exceptionData.setPriority(Integer.parseInt(arrOfStr[1]));
        exceptionData.setExceptionTimestamp(exceptionDto.get_objTimestamp());

        elasticSearchService.saveMessage(exceptionData);
    }
}
