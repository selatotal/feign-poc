package br.com.selat.feignpocserver.controller;

import br.com.selat.feignpocserver.contract.DelayResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/delay")
public class DelayController {

    private static final Logger logger = LoggerFactory.getLogger(DelayController.class);

    @GetMapping
    public DelayResponse delay(@RequestParam(value = "time", required = false, defaultValue = "0") Integer delay){
        try {
            Thread.sleep(delay);
            return new DelayResponse(delay);
        } catch (InterruptedException e) {
            logger.error("Error while thread sleep", e);
        }
        return new DelayResponse(500);
    }
}
