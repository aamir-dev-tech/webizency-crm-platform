package com.webizency.crm.api_gateway.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Component
public class CorrelationIdGlobalFilter implements GlobalFilter, Ordered {

    private static final Logger log =
            LoggerFactory.getLogger(CorrelationIdGlobalFilter.class);

    @Override
    public Mono<Void> filter(
            ServerWebExchange exchange,
            GatewayFilterChain chain) {

        String correlationId = exchange.getRequest()
                .getHeaders()
                .getFirst(CorrelationIdConstants.HEADER_NAME);

        if (!isValidCorrelationId(correlationId)) {
            correlationId = UUID.randomUUID().toString();
        }

        final String finalCorrelationId = correlationId;

        ServerHttpRequest mutatedRequest = exchange.getRequest()
                .mutate()
                .header(
                        CorrelationIdConstants.HEADER_NAME,
                        finalCorrelationId
                )
                .build();

        ServerWebExchange mutatedExchange = exchange
                .mutate()
                .request(mutatedRequest)
                .build();

        mutatedExchange.getResponse()
                .getHeaders()
                .set(
                        CorrelationIdConstants.HEADER_NAME,
                        finalCorrelationId
                );

        log.info(
                "Incoming request: method={}, path={}, correlationId={}",
                exchange.getRequest().getMethod(),
                exchange.getRequest().getURI().getPath(),
                finalCorrelationId
        );

        return chain.filter(mutatedExchange)
                .doFinally(signalType ->
                        log.info(
                                "Completed request: method={}, path={}, correlationId={}, signal={}",
                                exchange.getRequest().getMethod(),
                                exchange.getRequest().getURI().getPath(),
                                finalCorrelationId,
                                signalType
                        )
                );
    }

    private boolean isValidCorrelationId(String correlationId) {

        if (correlationId == null || correlationId.isBlank()) {
            return false;
        }

        if (correlationId.length() > 100) {
            return false;
        }

        try {
            UUID.fromString(correlationId);
            return true;
        } catch (IllegalArgumentException ex) {
            return false;
        }
    }

    @Override
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE;
    }
}
