import java.io.*;
class CoachingStudentManager
{
private static final String DATA_FILE="StudentData.dat";
private static final String operations[]={"add","update","getAll","getByContactNumber","getByCourse","remove"};
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
randomAccessFile.writeBytes("\n");
randomAccessFile.close();
System.out.print(name+" is added to our database");
}catch(IOException ioException)
{
System.out.println("Something Wrong");
}
}

private static void update(String []data)
{
if(data.length!=5)
{
System.out.println("Wrong number of elements passed for updation");
System.out.println("Usage : java CoachingStudentManager update mobile_number name course fee");
return;
}
String mobileNumber=data[1];
String name=data[2];
String course=data[3];
if(!isCourseValid(course))
{
System.out.println("Invalid course : "+course);
displayValidCourse();
return;
}
int fee;
try
{
fee=Integer.parseInt(data[4]);
}catch(NumberFormatException numberFormatException)
{
System.out.println("Fee should be integer");
return;
}
try
{
File file=new File(DATA_FILE);
if(file.exists()==false)
{
System.out.println("Invalid contact number: "+mobileNumber);
return;
}
RandomAccessFile randomAccessFile;
randomAccessFile=new RandomAccessFile(file,"rw");
if(randomAccessFile.length()==0)
{
randomAccessFile.close();
System.out.println("Invalid contact number: "+mobileNumber);
return;
}
boolean found=false;
String vMobileNumber="";
String vName="";
String vCourse="";
int vFee=0;
while(randomAccessFile.getFilePointer()<randomAccessFile.length())
{
vMobileNumber=randomAccessFile.readLine();
vName=randomAccessFile.readLine();
vCourse=randomAccessFile.readLine();
vFee=Integer.parseInt(randomAccessFile.readLine());
if(vMobileNumber.equalsIgnoreCase(mobileNumber))
{
found=true;
break;
}
}
if(found==false)
{
System.out.println("Invalid contact number :"+mobileNumber);
randomAccessFile.close();
return;
}
System.out.println("Updating data of : "+mobileNumber);
System.out.println("Name of Candidate is : "+vName);
File tmpFile=new File("tmp.tmp");
RandomAccessFile tmpRandomAccessFile;
tmpRandomAccessFile=new RandomAccessFile(tmpFile,"rw");
tmpRandomAccessFile.setLength(0);
randomAccessFile.seek(0);
while(randomAccessFile.getFilePointer()<randomAccessFile.length())
{
vMobileNumber=randomAccessFile.readLine();
vName=randomAccessFile.readLine();
vCourse=randomAccessFile.readLine();
vFee=Integer.parseInt(randomAccessFile.readLine());
if(vMobileNumber.equalsIgnoreCase(mobileNumber)==false)
{
tmpRandomAccessFile.writeBytes(vMobileNumber+"\n");
tmpRandomAccessFile.writeBytes(vName+"\n");
tmpRandomAccessFile.writeBytes(vCourse+"\n");
tmpRandomAccessFile.writeBytes(vFee+"\n");
}
else
{
tmpRandomAccessFile.writeBytes(mobileNumber+"\n");
tmpRandomAccessFile.writeBytes(name+"\n");
tmpRandomAccessFile.writeBytes(course+"\n");
tmpRandomAccessFile.writeBytes(fee+"\n");
}
}
randomAccessFile.seek(0);
tmpRandomAccessFile.seek(0);
while(tmpRandomAccessFile.getFilePointer()<tmpRandomAccessFile.length())
{
randomAccessFile.writeBytes(tmpRandomAccessFile.readLine()+"\n");
}
randomAccessFile.setLength(tmpRandomAccessFile.length());
tmpRandomAccessFile.setLength(0);
randomAccessFile.close();
tmpRandomAccessFile.close();
System.out.println("Data Updated");
}catch(IOException ioException)
{
System.out.println("OOPS some internal problem");
}
}

private static void remove(String []data)
{
if(data.length!=2)
{
System.out.println("Wrong number of elements passed for removal");
System.out.println("Usage : java CoachingStudentManager remove mobile_number");
return;
}
String mobileNumber=data[1];
int fee;
try
{
File file=new File(DATA_FILE);
if(file.exists()==false)
{
System.out.println("Invalid contact number: "+mobileNumber);
return;
}
RandomAccessFile randomAccessFile;
randomAccessFile=new RandomAccessFile(file,"rw");
if(randomAccessFile.length()==0)
{
randomAccessFile.close();
System.out.println("Invalid contact number: "+mobileNumber);
return;
}
boolean found=false;
String vMobileNumber="";
String vName="";
String vCourse="";
int vFee=0;
while(randomAccessFile.getFilePointer()<randomAccessFile.length())
{
vMobileNumber=randomAccessFile.readLine();
vName=randomAccessFile.readLine();
vCourse=randomAccessFile.readLine();
vFee=Integer.parseInt(randomAccessFile.readLine());
if(vMobileNumber.equalsIgnoreCase(mobileNumber))
{
found=true;
break;
}
}
if(found==false)
{
System.out.println("Invalid contact number :"+mobileNumber);
randomAccessFile.close();
return;
}
System.out.println("Deleting data of : "+mobileNumber);
System.out.println("Name of Candidate is : "+vName);
File tmpFile=new File("tmp.tmp");
RandomAccessFile tmpRandomAccessFile;
tmpRandomAccessFile=new RandomAccessFile(tmpFile,"rw");
tmpRandomAccessFile.setLength(0);
randomAccessFile.seek(0);
while(randomAccessFile.getFilePointer()<randomAccessFile.length())
{
vMobileNumber=randomAccessFile.readLine();
vName=randomAccessFile.readLine();
vCourse=randomAccessFile.readLine();
vFee=Integer.parseInt(randomAccessFile.readLine());
if(vMobileNumber.equalsIgnoreCase(mobileNumber)==false)
{
tmpRandomAccessFile.writeBytes(vMobileNumber+"\n");
tmpRandomAccessFile.writeBytes(vName+"\n");
tmpRandomAccessFile.writeBytes(vCourse+"\n");
tmpRandomAccessFile.writeBytes(vFee+"\n");
}
}
randomAccessFile.seek(0);
tmpRandomAccessFile.seek(0);
while(tmpRandomAccessFile.getFilePointer()<tmpRandomAccessFile.length())
{
randomAccessFile.writeBytes(tmpRandomAccessFile.readLine()+"\n");
}
randomAccessFile.setLength(tmpRandomAccessFile.length());
tmpRandomAccessFile.setLength(0);
randomAccessFile.close();
tmpRandomAccessFile.close();
System.out.println("Data Deleted");
}catch(IOException ioException)
{
System.out.println("OOPS some internal problem");
}
}

private static void getAll(String []data)
{
try
{
File file=new File(DATA_FILE);
if(file.exists()==false)
{
System.out.println("No Student");
return;
}
RandomAccessFile randomAccessFile;
randomAccessFile=new RandomAccessFile(file,"rw");
if(randomAccessFile.length()==0)
{
// it means file is empty may be because of data is delete from the file.
randomAccessFile.close();
System.out.println("No Student");
return;
}
String name;
String mobileNumber;
String course;
int fee;
int totalStudent=0;
int totalFee=0;
while(randomAccessFile.getFilePointer()<randomAccessFile.length())
{
mobileNumber=randomAccessFile.readLine();
name=randomAccessFile.readLine();
course=randomAccessFile.readLine();
fee=Integer.parseInt(randomAccessFile.readLine());
System.out.printf("%s, %s, %s, %d\n",mobileNumber,name,course,fee);
totalStudent++;
totalFee+=fee;
}// while bracess ends
System.out.println("Total Registration: "+totalStudent);
System.out.println("Total fee collected: "+totalFee);
}catch(IOException ioException)
{
System.out.println("Something Wrong");
}
}

private static void getByCourse(String []data)
{
if(data.length!=2)
{
System.out.println("Invalid");
System.out.println("Usage: java CoachingStudentManager getByCourse and courses are: ");
displayValidCourse();
return;
}
String course=data[1];
if(isCourseValid(course)==false)
{
System.out.println("Invalid course: "+course);
return;
}
try
{
File file=new File(DATA_FILE);
if(file.exists()==false)
{
System.out.println("No registration against this course: "+course);
return;
}
RandomAccessFile randomAccessFile;
randomAccessFile=new RandomAccessFile(file,"rw");
if(randomAccessFile.length()==0)
{
System.out.println("No registration against: "+course);
randomAccessFile.close();
return;
}
String vMobileNumber="";
String vName="";
String vCourse="";
int totalStudentCount=0;
int totalFeeCount=0;
int vFee=0;
boolean found=false;
while(randomAccessFile.getFilePointer()<randomAccessFile.length())
{
vMobileNumber=randomAccessFile.readLine();
vName=randomAccessFile.readLine();
vCourse=randomAccessFile.readLine();
vFee=Integer.parseInt(randomAccessFile.readLine());
if(course.equalsIgnoreCase(vCourse))
{
System.out.println("Contact Number: "+vMobileNumber);
System.out.println("Name: "+vName);
System.out.println("Course: "+vCourse);
System.out.println("Fee: "+vFee);
totalStudentCount++;
totalFeeCount+=vFee;
found=true;
}
}
randomAccessFile.close();
if(found==false)
{
System.out.println("No registration against this course"+course);
return;
}
else
{
System.out.println("Total student registerd : "+totalStudentCount);
System.out.println("Total fee collected : "+totalFeeCount);
}
}catch(IOException ioException)
{
System.out.println("OOPS!! Some Internal Problem try again later");
}
}
private static void getByContactNumber(String []data)
{
if(data.length!=2)
{
System.out.println("Invalid Mobile number");
System.out.println("Usage: java CoachingStudentManager getByContactNumber [contactNumber]");
return;
}
String mobileNumber=data[1];
try
{
File file=new File(DATA_FILE);
if(file.exists()==false)
{
System.out.println("Invalid contact number "+mobileNumber);
return;
}
RandomAccessFile randomAccessFile;
randomAccessFile=new RandomAccessFile(file,"rw");
if(randomAccessFile.length()==0)
{
System.out.println("Invalid contact number "+mobileNumber);
randomAccessFile.close();
return;
}
String vMobileNumber="";
String vName="";
String vCourse="";
int vFee=0;
boolean found=false;
while(randomAccessFile.getFilePointer()<randomAccessFile.length())
{
vMobileNumber=randomAccessFile.readLine();
if(vMobileNumber.equalsIgnoreCase(mobileNumber)==true)
{
vName=randomAccessFile.readLine();
vCourse=randomAccessFile.readLine();
vFee=Integer.parseInt(randomAccessFile.readLine());
found=true;
break;
}
randomAccessFile.readLine();
randomAccessFile.readLine();
randomAccessFile.readLine();
}
randomAccessFile.close();
if(found==false)
{
System.out.println("Invalid mobile Number: "+mobileNumber);
return;
}
System.out.println("Name: "+vName);
System.out.println("Course: "+vCourse);
System.out.println("Fee: "+vFee);
}catch(IOException ioException)
{
System.out.println("OOPS!! Some Internal Problem try again later");
}
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