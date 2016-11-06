import java.io.*;
import java.util.*;
import java.util.concurrent.locks.*;

public class producer implements Runnable{
	Thread p1,p2,p3;
	FileReader in;
	BufferedReader inp;
	List<Float> temp=new ArrayList<Float>();
	List<Float> rain=new ArrayList<Float>();
	List<Float> humid=new ArrayList<Float>();
	private Lock l=new ReentrantLock();
	Condition c=l.newCondition();
	
	
	String str;
	public void getsize()
	{
		System.out.println(temp.size());
		System.out.println(rain.size());
		System.out.println(humid.size());
		
	}
	public void run()
	{
		p1=new Thread(new Runnable()
		{
			
			@SuppressWarnings("resource")
			public void  run()
			{		
					try 
					{	
						FileReader in;
						BufferedReader inp;
						in=new FileReader("t");
						inp=new BufferedReader(in);
						str=inp.readLine();					
						while(str!=null)
						{
							temp.add(Float.parseFloat(str));
							str=inp.readLine();						
						}
						
					}
					catch(FileNotFoundException f)
					{
						f.printStackTrace();
					}
					catch (IOException e) {
						e.printStackTrace();
					}
					System.out.println("heretemp"+temp.size());
				}			
		});
		p2=new Thread(new Runnable(){
			
			public void  run()
			{	
					try 
					{
						FileReader in;
						BufferedReader inp;
						in=new FileReader("h");
						inp=new BufferedReader(in);
						str=inp.readLine();					
						while(str!=null)
						{
							humid.add(Float.parseFloat(str));
							str=inp.readLine();						
						}
					}
					catch(FileNotFoundException f)
					{
						
					}
					catch (IOException e) {
						e.printStackTrace();
					}
					System.out.println("herehumid"+humid.size());	
				}
				
		});
		p3=new Thread(new Runnable(){
			
			public void  run()
			{		
					try 
					{
						FileReader in;
						BufferedReader inp;
						in=new FileReader("rain");
						inp=new BufferedReader(in);
						str=inp.readLine();					
						while(str!=null)
						{
							rain.add(Float.parseFloat(str));
							str=inp.readLine();						
						}
					}
					catch(FileNotFoundException f)
					{
						
					}
					catch (IOException e) {
						e.printStackTrace();
					}
					finally
					{System.out.println("hererain"+rain.size());
						
					}
				}
		});	
		
			p1.start();
			p2.start();
			p3.start();
		
		
		//System.out.println(temp.get(1)+humid.get(1)+rain.get(1));
	}

}
