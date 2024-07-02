package executor.service.proxy.source;

import executor.service.proxy.model.ProxyConfigHolder;
import executor.service.proxy.repository.ProxyConfigHolderRepository;
import executor.service.proxy.source.client.ProxyClient;
import executor.service.proxy.source.dto.RemoteProxyData;
import executor.service.proxy.source.validator.ProxyValidator;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProxySourceServiceImpl implements ProxySourceService {
    private final ProxyConfigHolderRepository repository;
    private final ProxyValidator validator;
    private final ProxyClient client;
    private static final Logger logger = LoggerFactory.getLogger(ProxySourceServiceImpl.class);
    @Override
    public void add() {
        var proxies = client.get().stream().filter(validator::isValid);
        proxies.map(RemoteProxyData::createProxyConfigHolder).forEach(this::saveValidProxy);
    }

    @Override
    public ProxyConfigHolder get() {
        var proxy = repository.findFirstByOrderByCreatedAt().orElse(null);
        if(proxy != null) deleteProxy(proxy);
        return proxy;
    }
    private void saveValidProxy(ProxyConfigHolder proxy) {
        repository.save(proxy);
        logger.info("saved proxy: {}", proxy);
    }
    private void deleteProxy(ProxyConfigHolder proxy) {
        repository.delete(proxy);
        logger.info("deleted proxy: {}", proxy);
    }
}
