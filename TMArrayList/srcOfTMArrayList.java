class TMArrayList<T>
{
private Object[] collection;
private int capacity;
private int size;
TMArrayList()
{
this.collection=new Object[10];
this.size=0;
this.capacity=10;
}
public void add(T data)
{
if(this.capacity==this.size)
{
Object []o;
o=new Object[this.capacity*2];
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

public void add(T data,int index)
{
if(index<0 || index > this.size) throw new IndexOutOfBoundsException("invalid index");
if(this.capacity==this.size)
{
Object []o;
o=new Object[this.capacity*2];
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

public T removeAt(int index)
{
if(index<0 || index>=this.size) throw new IndexOutOfBoundsException("Invalid index: "+index);
for(int i=index;i<this.size;i++)
{
this.collection[i]=this.collection[i+1];
}
T data=(T)this.collection[index];
this.size--;
return data;
}

public int size()
{
return this.size;
}
public T get(int i)
{
if(i>=this.size) throw new IndexOutOfBoundsException("invalid index: "+i);
else return (T)this.collection[i];
}
public int getCapacity()
{
return this.capacity;
}
public void empty()
{
// logically it is empty technically We still have buffer
this.size=0;
}
}
class psp
{
public static void main(String []args)
{
TMArrayList<Integer> list=new TMArrayList<Integer>();
/*
testcase for another case
for(int i=0;i<list.size();i++) System.out.print(list.get(i)+" ");
System.out.println("currently capacity: "+list.getCapacity());
list.get(60000);
for(int i=0;i<7;i++) list.add(i);
list.add(790,5);
for(int i=0;i<list.size();i++) System.out.print(list.get(i)+" ");
System.out.println("Testing complete");
for(int i=0;i<7;i++) list.add(i);
System.out.println("currently capacity: "+list.getCapacity());
list.empty();
System.out.println("after empty method capacity is: "+list.getCapacity());
System.out.println("after empty method size is: "+list.size());
System.out.println("Trying to get data after clearing");
System.out.println("Testing complete");
*/
for(int i=0;i<7;i++) list.add(i+1);
System.out.println("removed: "+list.removeAt(3));
for(int i=0;i<list.size();i++) System.out.print(list.get(i)+" ");
System.out.println("Testing complete");
}
}