package com.developer.leonardo.processorvalidatorspringbatch.processor;

import com.developer.leonardo.processorvalidatorspringbatch.dto.Cliente;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.support.builder.CompositeItemProcessorBuilder;
import org.springframework.batch.item.validator.BeanValidatingItemProcessor;
import org.springframework.batch.item.validator.ValidatingItemProcessor;
import org.springframework.batch.item.validator.ValidationException;
import org.springframework.batch.item.validator.Validator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashSet;
import java.util.Set;

@Configuration
public class ProcessorValidationProcessorConfig {

    private final Set<String> emails = new HashSet<>();

    @Bean
    public ItemProcessor<Cliente, Cliente> processorValidationProc() throws Exception {
        return new CompositeItemProcessorBuilder<Cliente, Cliente>()
                .delegates(validatingItemProcessor(), beanValidatingItemProcessor())
                .build();
    }

    private ValidatingItemProcessor<Cliente> validatingItemProcessor() throws Exception {
        ValidatingItemProcessor<Cliente> validatingItemProcessor = new ValidatingItemProcessor<Cliente>(); // criando de forma manual e customizada
        validatingItemProcessor.setValidator(validator());
        validatingItemProcessor.setFilter(true);
        return validatingItemProcessor;
    }

    private BeanValidatingItemProcessor<Cliente> beanValidatingItemProcessor() throws Exception {
        BeanValidatingItemProcessor<Cliente> beanValidatingItemProcessor = new BeanValidatingItemProcessor<>(); // possui validator pelo spring
        beanValidatingItemProcessor.setFilter(true);
        beanValidatingItemProcessor.afterPropertiesSet();
        return beanValidatingItemProcessor;
    }

    private Validator<Cliente> validator() {
        return new Validator<Cliente>() {
            @Override
            public void validate(Cliente cliente) throws ValidationException {
                if (emails.contains(cliente.getEmail()))
                    throw new ValidationException("Email já salvo na base de dados -" + cliente.getEmail());
                emails.add(cliente.getEmail());
            }
        };
    }

}
