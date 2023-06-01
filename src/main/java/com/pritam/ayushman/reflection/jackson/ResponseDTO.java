package com.pritam.ayushman.reflection.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.util.Assert;

//https://medium.com/javarevisited/creating-a-springboot-crud-api-using-the-jackson-objectmapper-a3457ec158ef
public class ResponseDTO<T> extends HttpEntity<T> {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    ResponseDTO(T body, HttpStatus status) {
        super(body);
    }


    public static Builder accepted() {
        return status(HttpStatus.ACCEPTED);
    }

    public static Builder badRequest() {
        return status(HttpStatus.BAD_REQUEST);
    }

    public static Builder status(HttpStatus status) {
        return new BodyBuilder(status);
    }

    public interface Builder {
        <T> ResponseDTO<T> convertTo(Object entity, Class<T> aClass);
    }

    private static class BodyBuilder  implements Builder{
        private final HttpStatus status;

        public BodyBuilder(HttpStatus status) {
            this.status = status;
        }

        public <T> ResponseDTO<T> convertTo(Object entity, Class<T> aClass) {
            return new ResponseDTO<>(objectMapper.convertValue(entity, aClass), this.status);
        }
    }

}
