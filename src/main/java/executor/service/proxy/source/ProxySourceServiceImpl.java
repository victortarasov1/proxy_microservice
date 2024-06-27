package executor.service.proxy.source;

import executor.service.proxy.model.ProxyConfigHolder;
import executor.service.proxy.repository.ProxyConfigHolderRepository;
import executor.service.proxy.source.client.ProxyClient;
import executor.service.proxy.source.dto.RemoteProxyData;
import executor.service.proxy.source.validator.ProxyValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProxySourceServiceImpl implements ProxySourceService {
    private final ProxyConfigHolderRepository repository;
    private final ProxyValidator validator;
    private final ProxyClient client;
    @Override
    public void add() {
//        var proxies = client.get().stream().filter(validator::isValid).map(RemoteProxyData::createProxyConfigHolder);
//        proxies.peek(System.out::println).forEach(repository::save);
        client.get().stream().filter(validator::isValid).map(RemoteProxyData::createProxyConfigHolder).peek(System.out::println).forEach(repository::save);
    }

    @Override
    public ProxyConfigHolder get() {
        var proxy = repository.findFirstByOrderByCreatedAt().orElse(null);
        if(proxy != null) repository.delete(proxy);
        return proxy;
    }
}
