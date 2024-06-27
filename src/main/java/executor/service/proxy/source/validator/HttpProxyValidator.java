package executor.service.proxy.source.validator;

import executor.service.proxy.source.dto.RemoteProxyData;
import okhttp3.Credentials;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;

import static org.springframework.http.HttpHeaders.PROXY_AUTHORIZATION;

@Component
class HttpProxyValidator implements ProxyValidator {
    @Value("${remote.proxy.validator}")
    private String proxyCheckerUrl;

    @Override
    public boolean isValid(RemoteProxyData proxy) {
        OkHttpClient proxiedHttpClient = createProxiedHttpClient(proxy.ip(), proxy.port());
        Request request = getRequest(proxy.username(), proxy.password());
        return validateProxy(proxiedHttpClient, request);
    }

    private OkHttpClient createProxiedHttpClient(String hostname, Integer port) {
        InetSocketAddress inetSocketAddress = new InetSocketAddress(hostname, port);
        return new OkHttpClient.Builder().proxy(new Proxy(Proxy.Type.HTTP, inetSocketAddress)).build();
    }

    private Request getRequest(String username, String password) {
        Request.Builder builder = new Request.Builder().url(proxyCheckerUrl);
        if (username != null && password != null)
            builder.header(PROXY_AUTHORIZATION, Credentials.basic(username, password));
        return builder.build();
    }

    private boolean validateProxy(OkHttpClient proxiedHttpClient, Request request) {
        try (Response response = proxiedHttpClient.newCall(request).execute()) {
            return response.isSuccessful();
        } catch (IOException ex) {
            return false;
        }
    }
}
