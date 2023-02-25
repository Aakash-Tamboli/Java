package com.thinking.machines.utils;
import java.io.*;
public class Keyboard
{
private BufferedReader bufferReader;

public Keyboard()
{
this.bufferReader=new BufferedReader(new InputStreamReader(System.in));
}

public String getString()
{
String str="";
try
{
while(this.bufferReader.ready()) this.bufferReader.read();
str=this.bufferReader.readLine();
}catch(IOException ioException)
{
str="";
}
return str;
}

public String getString(String message)
{
System.out.print(message);
return this.getString();
}

} // class closing parenthesis
