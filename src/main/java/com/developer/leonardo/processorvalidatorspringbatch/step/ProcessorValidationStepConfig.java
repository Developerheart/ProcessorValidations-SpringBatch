package com.developer.leonardo.processorvalidatorspringbatch.step;

import com.developer.leonardo.processorvalidatorspringbatch.dto.Cliente;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProcessorValidationStepConfig {


    @Autowired
    private StepBuilderFactory stepBuilderFactory;


    @Bean
    public Step processorStep(
            ItemReader<Cliente> processorValidationReader,
            ItemProcessor<Cliente, Cliente> processorValidationProc,
            ItemWriter<Cliente> processorValidatorWriter) {
        return stepBuilderFactory
                .get("processorStep")
                .<Cliente, Cliente>chunk(1)
                .reader(processorValidationReader)
                .processor(processorValidationProc)
                .writer(processorValidatorWriter)
                .build();
    }

}
