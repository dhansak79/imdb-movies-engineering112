package cucumber;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes=RunCucumberTest.class)
public class SpringIntegrationTest {
  // executeGet implementation
}