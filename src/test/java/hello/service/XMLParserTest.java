package hello.service;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

public class XMLParserTest {

    @Test
    public void testToPrettyXml_ValidXml() {
        String inputXml = "<root><child>value</child></root>";
        byte[] expectedOutput = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<root>\n    <child>value</child>\n</root>\n".getBytes();
        byte[] actualOutput = XMLParser.toPrettyXml(inputXml.getBytes());
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testToPrettyXml_EmptyElement() {
        String inputXml = "<root><child></child></root>";
        byte[] expectedOutput = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<root>\n    <child></child>\n</root>\n".getBytes();
        byte[] actualOutput = XMLParser.toPrettyXml(inputXml.getBytes());
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testToPrettyXml_InvalidXml() {
        String inputXml = "<root><child></root>";
        Executable executable = () -> XMLParser.toPrettyXml(inputXml.getBytes());
        assertThrows(Exception.class, executable);
    }

    @Test
    public void testToPrettyXml_EmptyInput() {
        String inputXml = "";
        byte[] expectedOutput = "".getBytes();
        byte[] actualOutput = XMLParser.toPrettyXml(inputXml.getBytes());
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testToPrettyXml_MalformedXml_ExtraClosingTag() {
        String inputXml = "<root><child></child></root></root>";
        Executable executable = () -> XMLParser.toPrettyXml(inputXml.getBytes());
        assertThrows(Exception.class, executable);
    }

    @Test
    public void testToPrettyXml_MalformedXml_MissingOpeningTag() {
        String inputXml = "<root><child></child>";
        Executable executable = () -> XMLParser.toPrettyXml(inputXml.getBytes());
        assertThrows(Exception.class, executable);
    }

    @Test
    public void testToPrettyXml_MalformedXml_EmptyRoot() {
        String inputXml = "<>";
        Executable executable = () -> XMLParser.toPrettyXml(inputXml.getBytes());
        assertThrows(Exception.class, executable);
    }
}