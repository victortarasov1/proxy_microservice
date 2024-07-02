package executor.service.proxy.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Table(name = "proxy_credentials")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProxyCredentials {
    @Id
    @UuidGenerator
    private String id;
    private String username;
    private String password;

    public ProxyCredentials(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
