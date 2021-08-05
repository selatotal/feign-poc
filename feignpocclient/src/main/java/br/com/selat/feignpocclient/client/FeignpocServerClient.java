package br.com.selat.feignpocclient.client;

import br.com.selat.feignpocclient.contract.DelayResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "feignpocserverclient", url = "http://localhost:8080")
public interface FeignpocServerClient {

    @GetMapping("/delay")
    DelayResponse delay(@RequestParam(value = "time", required = false, defaultValue = "0") Integer delay);
}
