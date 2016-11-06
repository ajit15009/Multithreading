import java.util.*;
public class consumer implements Runnable{
	
	Thread t1,t2,t3;
	
	
	
	public consumer()
	{
		System.out.println("Here");
	}
	public void run()
	{
		System.out.println("Thread");
		//consumer c=new consumer();
		t1=new Thread(new Runnable(){
		
			public void  run()
			{
				
			}
		});
		t2=new Thread(new Runnable(){
			
			public void  run()
			{
				
			}
		});
		t3=new Thread(new Runnable(){
			
			public void  run()
			{
				
			}
		});
		for(Thread t: new Thread[]{t1,t2,t3})
		{
			try {
				t.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
}
