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
short experience;
byte b;
float height;
b=k.getByte("Give me Byte: ");
gender=k.getChar("What is Your Gender: ");
experience=k.getShort("How many Years experience you have: ");
salary=k.getDouble("What is Your Salary: ");
height=k.getFloat("What is Your Hieght: ");
name=k.getString("What is Your Name: ");
mobileNumber=k.getLong("What is Your Mobile Number: ");
anotherName=k.getString("What is your friend name: ");
System.out.println("I found your name is: "+name+" and your salary is: "+salary+" and your friend name is: "+anotherName+" and mob: "+mobileNumber+" , you have "+experience+" year experience and your entered byte is: "+b+" your gender is: "+gender+" and your height is: "+height+" inches");
}
}
