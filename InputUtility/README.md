#	DOCUMENTATION

## Overview
here you get to know about `InputUtility` of My Java mini-projects.

## Why The InputUtility in Java ?
we have `fflush in C`, but when we talk about `Java` so there is no such facilites to clear buffer in a simple way. In this project I created a package for resolving this issue.

## Issue
Consider the following code
```java

import java.util.Scanner;
class Main
{
public static void main(String []args)
{
int rollNumber;
String name;
Scanner sc=new Scanner(System.in);
System.out.print("Enter rollNumber: ");
rollNumber=sc.nextInt();
System.out.print("Enter name: ");
name=sc.nextLine();
System.out.printf("Name: %s\nrollNumber: %d\n",name,rollNumber);
}
}

```
### Explaination

So If you compile above code and run you will see application ask for roll Number Let's say we give 25 and press Enter, then you see application not ask for name it will directly print the name and rollNumber but interstingly name is blank.

#### Internal Explaination

So internally we have buffer and when we give 25 and press Enter, Conceptually inside buffer we have 2, 5 and Enter key in buffer. and Technically buffer contains the unicode of respective signs.

------------------------------------------------------------------------------------------------------------------
					2 5 (Enter Key)
------------------------------------------------------------------------------------------------------------------

##### Behaviour of methods
So `sc.nextInt()` Method have behaviour when it see numeric value(conceptually) it will start to collecting and it collect util it see Enter Key. Once it see Enter Key it imediatly stopped and parse, then return the int type value.

Now Let's understand behaviour of `sc.nextLine()` Method. Whatever it see it will collect util it see Enter Key. But `nextLine` method also collect Enter key and parse then return as String.

Now Let's Dry Run or Paper Run of our code
So first it ask for roll number the we give 25 and press enter key. So iternally nextInt() Method only collect 	2 and 5 and apply paring logic and return 25 as `int value`. 


Now insde buffer we have
------------------------------------------------------------------------------------------------------------------
				          (Enter Key)
------------------------------------------------------------------------------------------------------------------
But When control goes to the line `name=sc.nextLine()`, Now We Know nextLine Method will imediatly start collecting and it stopped when it see Enter Key and also collect Enter Key, So it will collected and apply parsing logic and return as string. that's why program not ask for name.

## Solution
we can give free fire of `sc.nextLine()` method so that it will grab the Enter key and then Our buffer is Empty so it will ask further internally functionality to take input from I/O device that is our keyboard. Now our application ask for name
Code:
```java

import java.util.Scanner;
class Main
{
public static void main(String []args)
{
int rollNumber;
String name;
Scanner sc=new Scanner(System.in);
System.out.print("Enter rollNumber: ");
rollNumber=sc.nextInt();
sc.nextLine(); // this is solution of our problem.
System.out.print("Enter name: ");
name=sc.nextLine();
System.out.printf("Name: %s\nrollNumber: %d\n",name,rollNumber);
}
}

```

### Reason to create package
Now We see everthing is working fine but Think about it When we create console application and our application ask for multiple field of data, then as programmer I feel it is very tds task and hard to find bug. one more thing I noticed this problematic behaviour occurs with int float double short etc.

### Credit
Thanks to God and founder of thinkingmachine.in that is Mr.Prafull Kelker who give this Opportunity to solve this problem.
