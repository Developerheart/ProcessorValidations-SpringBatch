package com.developer.leonardo.processorvalidatorspringbatch.processor;

import com.developer.leonardo.processorvalidatorspringbatch.dto.Cliente;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProcessorValidationProcessorConfig {


    @Bean
    public ItemProcessor<Cliente, Cliente> processorValidationProc() {
        return cliente -> cliente;
    }

}
