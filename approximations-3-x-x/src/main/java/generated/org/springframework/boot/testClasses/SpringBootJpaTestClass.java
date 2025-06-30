package generated.org.springframework.boot.testClasses;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import stub.spring.SpringDatabases;

@AutoConfigureMockMvc
@SpringBootTest
@ExtendWith(SpringExtension.class)
// This `TestPropertySource` disables sql schemas for databases configuration
// and forces configuration via Spring JPA data classes
@TestPropertySource(properties = {
        "spring.sql.init.mode=never",
        "spring.jpa.hibernate.ddl-auto=create-drop",
        "spring.jpa.defer-datasource-initialization=true"
})
@DisabledInAotMode
public class SpringBootJpaTestClass implements BaseTestClass {

    @Autowired
    public MockMvc mockMvc;

    @Autowired
    public SessionFactory sessionFactory;

    @PersistenceContext
    public EntityManager entityManager;

    @Transactional
    @DirtiesContext
    public void fakeTest() {
    }

    @Override
    public MockMvc getMockMvc() {
        return mockMvc;
    }

    @Override
    public void configure() {
        SpringDatabases.sessionFactory = sessionFactory;
    }

    public static void ignoreResult(Object result) {
    }
}
