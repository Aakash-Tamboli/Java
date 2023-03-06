import java.io.*;
class CoachingStudentManager
{
private static final String DATA_FILE="StudentData.dat";
private static final String operations[]={"add","update","getAll","getByContactNumber","getByCourse"};
private static final String courses[]={"c","c++","java","python","node.js"};
// helper functions starts
private static boolean isOperationValid(String operation)
{
operation=operation.trim();
for(int i=0;i<operations.length;i++) if(operations[i].equalsIgnoreCase(operation)) return true;
return false;
}

private static boolean isCourseValid(String course)
{
course=course.trim();
for(int i=0;i<courses.length;i++) if(courses[i].equalsIgnoreCase(course)) return true;
return false;
}

private static void displayOptions()
{
for(int i=0;i<operations.length;i++) System.out.println(operations[i]);
}

private static void displayValidCourse()
{
for(int i=0;i<courses.length;i++) System.out.println(courses[i]);
}


private static void add(String []data)
{
if(data.length<5 || data.length>5)
{
System.out.println("Not Enough data to add or Too much data I only required\nMobile-Number,Name,Course-Name,Fee");
return;
}
String mobileNumber=data[1];
String name=data[2];
String course=data[3];
if(!isCourseValid(course))
{
System.out.println("Invalid Course: "+course+" valid courses are: ");
displayValidCourse();
return;
}
int fee;
try
{
fee=Integer.parseInt(data[4]);
}catch(NumberFormatException numberFormatException)
{
System.out.print("Fee should be Integer value");
return;
}
try
{
File file=new File(DATA_FILE);
RandomAccessFile randomAccessFile;
randomAccessFile=new RandomAccessFile(file,"rw");
String vMobileNumber;
String vName;
String vCourse;
String vFee;
boolean flag=false;
while(randomAccessFile.getFilePointer()<randomAccessFile.length())
{
vMobileNumber=randomAccessFile.readLine();
if(vMobileNumber.equalsIgnoreCase(mobileNumber))
{
flag=true;
}
vName=randomAccessFile.readLine();
vCourse=randomAccessFile.readLine();
vFee=randomAccessFile.readLine();
randomAccessFile.readLine();
if(flag==true)
{
System.out.printf("%s is already registered with %s which opt %s course \n(SAME MOBILE NUMBER WITH DIFFERENT STUDENT NOT ALLOWED ONE STUDENT CAN OPT ONLY ONE COURSE AT TIME\n",mobileNumber,vName,vCourse);
randomAccessFile.close();
return;
}
} // while ends
randomAccessFile.writeBytes(mobileNumber);
randomAccessFile.writeBytes("\n");
randomAccessFile.writeBytes(name);
randomAccessFile.writeBytes("\n");
randomAccessFile.writeBytes(course);
randomAccessFile.writeBytes("\n");
randomAccessFile.writeBytes(String.valueOf(fee));
randomAccessFile.close();
System.out.print(name+" is added to our database");
}catch(IOException ioException)
{
System.out.println("Something Wrong");
}
}

private static void update(String []data)
{

}

private static void remove(String []data)
{

}

private static void getAll(String []data)
{

}
private static void getByCourse(String []data)
{

}
private static void getByContactNumber(String []data)
{

}


// helper function ends
public static void main(String args[])
{
if(args.length==0)
{
System.out.println("Please Specify the Operation valid options are: ");
displayOptions();
return;
}
String operation=args[0];
if(!isOperationValid(operation))
{
System.out.println("Invalid Operation "+operation+" valid options are: ");
displayOptions();
return;
}
if(operation.equalsIgnoreCase("add"))
{
add(args);
}
else if(operation.equalsIgnoreCase("update"))
{
update(args);
}
else if(operation.equalsIgnoreCase("remove"))
{
remove(args);
}
else if(operation.equalsIgnoreCase("getAll"))
{
getAll(args);
}
else if(operation.equalsIgnoreCase("getByCourse"))
{
getByCourse(args);
}
else if(operation.equalsIgnoreCase("getByContactNumber"))
{
getByContactNumber(args);
}
} // main method ends here
}