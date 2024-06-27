package executor.service.proxy.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Table(name = "proxy_network_configs")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProxyNetworkConfig {
    @Id
    @UuidGenerator
    private String id;
    private String hostname;
    private Integer port;

    public ProxyNetworkConfig(String hostname, Integer port) {
        this.hostname = hostname;
        this.port = port;
    }
}
