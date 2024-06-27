package executor.service.proxy.source;

import executor.service.proxy.model.ProxyConfigHolder;

public interface ProxySourceService {
    void add();
    ProxyConfigHolder get();
}
