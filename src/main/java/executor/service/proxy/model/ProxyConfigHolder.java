package executor.service.proxy.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
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
