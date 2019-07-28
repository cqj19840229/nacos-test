package com.wotrd.providerservice.controller;

import com.wotrd.nacos.common.conf.GlobalRequestBody;
import com.wotrd.nacos.common.conf.GlobalResponse;
import com.wotrd.providerservice.domain.Order;
import com.wotrd.providerservice.service.ProviderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Random;

@Slf4j
@RefreshScope
@RequestMapping("provider")
@RestController
public class ProviderController {

    @Value("${server.port}")
    private String serverPort;

    @Value("${serviceName}")
    private String serviceName;

    @Autowired
    private ProviderService providerService;

    @RequestMapping("add")
    public GlobalResponse add(@RequestBody @Valid GlobalRequestBody<Order> body) {

        return providerService.add(body.getB());

    }

    @RequestMapping("getOrders")
    public GlobalResponse getOrders() {
        return providerService.getOrders();
    }

    @RequestMapping("helloFeign")
    public String helloFeign(){

        return "hello feign， serverport："+ serverPort;
    }

    @RequestMapping("feignName")
    public String getFeignName(){

        return "hello feign， serviceName："+ serviceName;
    }

    @RequestMapping("feignRetry")
    public String feignRetry(){

        try {
            int i = new Random().nextInt(3000);
            Thread.sleep(i);
            log.info("sleep:"+i);
        } catch (InterruptedException e) {
            log.error(e.getMessage(), e);
        }
        return "hello feign， feignRetry";
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public GlobalResponse findById(@PathVariable("id") Long id){
        return providerService.getOrderById(id);
    }

}
