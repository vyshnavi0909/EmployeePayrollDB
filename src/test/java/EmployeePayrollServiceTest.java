import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class EmployeePayrollServiceTest {
    @Test
    public void given3Employees_WhenWriitenToFile_ShouldMatchEmployeeEntries() {
        EmployeePayroll[] arrayOfEmployees = {
                new EmployeePayroll(1, "Babbur Vyshnavi", 400000.00),
                new EmployeePayroll(2, "Akshar Patel", 200000.00),
                new EmployeePayroll(3, "Mahesh Mahi", 300000.00)
        };
        EmployeePayrollService employeePayrollService = new EmployeePayrollService(Arrays.asList(arrayOfEmployees));
        employeePayrollService.writingData(EmployeePayrollService.IOService. FILE_IO);
        employeePayrollService.printData(EmployeePayrollService.IOService.FILE_IO);
        long numOfEntries = employeePayrollService.countEntries(EmployeePayrollService.IOService.FILE_IO);
        System.out.println("Number of entries in file are: " + numOfEntries);

        Assertions.assertEquals(3, numOfEntries);
    }

    @Test
    public void givenFile_OnReadingFromFile_ShouldMatchEmployeeCount(){
        EmployeePayrollService employeePayrollService = new EmployeePayrollService();
        employeePayrollService.readDataFromFile(EmployeePayrollService.IOService.FILE_IO);
        long numOfEntries = employeePayrollService.countEntries(EmployeePayrollService.IOService.FILE_IO);
        Assertions.assertEquals(3, numOfEntries);
    }

}
