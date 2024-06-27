package executor.service.proxy.repository;

import executor.service.proxy.model.ProxyConfigHolder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProxyConfigHolderRepository extends JpaRepository<ProxyConfigHolder, String> {

    Optional<ProxyConfigHolder> findFirstByOrderByCreatedAt();

}
