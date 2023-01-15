import com.thinking.machines.utils.*;
class psp
{
public static void main(String []args)
{
Keyboard k=new Keyboard();
String name,anotherName;
char gender;
int age;
double salary;
long mobileNumber;
salary=k.getDouble("What is Your Salary: ");
name=k.getString("What is Your Name: ");
mobileNumber=k.getLong("What is Your Mobile Number: ");
anotherName=k.getString("What is your friend name: ");
System.out.println("I found your name is: "+name+" and your salary is: "+salary+" and your friend name is: "+anotherName+" and last but not least mob: "+mobileNumber);
}
}
