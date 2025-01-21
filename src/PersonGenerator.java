import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import static java.nio.file.StandardOpenOption.CREATE;

public class PersonGenerator
{

    public static void main(String[] args)
    {
        boolean doneInput = false;
        //Declare variables

        String ID = "";
        String firstName = "";
        String lastName = "";
        String title = "";
        int YOB = 0;
        String rec = "";

        //Array list
        ArrayList<String> people = new ArrayList<>();

        Scanner in = new Scanner(System.in);


        // create a loop to input the persons data
        do {

            ID = SafeInput.getNonZeroLenString(in,"Enter your ID [000001]");
            firstName = SafeInput.getNonZeroLenString(in,"Enter your first name");
            lastName = SafeInput.getNonZeroLenString(in,"Enter your last name");
            title = SafeInput.getNonZeroLenString(in,"Enter your title");
            YOB = SafeInput.getRangedInt(in,"Enter your Year of Birth", 1000,9999);

            rec = ID + ", " + firstName + ", " + lastName + ", " + title + ", " + YOB;
            System.out.println(rec);
            people.add(rec);

            doneInput = SafeInput.getYNConfirm(in,"Are you done? [Y/N]");
        }while(!doneInput);

        File workingDirectory = new File(System.getProperty("user.dir"));
        Path file = Paths.get(workingDirectory.getPath() + "\\src\\data.txt");

        try
        {
            // Typical java pattern of inherited classes
            // we wrap a BufferedWriter around a lower level BufferedOutputStream
            OutputStream out =
                    new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            BufferedWriter writer =
                    new BufferedWriter(new OutputStreamWriter(out));

            // Finally can write the file LOL!

            for(String person : people)
            {
                writer.write(person, 0, person.length());  // stupid syntax for write person
                // 0 is where to start (1st char) the write
                // person. length() is how many chars to write (all)
                writer.newLine();  // adds the new line

            }
            writer.close(); // must close the file to seal it and flush buffer
            System.out.println("Data file written!");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }
}
