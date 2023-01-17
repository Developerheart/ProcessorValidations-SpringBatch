package com.developer.leonardo.processorvalidatorspringbatch.writer;

import com.developer.leonardo.processorvalidatorspringbatch.dto.Cliente;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProcessorValidationWriterConfig {


    @Bean
    public ItemWriter<Cliente> processorValidatorWriter() {
        return clientes -> clientes.forEach(System.out::println);
    }
}
