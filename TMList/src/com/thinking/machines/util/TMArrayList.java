package com.thinking.machines.util;
class TMArrayList implements TMList
{
private int[] collection;
private int capacity;
private int size;
TMArrayList()
{
this.collection=new int[10];
this.size=0;
this.capacity=10;
}
public void add(int data)
{
if(this.capacity==this.size)
{
int []o;
o=new int[this.capacity*2];
for(int i=0;i<this.size;i++)
{
o[i]=this.collection[i];
}
this.collection=o;
this.capacity=this.capacity*2;
}
this.collection[this.size]=data;
this.size++;
}

public void add(int data,int index)
{
if(index<0 || index > this.size) throw new IndexOutOfBoundsException("invalid index: "+index);
if(this.capacity==this.size)
{
int []o;
o=new int[this.capacity*2];
for(int i=0;i<this.size;i++)
{
o[i]=this.collection[i];
}
this.collection=o;
this.capacity=this.capacity*2;
}
for(int i=this.size;i>index;i--)
{
this.collection[i]=this.collection[i-1];
}
this.collection[index]=data;
this.size++;
}

public int removeAt(int index)
{
if(index<0 || index>=this.size) throw new IndexOutOfBoundsException("Invalid index: "+index);
for(int i=index;i<this.size;i++)
{
this.collection[i]=this.collection[i+1];
}
int data=this.collection[index];
this.size--;
return data;
}

public int size()
{
return this.size;
}
public int get(int i)
{
if(i>=this.size) throw new IndexOutOfBoundsException("invalid index: "+i);
else return this.collection[i];
}
public int getCapacity()
{
return this.capacity;
}
public void clear()
{
// logically it is empty technically We still have buffer
this.size=0;
}
public void insert(int index,int data)
{
this.add(data,index);
}
public void removeAll()
{
this.clear();
}
public void update(int index,int data)
{
if(index<0 || index>= this.size) throw new IndexOutOfBoundsException("invalid index: "+index);
this.collection[index]=data;
}
public void copyTo(TMList other)
{
other.clear();
for(int i=0;i<this.size;i++) other.add(this.get(i));
}
public void copyFrom(TMList other)
{
this.clear();
// why I call other.size() because in our interface we don't have size propery but we have size method which return the size of List.
for(int i=0;i<other.size();i++) this.add(other.get(i));
}
public void appendTo(TMList other)
{
for(int i=0;i<this.size;i++) other.add(this.get(i));
}
public void appendFrom(TMList other)
{
for(int i=0;i<other.size();i++) this.add(other.get(i));
}

}