package uz.ollobergan.apidemo;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Arrays;

public class ExceptionData {
    private String message;
    private List<StackTraceElementData> stackTrace;

    public ExceptionData(Exception e) {
        this.message = e.getMessage();
        this.stackTrace = Arrays.stream(e.getStackTrace())
                .map(StackTraceElementData::new)
                .collect(Collectors.toList());
    }

    // Getters and Setters
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<StackTraceElementData> getStackTrace() {
        return stackTrace;
    }

    public void setStackTrace(List<StackTraceElementData> stackTrace) {
        this.stackTrace = stackTrace;
    }

    static class StackTraceElementData {
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

        // Getters and Setters
        public String getDeclaringClass() {
            return declaringClass;
        }

        public void setDeclaringClass(String declaringClass) {
            this.declaringClass = declaringClass;
        }

        public String getMethodName() {
            return methodName;
        }

        public void setMethodName(String methodName) {
            this.methodName = methodName;
        }

        public String getFileName() {
            return fileName;
        }

        public void setFileName(String fileName) {
            this.fileName = fileName;
        }

        public int getLineNumber() {
            return lineNumber;
        }

        public void setLineNumber(int lineNumber) {
            this.lineNumber = lineNumber;
        }
    }
}

