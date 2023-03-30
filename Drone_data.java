package Path_gen;

public class Drone_data implements Comparable<Drone_data> {
	int x1;
	int y1;
	int x2;
	int y2;
	int t;
	
	Drone_data(int x1,int y1,int x2,int y2,int t)
	{
		this.x1=x1;
		this.y1=y1;
		this.x2=x2;
		this.y2=y2;
		this.t=t;
	}

	@Override
	public int compareTo(Drone_data o) {
		if(this.t>o.t)
			return 1;
		else if(this.t<o.t)
			return -1;
		return 0;
	}

	@Override
	public String toString()
	{
		return x1+" "+y1+" "+x1+" "+y2+" "+t;
	}
}
