import java.util.Objects;

public class Person
{
    /*

     */

    private   String ID = "";
    private String firstName = "";
    private String lastName = "";
    private  String title = "";
    private int YOB = 0;


    public Person(String firstName, String ID, String lastName, String title, int YOB) {
        this.firstName = firstName;
        this.ID = ID;
        this.lastName = lastName;

        this.title = title;
        this.YOB = YOB;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYOB() {
        return YOB;
    }

    public void setYOB(int YOB) {
        this.YOB = YOB;
    }

    public String getfullName()
    {
        return firstName + " " + lastName;
    }
    public String getFormalName()
    {
        return title + " " + getfullName();
    }
    public String toCSV()
    {
        return ID + " " + firstName + " " + lastName + " " + title + " " + YOB;
    }

    @Override
    public String toString() {
        return "Person{" +
                ", ID='" + ID + '\'' +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", title='" + title + '\'' +
                ", YOB=" + YOB +

                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return YOB == person.YOB && Objects.equals(ID, person.ID) && Objects.equals(firstName, person.firstName) && Objects.equals(lastName, person.lastName) && Objects.equals(title, person.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, firstName, lastName, title, YOB);
    }


}
