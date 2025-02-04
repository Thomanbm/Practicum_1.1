import java.util.Scanner;

public class PersonDemo
{
    public static void main(String[] args)
    {
    Scanner in = new Scanner(System.in);
    SafeInputOBJ sio = new SafeInputOBJ(in);

        Person boy = new Person("Bill","000001", "Bailey", "Dr", 1942);
        Person girl = new Person ("Sally", "000002","Smith", "Dr", 1952);

        System.out.println(boy.getfullName());
        System.out.println(girl.getFormalName());
        System.out.println(girl.toCSV());
        String id = sio.getNonZeroLenString("Enter your ID");
        System.out.println("ID is " + id);
    }

}
