package executor.service.proxy.source;

import executor.service.proxy.model.ProxyConfigHolder;
import jakarta.annotation.Nullable;

public interface ProxySourceService {
    void add();
    @Nullable
    ProxyConfigHolder get();
}
