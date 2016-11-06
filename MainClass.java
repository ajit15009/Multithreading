
public class MainClass {

	public static void main(String[] args)
	{
		//Thread c1=new Thread(new consumer());
		
		//c1.start();
		producer p=new producer();
		Thread t1=new Thread(p);
		t1.start();
		while(p.finished==false)
			t1.wait();
		
	}

}
