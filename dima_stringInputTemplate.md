#TODO: http://dsf.dev tauschen mit dem eigenen Projekt

#StructureDefinition 
```xml
        <element id="Task.input:<DESCRIPTOR_CODE>.type">
            <path value="Task.input.type" />
            <binding>
                <extension url="http://hl7.org/fhir/StructureDefinition/elementdefinition-bindingName">
                    <valueString value="TaskInputParameterType" />
                </extension>
                <strength value="required" />
                <valueSet value="http://dsf.dev/fhir/ValueSet/<NAME_OF_TASK_VALUE_SET>|#{version}" /> <!-- Ein VALUE_SET muss für den Input-Parameter exisiteren --> 
            </binding>
        </element>
        <element id="Task.input:<DESCRIPTOR_CODE>.type.coding">
            <path value="Task.input.type.coding" />
            <min value="1" />
            <max value="1" />
        </element>
        <element id="Task.input:target-endpoints.type.coding.system">
            <path value="Task.input.type.coding.system" />
            <min value="1" />
            <fixedUri value="http://dsf.dev/fhir/CodeSystem/<NAME_OF_TASK_CODE_SYSTEM>" /> <!-- Ein CODE_SYSTEM muss für den Input-Parameter exisiteren -->
        </element>
        <element id="Task.input:<DESCRIPTOR_CODE>.type.coding.code">
            <path value="Task.input.type.coding.code" />
            <min value="1" />
            <fixedCode value="<DESCRIPTOR_CODE>" />
        </element>
        <element id="Task.input:<DESCRIPTOR_CODE>.value[x]">
            <path value="Task.input.value[x]" />
            <type>
                <code value="string" />
            </type>
        </element>
```

#CodeSystem:
```xml
<CodeSystem xmlns="http://hl7.org/fhir">
    <meta>
        <tag>
            <system value="http://dsf.dev/fhir/CodeSystem/read-access-tag"/>
            <code value="ALL"/>
        </tag>
    </meta>
    <url value="http://dsf.dev/fhir/CodeSystem/<ID/URL_OF_VALUE_SET/ID/URL_CODE_SYSTEM>"/>       <!--  Aufgabe 2.5  -->
    <!-- version managed by bpe -->
    <version value="#{version}"/>
    <name value="My CodeSystem"/>      <!--dummy value-->
    <title value="My CodeSystem Title"/>       <!--dummy value-->
    <!-- status managed by bpe -->
    <status value="unknown"/>
    <experimental value="false"/>
    <!-- date managed by bpe -->
    <date value="#{date}"/>
    <publisher value="DSF"/>       <!--dummy value-->
    <description value="CodeSystem with codes for me"/>        <!--dummy value-->
    <caseSensitive value="true"/>
    <hierarchyMeaning value="grouped-by"/>
    <versionNeeded value="false"/>
    <content value="complete"/>
    <concept>
        <code value="<DESCRIPTOR_CODE>"/>        <!--  Aufgabe 2.5  -->
        <display value="Input Display"/>     <!--dummy value-->
        <definition value="The Input Display"/>      <!--dummy value-->
    </concept>
</CodeSystem>
```

#ValueSet:
```xml
<ValueSet xmlns="http://hl7.org/fhir">
    <meta>
        <tag>
            <system value="http://dsf.dev/fhir/CodeSystem/read-access-tag"/>
            <code value="ALL"/>
        </tag>
    </meta>
    <url value="http://dsf.dev/fhir/ValueSet/<ID/URL_OF_VALUE_SET/ID/URL_CODE_SYSTEM>"/>    <!--dummy value-->
    <!-- version managed by bpe -->
    <version value="#{version}"/>
    <name value="My ValueSet"/>     <!--dummy value-->
    <title value="My ValueSet Title"/>  <!--dummy value-->
    <!-- status managed by bpe -->
    <status value="unknown"/>
    <experimental value="false"/>
    <!-- date managed by bpe -->
    <date value="#{date}"/>
    <publisher value="DSF"/>    <!--dummy value-->
    <description value="ValueSet with all codes from my-code-system"/>      <!--dummy value-->
    <immutable value="true"/>
    <compose>
        <include>
            <system value="http://dsf.dev/fhir/CodeSystem/<ID/URL_OF_VALUE_SET/ID/URL_CODE_SYSTEM>"/>     <!--dummy value-->
            <version value="#{version}"/>
            <concept>
                <code value="<DESCRIPTOR_CODE>"/>
                <display value="Input Display"/>
            </concept>
        </include>
    </compose>
</ValueSet>
```
