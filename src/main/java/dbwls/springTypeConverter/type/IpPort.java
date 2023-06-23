package dbwls.springTypeConverter.type;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public class IpPort {

    private String ip;
    private int port;

    @Builder
    public IpPort(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }
}
