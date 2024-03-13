package dev.dsf.process.tutorial.service;

import org.camunda.bpm.engine.delegate.DelegateExecution;

import dev.dsf.bpe.v1.ProcessPluginApi;
import dev.dsf.bpe.v1.activity.AbstractServiceDelegate;
import dev.dsf.bpe.v1.variables.Variables;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class DicTask extends AbstractServiceDelegate {

    private static final Logger logger = LoggerFactory.getLogger(DicTask.class);

    private boolean loggingEnabled;

    public DicTask(ProcessPluginApi api, boolean loggingEnabled) {
        super(api);
        this.loggingEnabled = loggingEnabled;
    }

    @Override
    protected void doExecute(DelegateExecution execution, Variables variables) {
        //Add a log message to the DicTask#doExecute method that logs the recipient organization identifier from the start FHIR Task resource.
        if (loggingEnabled)
            logger.info("organization with identifier: " +
                    variables.getStartTask().getRequester().getIdentifier().getValue());
        else System.out.println("DAS IST KEINE LOGGER!");
    }
}
