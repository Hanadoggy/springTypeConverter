package dbwls.springTypeConverter.converter;

import dbwls.springTypeConverter.type.IpPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;

@Slf4j
public class StringToIpPortConverter implements Converter<String, IpPort> {

    @Override
    public IpPort convert(String source) {

        log.info("convert source = {}", source);
        String[] split = source.split(":");

        return IpPort.builder()
                .ip(split[0])
                .port(Integer.parseInt(split[1]))
                .build();
    }
}
