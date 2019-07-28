package com.wotrd.feignservice.service;

import com.wotrd.feignservice.domain.Order;
import com.wotrd.feignservice.service.fallback.ProviderfallbackFactory;
import com.wotrd.nacos.common.conf.GlobalRequestBody;
import com.wotrd.nacos.common.conf.GlobalResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * fallback配置后，会使用默认的fallbackFactory，配置的factory不会生效。
 * 只使用fallback没有异常返回信息，可以在factory中返回fallback
 */
@FeignClient(name = "provider-service", fallbackFactory = ProviderfallbackFactory.class)
public interface IProviderService {

    @RequestMapping("provider/add")
    GlobalResponse addOrer(@RequestBody GlobalRequestBody<Order> body);

    @RequestMapping("provider/getOrders")
    GlobalResponse getOrders();

    @RequestMapping("provider/helloFeign")
    String helloFeign();

    @RequestMapping("provider/feignRetry")
    String feignRetry();


    @RequestMapping(value = "/{id}")
    GlobalResponse findById(@PathVariable("id") Long id);


}

