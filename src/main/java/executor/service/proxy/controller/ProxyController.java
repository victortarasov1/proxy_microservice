package executor.service.proxy.controller;

import executor.service.proxy.model.ProxyConfigHolder;
import executor.service.proxy.source.ProxySourceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@RequiredArgsConstructor
public class ProxyController {

    private final ProxySourceService service;
    @PostMapping("/add")
    public void add() {
        CompletableFuture.runAsync(service::add);
    }

    @GetMapping("/get")
    public ProxyConfigHolder get() {
        return service.get();
    }
}
