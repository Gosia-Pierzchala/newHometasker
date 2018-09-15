package mp.new_hometasker;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class ConvertStringToPerson {
    @Configuration
    public class WebConfig implements WebMvcConfigurer {

        private StringToPersonConverter converter;

        public WebConfig(StringToPersonConverter converter) {
            this.converter = converter;
        }

        @Override
        public void addFormatters(FormatterRegistry registry) {
            registry.addConverter(converter);
        }
    }
    @Component
    public class StringToPersonConverter implements Converter<String, Person> {

        private HomeTaskerRepository homeTaskerRepository;

        public StringToPersonConverter(HomeTaskerRepository homeTaskerRepository) {
            this.homeTaskerRepository = homeTaskerRepository;
        }

        @Override
        public Person convert(String from) {
            String[] data = from.split(" ");
            return homeTaskerRepository.find(data[0], data[1]);
        }
    }
}
