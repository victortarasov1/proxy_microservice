package executor.service.proxy.controller;

import executor.service.proxy.model.ProxyConfigHolder;
import executor.service.proxy.source.ProxySourceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/proxy")
@RequiredArgsConstructor
public class ProxyController {

    private final ProxySourceService service;
    @GetMapping("/add")
    public void add() {
        CompletableFuture.runAsync(service::add);
    }

    @GetMapping("/get")
    public ProxyConfigHolder get() {
        return service.get();
    }
}
