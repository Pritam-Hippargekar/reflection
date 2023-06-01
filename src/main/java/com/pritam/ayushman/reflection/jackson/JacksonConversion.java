package com.pritam.ayushman.reflection.jackson;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.pritam.ayushman.reflection.dto.Ayushman;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import java.util.Objects;
import java.util.Optional;

public class JacksonConversion {
    public static ObjectMapper customJson(){
//        var mapper = new ObjectMapper();
//        mapper.registerModule(new JavaTimeModule());
// mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);  OR @JsonIgnoreProperties(ignoreUnknown = true)
        // You can use a custom module to change the formatter
//        mapper.registerModule(new SimpleModule().addSerializer(
//                new LocalDateSerializer(DateTimeFormatter.ISO_LOCAL_DATE)));
        return new Jackson2ObjectMapperBuilder()
                .indentOutput(true)
                .serializationInclusion(JsonInclude.Include.NON_NULL)
                .propertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE)
                .build();
    }
    public static void main(String[] args) throws ClassNotFoundException, JsonProcessingException {
        JacksonConversion.stringToObject();
         JacksonConversion object = new JacksonConversion();
         if(Objects.isNull(object)){
             System.out.println("yes null");
         }else{
             System.out.println("not null");
         }

         String  fruit2 = null;
        System.out.println("Optional: " + Optional.ofNullable(fruit2));

        // java.lang.NullPointerException
        System.out.println("Optional: " + Optional.of(fruit2));


    }

    public static void stringToObject() throws ClassNotFoundException, JsonProcessingException {
        String jsonInString = "{\"age\":18000,\"name\":\"Rohit\",\"uniqueKey\":197}";

        Object ayushman = customJson().readValue(jsonInString, Class.forName("com.pritam.ayushman.reflection.dto.Ayushman"));
//         Employee emp = objectMapper.readValue(jsonInString, Employee.class);
        System.out.println(ayushman);
        jsonInString = customJson().writeValueAsString(ayushman);
        System.out.println(jsonInString);
    }
    public void objectToString(){

    }

//    protected String toJson(Object obj) throws JsonProcessingException {
//        ObjectMapper objectMapper = new ObjectMapper();
//        return objectMapper.writeValueAsString(obj);
//    }
//
//    protected <T> T fromJson(String json, Class<T> clazz) throws JsonParseException, JsonMappingException, IOException {
//        ObjectMapper objectMapper = new ObjectMapper();
//        return objectMapper.readValue(json, clazz);
//    }



//    @Configuration
//    public class JacksonConfiguration {
//        @Bean
//        public Jackson2ObjectMapperBuilderCustomizer jackson2ObjectMapperBuilderCustomizer() {
//            return builder -> {
//                // formatter
//                DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//                DateTimeFormatter dateTimeFormatter =  DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//                // deserializers
//                builder.deserializers(new LocalDateDeserializer(dateFormatter));
//                builder.deserializers(new LocalDateTimeDeserializer(dateTimeFormatter));
//                // serializers
//                builder.serializers(new LocalDateSerializer(dateFormatter));
//                builder.serializers(new LocalDateTimeSerializer(dateTimeFormatter));
//            };
//        }
//    }
}
