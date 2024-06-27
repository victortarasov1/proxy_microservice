package executor.service.proxy.source.dto;


import executor.service.proxy.model.ProxyConfigHolder;
import executor.service.proxy.model.ProxyCredentials;
import executor.service.proxy.model.ProxyNetworkConfig;

/**
 * Represents remote proxy configuration data and provides a mapping to the required data structure.
 * This class acts as an adapter between the data structure of information retrieved from a remote API
 * and the way it needs to be organized for the {@link ProxyConfigHolder} class.
 */
public record RemoteProxyData(String username, String password, String ip, Integer port) {
    public RemoteProxyData {
        ip = ip.strip();
        if (username != null && password != null) {
            username = username.strip();
            password = password.strip();
        }
    }

    public ProxyConfigHolder createProxyConfigHolder() {
        ProxyConfigHolder holder = new ProxyConfigHolder(new ProxyNetworkConfig(ip, port));
        if(username != null && password != null) holder.setProxyCredentials(new ProxyCredentials(username, password));
        return holder;
    }
}
