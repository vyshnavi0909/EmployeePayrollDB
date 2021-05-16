import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeePayrollService {

    public  enum IOService{
        CONSOLE_IO, FILE_IO, DB_IO, REST_IO
    }

    private List<EmployeePayroll> employeePayrollList;

    public EmployeePayrollService() {

    }

    public EmployeePayrollService(List<EmployeePayroll> employeePayrollList) {
        this.employeePayrollList = employeePayrollList;
    }



    public static void main(String[] args){
        ArrayList<EmployeePayroll> employeePayrollList = new ArrayList<>();
        EmployeePayrollService employeePayrollService = new EmployeePayrollService();
        employeePayrollService.readingData();
        employeePayrollService.writingData(IOService.CONSOLE_IO);
    }

    public long countEntries(IOService fileIo) {
        if(fileIo.equals(IOService.FILE_IO)){
            return new EmployeePayrollFileIOService().countEntries();
        }
        return 0;
    }

    public void printData(IOService ioService){
        if (ioService.equals(IOService.FILE_IO)){
            new EmployeePayrollFileIOService().printDataFromFile();
        }
    }

    public void writingData(IOService fileIo){
        if (fileIo.equals(IOService.CONSOLE_IO)){
            System.out.println(employeePayrollList);
        }else if (fileIo.equals(IOService.FILE_IO)){
            new EmployeePayrollFileIOService().writeDataToFile(employeePayrollList);
        }
    }

    public List<EmployeePayroll> readDataFromFile(IOService ioService){
        if (ioService.equals(IOService.FILE_IO)){
            this.employeePayrollList = new EmployeePayrollFileIOService().readDataFromFile();
        }
//        if (ioService.equals(IOService.DB_IO)){
//            this.employeePayrollList = new EmployeePayrollDBService().readData();
//        }
        return this.employeePayrollList;
    }

    private void readingData() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Employee ID: ");
        int id = input.nextInt();
        System.out.println("Enter Employee Name: ");
        String name = input.next();
        System.out.println("Enter Employee Salary: ");
        double salary = input.nextDouble();

        employeePayrollList.add(new EmployeePayroll(id, name, salary));
    }

    public List<EmployeePayroll> readingData(IOService dbIo) {
        return null;
    }
}
