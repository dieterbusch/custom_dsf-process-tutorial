package dev.dsf.process.tutorial;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import dev.dsf.bpe.v1.ProcessPluginDefinition;
import dev.dsf.process.tutorial.spring.config.TutorialConfig;

public class TutorialProcessPluginDefinition implements ProcessPluginDefinition {
    public static final String VERSION = "1.0.0.1";
    public static final LocalDate RELEASE_DATE = LocalDate.of(2022, 8, 21);
    public static final String ORGANIZATION = "1337";

    @Override
    public String getName() {
        return "dsf-process-tutorial";
    }

    @Override
    public String getVersion() {
        return VERSION;
    }

    @Override
    public LocalDate getReleaseDate() {
        return RELEASE_DATE;
    }

    @Override
    public List<String> getProcessModels() {

        return List.of("bpe/dic-process.bpmn");
    }

    @Override
    public Map<String, List<String>> getFhirResourcesByProcessId() {

        String aDicProcess = "fhir/ActivityDefinition/dic-process.xml";
        String sTaskDicProcess = "fhir/StructureDefinition/task-start-dic-process.xml";

        String draftTaskDicProcess = "fhir/Task/task-start-dic-process.xml";

        return Map.of(ConstantsTutorial.PROCESS_NAME_FULL_DIC, List.of(aDicProcess, sTaskDicProcess, draftTaskDicProcess));
    }

    @Override
    public List<Class<?>> getSpringConfigurations() {
        return List.of(TutorialConfig.class);
    }


}
