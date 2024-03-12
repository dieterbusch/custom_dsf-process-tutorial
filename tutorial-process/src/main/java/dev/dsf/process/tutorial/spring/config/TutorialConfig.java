package dev.dsf.process.tutorial.spring.config;

import dev.dsf.process.tutorial.service.DicTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dev.dsf.bpe.v1.ProcessPluginApi;
import dev.dsf.fhir.authorization.read.ReadAccessHelper;
import org.springframework.context.annotation.Scope;

@Configuration
public class TutorialConfig {

    @Autowired
    private ProcessPluginApi api;

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public DicTask dicTask() {
        return new DicTask(api);
    }

}
