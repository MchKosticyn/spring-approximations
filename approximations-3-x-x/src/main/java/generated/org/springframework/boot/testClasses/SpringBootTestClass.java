package generated.org.springframework.boot.testClasses;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

@AutoConfigureMockMvc
@SpringBootTest
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
public class SpringBootTestClass implements BaseTestClass {

    @Autowired
    public MockMvc mockMvc;

    @DirtiesContext
    public void fakeTest() {
    }

    @Override
    public MockMvc getMockMvc() {
        return mockMvc;
    }

    @Override
    public void configure() {
    }

    public static void ignoreResult(Object result) {
    }
}
