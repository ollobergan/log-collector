package uz.ollobergan.appcollector.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Document(indexName = "messages")
@NoArgsConstructor
public class ExceptionData {
    @Id
    private String id;
    private String appName;
    private Integer priority;
    private Timestamp exceptionTimestamp;
    private String message;
    private List<StackTraceElementData> stackTrace;

    public ExceptionData(Exception e) {
        this.message = e.getMessage();
        this.stackTrace = Arrays.stream(e.getStackTrace())
                .map(StackTraceElementData::new)
                .collect(Collectors.toList());
    }

    @Data
    @NoArgsConstructor
    public static class StackTraceElementData {
        private String declaringClass;
        private String methodName;
        private String fileName;
        private int lineNumber;

        public StackTraceElementData(StackTraceElement element) {
            this.declaringClass = element.getClassName();
            this.methodName = element.getMethodName();
            this.fileName = element.getFileName();
            this.lineNumber = element.getLineNumber();
        }
    }
}
