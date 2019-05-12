package org.outerj.daisy.diff.html;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import static org.junit.Assert.assertTrue;

public class SuperLongHtmlTest {


    @Test
    public void testThis() throws Exception {

        String oldText = this.readLineByLineJava8("src/test/resources/testdata/sec-key-keycorp-10q-2018-november-01.html");
        String newText = this.readLineByLineJava8("src/test/resources/testdata/sec-key-keycorp-10q-2019-may-03.html");

        String result = HtmlTestFixture.diff(oldText, newText);
        writeFile("/tmp/output.html", result);

        assertTrue("Expected a change",result.indexOf("diff-html-changed") > -1);

    }

    public String readLineByLineJava8(String filePath) {
        StringBuilder contentBuilder = new StringBuilder();
        try (Stream<String> stream = Files.lines(Paths.get(filePath), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s).append("\n"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contentBuilder.toString();
    }

    public void writeFile(String filePath, String output) throws FileNotFoundException {
        try (PrintWriter out = new PrintWriter(filePath)) {
            out.println(output);
        }
    }

}
