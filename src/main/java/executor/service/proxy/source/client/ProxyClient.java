package executor.service.proxy.source.client;

import executor.service.proxy.source.dto.RemoteProxyData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "proxyClient", url = "${remote.proxy.source}")
public interface ProxyClient {

    @GetMapping
    List<RemoteProxyData> get();
}
