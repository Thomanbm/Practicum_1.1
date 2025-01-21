import javax.swing.*;
import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;

public class PersonReader2 {

    public static void main(String[] args) {
        // Make sure GUI elements run on the EDT
        SwingUtilities.invokeLater(() -> {
            JFileChooser chooser = new JFileChooser();
            File selectedFile;
            String rec = "";
            ArrayList<String> lines = new ArrayList<>();

            final int FIELDS_LENGTH = 5;
            String id, firstName, lastName, title;
            int yob;

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
                            firstName = fields[1].trim();
                            lastName = fields[2].trim();
                            title = fields[3].trim();
                            yob = Integer.parseInt(fields[4].trim());

                            System.out.printf("\n%-8s%-25s%-25s%-6s%6d", id, firstName, lastName, title, yob);
                        } else {
                            System.out.println("Found a record that may be corrupt: ");
                            System.out.println(l);
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
