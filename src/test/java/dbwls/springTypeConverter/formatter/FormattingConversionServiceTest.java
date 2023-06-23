package dbwls.springTypeConverter.formatter;

import dbwls.springTypeConverter.converter.IpPortToStringConverter;
import dbwls.springTypeConverter.converter.StringToIpPortConverter;
import dbwls.springTypeConverter.type.IpPort;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.format.support.DefaultFormattingConversionService;

import static org.assertj.core.api.Assertions.*;

public class FormattingConversionServiceTest {

    @Test
    void formattingConversionService() {
        DefaultFormattingConversionService conversionService = new DefaultFormattingConversionService();
        conversionService.addConverter(new StringToIpPortConverter());
        conversionService.addConverter(new IpPortToStringConverter());
        conversionService.addFormatter(new MyNumberFormatter());

        IpPort ipPort = conversionService.convert("128.1.2.3:8080", IpPort.class);
        assertThat(ipPort).isEqualTo(new IpPort("128.1.2.3", 8080));

        String convert = conversionService.convert(1000, String.class);
        assertThat(convert).isEqualTo("1,000");
        assertThat(1000L).isEqualTo(conversionService.convert("1,000", Number.class));
    }
}
