package dev.dsf.process.tutorial.service;

import dev.dsf.bpe.v1.ProcessPluginApi;
import dev.dsf.bpe.v1.activity.AbstractServiceDelegate;
import dev.dsf.bpe.v1.variables.Variables;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.hl7.fhir.r4.model.StringType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;


public class DicTask extends AbstractServiceDelegate {

    private static final Logger logger = LoggerFactory.getLogger(DicTask.class);

    private boolean loggingEnabeled;

    public DicTask(ProcessPluginApi api, boolean loggingEnabeled) {
        super(api);
        this.loggingEnabeled = loggingEnabeled;
    }

    @Override
    protected void doExecute(DelegateExecution execution, Variables variables) {
        //Add a log message to the DicTask#doExecute method that logs the recipient organization identifier from the start FHIR Task resource.
        if (loggingEnabeled) {
            logger.info("organization with identifier: " +
                    variables.getStartTask().getRequester().getIdentifier().getValue());

            List<StringType> types = api.getTaskHelper().getInputParameterValues(variables.getStartTask(),
                    "http://dsf.dev/fhir/CodeSystem/tutorial", "tutorial-input", StringType.class).toList();

            types.forEach(e -> logger.info("organization with identifier: " + e.getValue()));

            Optional<String> t = api.getTaskHelper().getFirstInputParameterStringValue(variables.getStartTask(),
                    "http://dsf.dev/fhir/CodeSystem/tutorial", "tutorial-input");

            t.ifPresent(s -> logger.info("organization with identifier: " + s));


        } else System.out.println("DAS IST KEINE LOGGER!");
    }
}
