#	DOCUMENTATION

## Overview
here you get to know about `InputUtility` of My Java mini-projects.

## Why The InputUtility in Java ?
we have `fflush in C`, but when we talk about `Java` so there is no such facilites to clear buffer in a simple way. In this project I created a package for resolving this issue.

## Real life use
So, This package is very usefull whenever I or someone wants to create application on text user interface.


## Issue
Consider the following code
```java

import java.io.*;
class psp
{
public static void main(String args[])
{
String name="";
char gender='a';
InputStreamReader isr=new InputStreamReader(System.in);
BufferedReader br=new BufferedReader(isr);
try
{
System.out.print("Enter Student Gender: ");
gender=(char)br.read();
System.out.print("Enter Student Name: ");
name=br.readLine();
}catch(IOException e)
{
System.out.println(e.getMessage());
}
System.out.println(name);
System.out.println(gender);
}
}


```
### Explaination

So If you compile above code and run you will see application ask for Gender Let's say we give Y and press Enter, then you see application not ask for name it will directly print the name and gender where interstingly name is blank.

#### Internal Explaination

So internally we have buffer and when we give Y and press Enter, Conceptually inside buffer we have Y and Enter key in buffer. and Technically buffer contains the unicode of respective signs.

------------------------------------------------------------------------------------------------------------------
					Y (Enter Key)
------------------------------------------------------------------------------------------------------------------

##### Behaviour of methods
So `br.read()` Method have behaviour that it only take 1 unicode from the buffer 

Now Let's understand behaviour of `br.readLine` Method. Whatever it see it will collect util it see Enter Key. But `readLine` method also collect Enter key and parse then return as String.

Now Let's Dry Run or Paper Run of our code
So first it ask for gender the we give Y and press enter key. So iternally read() Method only collect Y(unicode) and return its repective unicode 

Now insde buffer we have
------------------------------------------------------------------------------------------------------------------
				          (Enter Key)
------------------------------------------------------------------------------------------------------------------
But When control goes to the line `name=br.readLine()`, Now We Know readLine Method will imediatly start collecting and it stopped when it see Enter Key and also collect Enter Key, So it will collected and apply parsing logic and return as string. that's why program not ask for name.

## Solution
we can give free fire of `br.reader()` method so that it will grab the Enter key and then Our buffer is Empty so it will ask further internally functionality to take input from I/O devices that is our keyboard. Now our application ask for name
Code:
```java

import java.io.*;
class psp
{
public static void main(String args[])
{
String name="";
char gender='a';
InputStreamReader isr=new InputStreamReader(System.in);
BufferedReader br=new BufferedReader(isr);
try
{
System.out.print("Enter Student Gender: ");
gender=(char)br.read();
br.read(); // free fire
System.out.print("Enter Student Name: ");
name=br.readLine();
}catch(IOException e)
{
System.out.println(e.getMessage());
}
System.out.println(name);
System.out.println(gender);
}
}

```

### Reason to create package
Now We see everthing is working fine but Think about it When we create console application and our application ask for multiple field of data, then as programmer I feel it is very tds task and hard to find bug. one more thing I noticed this problematic behaviour occurs with int float double short etc.

### Credit
Thanks to God and founder of thinkingmachine.in that is Mr.Prafull Kelker who give this Opportunity to solve this problem.
