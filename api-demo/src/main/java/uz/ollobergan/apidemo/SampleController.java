package uz.ollobergan.apidemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

    @GetMapping("/make-exception")
    public String makeException() throws Exception{
        if (1==1){
            throw new Exception("Xatolik bo'ldi!");
        }
        return "Exception occur";
    }
}
