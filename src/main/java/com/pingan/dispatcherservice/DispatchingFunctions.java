package com.pingan.dispatcherservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Flux;

import java.util.function.Function;

@Configuration
public class DispatchingFunctions {
    private static final Logger logger = LoggerFactory.getLogger(DispatchingFunctions.class);

    //实现订单打包业务逻辑的函数
    @Bean
    public Function<OrderAcceptedMessage, Long> pack(){
        return orderAcceptedMessage -> { //以 OrderAcceptedMessage对象作为输入
            logger.info("The order with id{} is packed.", orderAcceptedMessage.orderId());
            return orderAcceptedMessage.orderId(); //返回订单标识符（Long 类型）作为输出
        };
    }
    @Bean
    public Function<Flux<Long>, Flux<OrderDispatchedMessage>> label(){
        return orderFlux -> orderFlux.map(orderId -> {
            logger.info("The order with id {} is labeled.", orderId);
            return new OrderDispatchedMessage(orderId);
        });
    }
}
