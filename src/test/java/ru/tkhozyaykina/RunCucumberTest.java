package ru.tkhozyaykina;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/features",
        glue = "ru.tkhozyaykina",
        tags = "@test",
        snippets = SnippetType.CAMELCASE
)
public class RunCucumberTest {

}