import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ServerLogAnalyzer {

    public static void main(String[] args) {
        Path inputPath = Path.of("src", "main", "resources", "server.log");
        Path outputDir = Path.of("output");
        Path errorPath = outputDir.resolve("errors.txt");
        Path reportPath = outputDir.resolve("report.txt");
        Path cleanLogPath = outputDir.resolve("clean.log");

        try {
            Files.createDirectories(outputDir);
            processLogFile(inputPath, errorPath, reportPath, cleanLogPath);
            System.out.println("Processing complete.");
            System.out.println("Generated files:");
            System.out.println("- " + errorPath.toAbsolutePath());
            System.out.println("- " + reportPath.toAbsolutePath());
            System.out.println("- " + cleanLogPath.toAbsolutePath());
        } catch (IOException e) {
            System.err.println("Failed to process server log: " + e.getMessage());
        }
    }

    public static void processLogFile(Path inputPath, Path errorPath, Path reportPath, Path cleanLogPath) throws IOException {
        int infoCount = 0;
        int warnCount = 0;
        int errorCount = 0;
        int totalCount = 0;

        try (
            BufferedReader reader = Files.newBufferedReader(inputPath);
            BufferedWriter errorWriter = Files.newBufferedWriter(errorPath);
            BufferedWriter reportWriter = Files.newBufferedWriter(reportPath);
            BufferedWriter cleanWriter = Files.newBufferedWriter(cleanLogPath)
        ) {
            String line;

            while ((line = reader.readLine()) != null) {
                if (line.isBlank()) {
                    continue;
                }

                String logLevel = extractLogLevel(line);

                if (logLevel != null) {
                    totalCount++;

                    switch (logLevel) {
                        case "INFO":
                            infoCount++;
                            break;
                        case "WARN":
                            warnCount++;
                            break;
                        case "ERROR":
                            errorCount++;
                            errorWriter.write(line);
                            errorWriter.newLine();
                            break;
                        default:
                            break;
                    }
                }

                String cleanedLine = removeTimestamp(line);
                cleanWriter.write(cleanedLine);
                cleanWriter.newLine();
            }

            writeReport(reportWriter, infoCount, warnCount, errorCount, totalCount);
        }
    }

    public static String extractLogLevel(String line) {
        int start = line.indexOf('[');
        int end = line.indexOf(']');

        if (start == -1 || end == -1 || end <= start) {
            return null;
        }

        return line.substring(start + 1, end).trim();
    }

    public static String removeTimestamp(String line) {
        int bracketIndex = line.indexOf('[');

        if (bracketIndex == -1) {
            return line;
        }

        return line.substring(bracketIndex).trim();
    }

    public static void writeReport(BufferedWriter writer, int infoCount, int warnCount, int errorCount, int totalCount)
            throws IOException {
        writer.write("Server Log Analysis Report");
        writer.newLine();
        writer.write("--------------------------");
        writer.newLine();
        writer.write("INFO  : " + infoCount);
        writer.newLine();
        writer.write("WARN  : " + warnCount);
        writer.newLine();
        writer.write("ERROR : " + errorCount);
        writer.newLine();
        writer.newLine();
        writer.write("Total Logs Processed: " + totalCount);
        writer.newLine();
    }
}
