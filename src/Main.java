import java.util.ArrayList;
import java.util.Scanner;
public class Main
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



    }
}
