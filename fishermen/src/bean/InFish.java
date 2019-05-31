package bean;


import java.util.Set;

public class InFish extends Fish{
	private int X;
	private int Y;
	private int speed;
	private int dir;	
	private int index;
	private int id;
	private int width;
	private int height;
	private boolean isCatch;
	private boolean flag;
	public boolean isCatch() {
		return isCatch;
	}

	public void setCatch(boolean isCatch) {
		this.isCatch = isCatch;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getX() {
		return X;
	}

	public InFish() {
		super();
		index=0;
		flag=false;
		speed=0;
		isCatch=false;
	}

	public void setX(int x) {
		X = x;
	}

	public int getY() {
		return Y;
	}

	public void setY(int y) {
		Y = y;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getDir() {
		return dir;
	}

	public void setDir(int dir) {
		this.dir = dir;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}
	@Override
	public void run() {
		int sleeptime=100;
			while(flag)
			{
				try {
					Thread.sleep(sleeptime);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if(!isCatch) {
					if(this.dir==1) {
						this.X+=this.speed;
					}else if(this.dir==2) {
						this.X-=this.speed;
					}else {
						this.Y+=this.speed;
					}
				}
				int mod=10;
				if(isCatch) {
					mod=this.getLeft_to_right_catch().size();
					System.out.println("mod:"+mod);
					sleeptime=100;
				}
				index++;
				index%=mod;
			}
	}
}
