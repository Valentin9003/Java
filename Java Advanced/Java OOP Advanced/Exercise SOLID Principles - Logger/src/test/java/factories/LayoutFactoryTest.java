package factories;

import interfaces.Layout;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LayoutFactoryTest {

    private final String SIMPLE_LAYOUT_TYPE = "SimpleLayout";
    private final String XML_LAYOUT_TYPE = "XmlLayout";
    private final String WRRONG_LAYOUT_TYPE = "SomeoneLayout";

    @Test
    public void createSimpleLayoutTest() {
        Layout layout = LayoutFactory.create(SIMPLE_LAYOUT_TYPE);

        Assert.assertTrue(layout != null
                && layout.getClass().getSimpleName().equals(SIMPLE_LAYOUT_TYPE));
    }

    @Test
    public void createXmlLayoutTest() {
        Layout layout = LayoutFactory.create(XML_LAYOUT_TYPE);

        Assert.assertTrue(layout != null
                && layout.getClass().getSimpleName().equals(XML_LAYOUT_TYPE));
    }

    @Test
    public void createNullTest() {
        Layout layout = LayoutFactory.create(WRRONG_LAYOUT_TYPE);

        Assert.assertTrue(layout == null);
    }
}