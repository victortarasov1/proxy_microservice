package executor.service.proxy.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UuidGenerator;

import java.time.Instant;

import static jakarta.persistence.CascadeType.ALL;
import static jakarta.persistence.FetchType.EAGER;

@Entity
@Table(name = "proxy_config_holders")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProxyConfigHolder {
    @Id
    @UuidGenerator
    private String id;
    @OneToOne(cascade = ALL, fetch = EAGER)
    private ProxyNetworkConfig proxyNetworkConfig;
    @OneToOne(cascade = ALL, fetch = EAGER)
    private ProxyCredentials proxyCredentials;
    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private Instant createdAt;
    public ProxyConfigHolder(ProxyNetworkConfig proxyNetworkConfig) {
        this.proxyNetworkConfig = proxyNetworkConfig;
    }
}
