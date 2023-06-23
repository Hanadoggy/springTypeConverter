package dbwls.springTypeConverter;

import dbwls.springTypeConverter.converter.IpPortToStringConverter;
import dbwls.springTypeConverter.converter.StringToIntegerConverter;
import dbwls.springTypeConverter.converter.StringToIpPortConverter;
import dbwls.springTypeConverter.formatter.MyNumberFormatter;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry) {

        // 사용할 컨버터 등록, 포맷터를 위해 주석처리 (우선순위)
//        registry.addConverter(new StringToIntegerConverter());
//        registry.addConverter(new IpPortToStringConverter());
        registry.addConverter(new IpPortToStringConverter());
        registry.addConverter(new StringToIpPortConverter());

        registry.addFormatter(new MyNumberFormatter());
    }
}
