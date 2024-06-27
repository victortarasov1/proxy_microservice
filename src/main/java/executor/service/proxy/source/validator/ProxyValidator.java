package executor.service.proxy.source.validator;


import executor.service.proxy.source.dto.RemoteProxyData;

public interface ProxyValidator {
    boolean isValid(RemoteProxyData proxy);

}
