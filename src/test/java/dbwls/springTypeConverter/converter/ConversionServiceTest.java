package dbwls.springTypeConverter.converter;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.core.convert.support.DefaultConversionService;

import static org.assertj.core.api.Assertions.*;

public class ConversionServiceTest {

    @Test
    void conversionService() {

        // 등록
        DefaultConversionService conversionService = new DefaultConversionService();
        conversionService.addConverter(new StringToIntegerConverter());
        conversionService.addConverter(new IntegerToStringConverter());
        conversionService.addConverter(new IpPortToStringConverter());
        conversionService.addConverter(new StringToIpPortConverter());

        // 사용
        Integer result = conversionService.convert("10", Integer.class);
        System.out.println("result = " + result);
        assertThat(conversionService.convert(10, String.class)).isEqualTo("10");
        assertThat(conversionService.convert("10", Integer.class)).isEqualTo(10);
    }
}
