#include <iostream>
using namespace std;

#define MAX_SIZE    20

class Employee {
    char emp_name[MAX_SIZE];
    int emp_age;
public:
    int emp_salary;

public:
    void getData(void);
    int calculate_annual_salary(int);
    void display_Record(void);

};

void Employee::getData(void)
{
    cout << "Enter employee name: ";
    cin >> emp_name;
    while(true)
    {
        cout << "Enter employee " << emp_name <<"'s age: ";
        cin >> emp_age;
        if(emp_age < 18) cout << "Invalid Age, should be more than 18 years old." << endl;
        else break;
    }
    while(true)
    {
        cout << "Enter employee " << emp_name <<"'s salary: ";
        cin >> emp_salary;
        if(emp_salary < 10000 || emp_salary > 1500000) cout << "Invalid salary, should be between 10000-1500000 years old." << endl;
        else break;
    }
}

int Employee::calculate_annual_salary(int emp_salary)
{
    return emp_salary*12;
}

void Employee::display_Record(void)
{
    cout << "Employee Info\n\tName: " << emp_name <<endl;
    cout << "\tAge: " << emp_age <<endl;
    cout << "\tSalary: " << emp_salary <<endl;
}

int main(void)
{
    Employee emp;
    emp.getData();
    emp.display_Record();
    cout << "Annual salary: " << emp.calculate_annual_salary(emp.emp_salary);
    return 0;
}
