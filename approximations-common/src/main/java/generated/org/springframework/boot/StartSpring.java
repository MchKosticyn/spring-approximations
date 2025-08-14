package generated.org.springframework.boot;

import generated.org.springframework.boot.testClasses.BaseTestClass;
import org.springframework.test.context.TestContextManager;

import java.lang.reflect.Method;

public class StartSpring {

    public static Class<? extends BaseTestClass> chooseTestClass() {
        throw new LinkageError();
    }

    public static void startSpring() throws Exception {
        Class<? extends BaseTestClass> testClass = chooseTestClass();
        TestContextManager testContextManager = new TestContextManager(testClass);
        BaseTestClass testClassInstance = testClass.getConstructor().newInstance();
        testContextManager.prepareTestInstance(testClassInstance);
        testContextManager.beforeTestClass();
        Method testMethod = testClass.getDeclaredMethod("fakeTest");
        testContextManager.beforeTestMethod(testClassInstance, testMethod);
        testClassInstance.configure();
        SpringMvcPerformer.perform(testClassInstance.getMockMvc());
    }
}
