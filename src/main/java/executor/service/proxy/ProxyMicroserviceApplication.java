package executor.service.proxy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ProxyMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProxyMicroserviceApplication.class, args);
	}

}
