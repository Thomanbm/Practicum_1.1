import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import static java.nio.file.StandardOpenOption.CREATE;

public class ProductGenerator
{
    public static void main(String[] args)
    {
        boolean doneInput = false;
        //Declare variables

        String ID = "";
        String name = "";
        String description = "";
        double cost = 0;

        //Array list
        ArrayList<String> products = new ArrayList<>();

        Scanner in = new Scanner(System.in);


        // create a loop to input the product data
        do {

            ID = SafeInput.getNonZeroLenString(in,"Enter your ID [000001]");
            name = SafeInput.getNonZeroLenString(in,"Enter your product name");
            description = SafeInput.getNonZeroLenString(in,"Enter product description");
            cost = SafeInput.getRangedDouble(in,"Enter product cost", 0,9999);

            String rec = ID + ", " + name + ", " + description + ", " + cost;
            System.out.println(rec);
            products.add(rec);

            doneInput = SafeInput.getYNConfirm(in,"Are you done? [Y/N]");
        }while(!doneInput);

        File workingDirectory = new File(System.getProperty("user.dir"));
        Path file = Paths.get(workingDirectory.getPath() + "\\src\\productList.txt");

        try
        {
            // Typical java pattern of inherited classes
            // we wrap a BufferedWriter around a lower level BufferedOutputStream
            OutputStream out =
                    new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            BufferedWriter writer =
                    new BufferedWriter(new OutputStreamWriter(out));

            // Finally can write the file LOL!

            for(String product : products)
            {
                writer.write(product, 0, product.length());  // stupid syntax for write product
                // 0 is where to start (1st char) the write
                // product. length() is how many chars to write (all)
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
