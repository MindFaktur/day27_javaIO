import jdk.nashorn.internal.runtime.JSONFunctions;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmpPayService
{
    private static Scanner SC = new Scanner(System.in);
    private static List<EmpValues> listOfEmp = new ArrayList<>();

    public static void main(String[] args)
    {
        empOperations();
        FileOperations.fileChecker("javaIO/src/empDetails.txt");
        FileOperations.fileDeleter("javaIO/src/empDetails.txt");
        FileOperations.createDirectory(Paths.get("javaIO/src/new"));
        FileOperations.createEmptyFile("javaIO/src/new/new.txt");
        FileOperations.listEverythingInGivenDirectory(Paths.get("javaIO/src"));

    }

    public static void empOperations()
    {
        EmpValues EV = new EmpValues();
        System.out.println("Please enter employee id");
        EV.empId = SC.nextInt();
        System.out.println("Please enter employee name");
        EV.empName = SC.next();
        System.out.println("Please enter employee salary");
        EV.empSalary = SC.nextDouble();

        try
        {
            //File obj = new File("javaIO/src/empDetails.txt");
            FileWriter fileWriter = new FileWriter("javaIO/src/empDetails.txt");
            fileWriter.write(String.valueOf(EV.empId) + " ");
            fileWriter.write(EV.empName + " ");
            fileWriter.write(String.valueOf(EV.empSalary));
            listOfEmp.add(EV);
            fileWriter.write("\n" + String.valueOf(listOfEmp));
            fileWriter.close();

        }
        catch(IOException e)
        {
            System.out.println(e);
        }

        try
        {
            FileReader fileReader = new FileReader("javaIO/src/empDetails.txt");
            Scanner reader = new Scanner(fileReader);
            while( reader.hasNext() )
            {
                System.out.println(reader.next());
            }
        }
        catch(IOException e)
        {
            System.out.println(e);
        }

    }
}


class EmpValues
{

    int empId;
    double empSalary;
    String empName;

    @Override
    public String toString()
    {
        return "{" +
                " empID : " + empId +
                ", empName : " + empName +
                ", empSalary : " + empSalary +
                " }";
    }

}
