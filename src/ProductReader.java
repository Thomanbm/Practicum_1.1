import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;



public class ProductReader
{
    public static void main(String[] args) {
        // Make sure GUI elements run on the EDT
        SwingUtilities.invokeLater(() -> {
            JFileChooser chooser = new JFileChooser();
            File selectedFile;
            String rec = "";
            ArrayList<String> lines = new ArrayList<>();

            final int FIELDS_LENGTH = 4;
            String id, name, description;
            double cost;


            try {
                // Set working directory to the current directory of the program
                File workingDirectory = new File(System.getProperty("user.dir"));
                chooser.setCurrentDirectory(workingDirectory);

                if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                    selectedFile = chooser.getSelectedFile();
                    Path file = selectedFile.toPath();

                    InputStream in = new BufferedInputStream(Files.newInputStream(file, StandardOpenOption.CREATE));
                    BufferedReader reader = new BufferedReader(new InputStreamReader(in));

                    int line = 0;
                    while (reader.ready()) {
                        rec = reader.readLine();
                        lines.add(rec);  // Store each line in the list
                        line++;
                        // Echo the line to the console
                        System.out.printf("\nLine %4d %-60s ", line, rec);
                    }
                    reader.close();  // Don't forget to close the file
                    System.out.println("\n\nData file read!");

                    // Process the lines
                    for (String l : lines) {
                        String[] fields = l.split(",");  // Split the record into fields

                        if (fields.length == FIELDS_LENGTH) {
                            id = fields[0].trim();
                            name = fields[1].trim();
                            description = fields[2].trim();
                            cost = Double.parseDouble(fields[3].trim());

                            System.out.printf("\n%-8s%-25s%-25s%-6.2f", id, name, description, cost);
                        }
                    }
                } else {
                    System.out.println("No file selected. Exiting...");
                    System.exit(0);
                }
            } catch (FileNotFoundException e) {
                System.out.println("File not found!!!");
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
