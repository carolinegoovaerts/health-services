package nl.goovaerts.web;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PageControllerTest {

    private PageController pageController;

    private static void AssertModelAttribute(ModelStub model, String attribute) {
        Assertions.assertNotNull(model.asMap().get(attribute), attribute);
    }

    @BeforeEach
    void setUp() {
        pageController = new PageController();
    }

    @Test
    void shouldReturnExpectedTemplateName() {
        String templateName = pageController.catchAll(new ModelStub());
        Assertions.assertEquals("default", templateName);
    }

    @Test
    void shouldAddContentAttributesToModel() {
        ModelStub model = new ModelStub();

        pageController.catchAll(model);

        AssertModelAttribute(model, "language");
        AssertModelAttribute(model, "title");
    }
}
