package uz.ollobergan.apidemo;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.RestTemplate;

@ControllerAdvice
public class GlobalExceptionHandler {

    private final RestTemplate restTemplate;
    private final String apiEndpoint = "http://127.0.0.1:8080/send/demo/1";

    public GlobalExceptionHandler() {
        this.restTemplate = new RestTemplate();
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleException(Exception e) {
        ExceptionData data = new ExceptionData(e);

        // Sending the exception details to the external API
        HttpEntity<ExceptionData> request = new HttpEntity<>(data);
        restTemplate.postForObject(apiEndpoint, request, String.class);

        // You might want to return a general error response here
        return new ResponseEntity<>("An error occurred", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
