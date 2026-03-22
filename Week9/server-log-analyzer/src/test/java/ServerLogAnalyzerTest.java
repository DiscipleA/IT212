import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

public class ServerLogAnalyzerTest {

    @TempDir
    Path tempDir;

    @Test
    void normalCase_shouldWriteOnlyErrorsToErrorsFile() throws IOException {
        Path input = tempDir.resolve("server.log");
        Path errors = tempDir.resolve("errors.txt");
        Path report = tempDir.resolve("report.txt");
        Path clean = tempDir.resolve("clean.log");

        Files.write(input, List.of(
                "2023-10-01 10:00:00 [INFO] Server started",
                "2023-10-01 10:01:00 [ERROR] Database failure",
                "2023-10-01 10:02:00 [WARN] Slow response",
                "2023-10-01 10:03:00 [ERROR] NullPointerException"
        ), StandardCharsets.UTF_8);

        ServerLogAnalyzer.processLogFile(input, errors, report, clean);

        List<String> errorLines = Files.readAllLines(errors);
        assertEquals(2, errorLines.size());
        assertEquals("2023-10-01 10:01:00 [ERROR] Database failure", errorLines.get(0));
        assertEquals("2023-10-01 10:03:00 [ERROR] NullPointerException", errorLines.get(1));
    }

    @Test
    void normalCase_shouldGenerateCorrectReportCounts() throws IOException {
        Path input = tempDir.resolve("server.log");
        Path errors = tempDir.resolve("errors.txt");
        Path report = tempDir.resolve("report.txt");
        Path clean = tempDir.resolve("clean.log");

        Files.write(input, List.of(
                "2023-10-01 10:00:00 [INFO] A",
                "2023-10-01 10:00:01 [INFO] B",
                "2023-10-01 10:00:02 [WARN] C",
                "2023-10-01 10:00:03 [ERROR] D"
        ), StandardCharsets.UTF_8);

        ServerLogAnalyzer.processLogFile(input, errors, report, clean);

        String reportContent = Files.readString(report);
        assertTrue(reportContent.contains("INFO  : 2"));
        assertTrue(reportContent.contains("WARN  : 1"));
        assertTrue(reportContent.contains("ERROR : 1"));
        assertTrue(reportContent.contains("Total Logs Processed: 4"));
    }

    @Test
    void normalCase_shouldCreateCleanLogWithoutTimestamps() throws IOException {
        Path input = tempDir.resolve("server.log");
        Path errors = tempDir.resolve("errors.txt");
        Path report = tempDir.resolve("report.txt");
        Path clean = tempDir.resolve("clean.log");

        Files.write(input, List.of(
                "2023-10-01 10:00:00 [INFO] Server started",
                "2023-10-01 10:01:00 [WARN] CPU high"
        ), StandardCharsets.UTF_8);

        ServerLogAnalyzer.processLogFile(input, errors, report, clean);

        List<String> cleanLines = Files.readAllLines(clean);
        assertEquals("[INFO] Server started", cleanLines.get(0));
        assertEquals("[WARN] CPU high", cleanLines.get(1));
    }

    @Test
    void edgeCase_shouldHandleEmptyFile() throws IOException {
        Path input = tempDir.resolve("server.log");
        Path errors = tempDir.resolve("errors.txt");
        Path report = tempDir.resolve("report.txt");
        Path clean = tempDir.resolve("clean.log");

        Files.write(input, List.of(), StandardCharsets.UTF_8);

        ServerLogAnalyzer.processLogFile(input, errors, report, clean);

        String reportContent = Files.readString(report);
        List<String> errorLines = Files.readAllLines(errors);
        List<String> cleanLines = Files.readAllLines(clean);

        assertTrue(reportContent.contains("INFO  : 0"));
        assertTrue(reportContent.contains("WARN  : 0"));
        assertTrue(reportContent.contains("ERROR : 0"));
        assertTrue(reportContent.contains("Total Logs Processed: 0"));
        assertEquals(0, errorLines.size());
        assertEquals(0, cleanLines.size());
    }

    @Test
    void edgeCase_shouldIgnoreMalformedLineInCountsButStillWriteCleanVersion() throws IOException {
        Path input = tempDir.resolve("server.log");
        Path errors = tempDir.resolve("errors.txt");
        Path report = tempDir.resolve("report.txt");
        Path clean = tempDir.resolve("clean.log");

        Files.write(input, List.of(
                "BAD LOG LINE WITHOUT BRACKETS",
                "2023-10-01 10:01:00 [ERROR] Real error"
        ), StandardCharsets.UTF_8);

        ServerLogAnalyzer.processLogFile(input, errors, report, clean);

        String reportContent = Files.readString(report);
        List<String> cleanLines = Files.readAllLines(clean);
        List<String> errorLines = Files.readAllLines(errors);

        assertTrue(reportContent.contains("INFO  : 0"));
        assertTrue(reportContent.contains("WARN  : 0"));
        assertTrue(reportContent.contains("ERROR : 1"));
        assertTrue(reportContent.contains("Total Logs Processed: 1"));

        assertEquals("BAD LOG LINE WITHOUT BRACKETS", cleanLines.get(0));
        assertEquals("[ERROR] Real error", cleanLines.get(1));

        assertEquals(1, errorLines.size());
    }

    @Test
    void edgeCase_shouldSkipBlankLines() throws IOException {
        Path input = tempDir.resolve("server.log");
        Path errors = tempDir.resolve("errors.txt");
        Path report = tempDir.resolve("report.txt");
        Path clean = tempDir.resolve("clean.log");

        Files.write(input, List.of(
                "",
                "2023-10-01 10:00:00 [INFO] Start",
                "   ",
                "2023-10-01 10:00:01 [WARN] Warning"
        ), StandardCharsets.UTF_8);

        ServerLogAnalyzer.processLogFile(input, errors, report, clean);

        String reportContent = Files.readString(report);
        List<String> cleanLines = Files.readAllLines(clean);

        assertTrue(reportContent.contains("INFO  : 1"));
        assertTrue(reportContent.contains("WARN  : 1"));
        assertTrue(reportContent.contains("ERROR : 0"));
        assertTrue(reportContent.contains("Total Logs Processed: 2"));
        assertEquals(2, cleanLines.size());
    }
}
