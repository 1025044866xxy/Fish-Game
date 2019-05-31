package controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.image.MemoryImageSource;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import bean.Fish;
import bean.InFish;
import bean.MySound;

public class Panel extends JPanel implements Runnable,MouseListener,MouseMotionListener,KeyListener{
		Image bgImage;
		List<Fish> fishes;
		List<InFish> inFishes;
		List<InFish> CatchFishes;
		List<Integer> fishscore;
		int[] fishKinds;
		Image Net;
		int mouseX;
		int mouseY;
		Integer bg_flag=0;
		Image bg_loginImage;
		Image bg_login_startImage;
		Image bg_gameover;
		Integer gold_num;
		Integer have_score;
		Integer max_score;
		boolean flag_3;
		boolean bgm_flag;
		MySound bgm;
		/*
		 * 构造函数
		 */
	    public Panel() {
	    	max_score=0;
	    	init();
	    	init_login();
	    	init_gaming();
	    	init_gameover();
	    	init_bgm();
	    	init_PutFish();

	    	}
	    public void again()
	    {
	    	have_score=0;
	    	gold_num=100;
	    	flag_3=false;
	    	fishKinds=new int[12];
	    	inFishes=new ArrayList<InFish>();
	    	CatchFishes=new ArrayList<InFish>();
			init_PutFish();
	    }
	    public void init_bgm() {
			// TODO Auto-generated method stub
			bgm=new MySound("bgm_login.mp3");
			bgm.setFlag(false);
			bgm_flag=false;
		}
		public void init_gameover() {
			// TODO Auto-generated method stub
			try {
				bg_gameover=ImageIO.read(new File("Fishing_Man/Fishing_Man/bg_gameover.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		public void init_PutFish() {
			for(int i=0;i<60;i++) {
				InFish fish=getRandomfish();
				Random random=new Random();			
				int x=random.nextInt(1300)+0;
				int y=random.nextInt(768)+0;
				fish.setX(x);
				fish.setY(y);
				new Thread(fish).start();//启动线程、鱼自行运动
				fish.setFlag(true);
				inFishes.add(fish);//加入鱼的list
				fishKinds[(int) fish.getId()]++;
			}
		}
		public void init() {
			// TODO Auto-generated method stub
	    	bg_flag =0;
	    	have_score=0;
	    	fishscore=new ArrayList<Integer>();
	    	for(int i=0;i<5;i++)
	    		fishscore.add(i+1);
	    	gold_num=100;
	    	fishscore.add(8);
	    	fishscore.add(11);
	    	fishscore.add(14);
	    	fishscore.add(17);
	    	fishscore.add(20);
	    	fishscore.add(25);
	    	fishes=new ArrayList<Fish>();
	    	inFishes=new ArrayList<InFish>();
	    	CatchFishes=new ArrayList<InFish>();
	    	fishKinds=new int[12];
	    	for(int i=0;i<12;i++)
	    		fishKinds[i]=0;
		}
		public void init_login() {
			try {
				bg_loginImage=ImageIO.read(new File("Fishing_Man/Fishing_Man/bg_login.png"));
				bg_login_startImage=ImageIO.read(new File("Fishing_Man/Fishing_Man/bg_login_start.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for(int i=0;i<fishscore.size();i++)
				System.out.println(fishscore.get(i));
			
		}
	    public void init_gaming() {
	    	flag_3=false;
	    	//获取背景图片
	    	try {
				bgImage = ImageIO.read(new File(
						"Fishing_Man/Fishing_Man/bg.jpg"));
				Net=ImageIO.read(new File(
						"Fishing_Man/Fishing_Man/yuwang.png"));
			} catch (IOException e) {
				System.out.println("没有获取到背景图片");
				e.printStackTrace();
			}	    	
	    	//获取各种鱼类的三个方向的所有图片
	    	for(int i=1;i<=11;i++) {
	    		Fish fish=new Fish();
	    		//left_to_right
	    		for(int j=1;j<=10;j++) {
						Image image;
						try {
							image = ImageIO.read(new File(
									"Fishing_Man/Fishing_Man/fish"+conversion(i)+"/left_to_right/"+"fish"+conversion(i)+"_"+conversion(j)+".png"));
							fish.getLeft_to_right().add(image);
						} catch (IOException e) {
							e.printStackTrace();
						}			
	    		}
	    		//right_to_left
	    		for(int j=1;j<=10;j++) {
						Image image;
						try {
							image = ImageIO.read(new File(
									"Fishing_Man/Fishing_Man/fish"+conversion(i)+"/right_to_left/"+"fish"+conversion(i)+"_"+conversion(j)+".png"));
							fish.getRight_to_left().add(image);	
						} catch (IOException e) {
							System.out.println(new File(
									"Fishing_Man/Fishing_Man/fish"+conversion(i)+"/right_to_left/"+"fish"+conversion(i)+"_"+conversion(j)+".png"));
							e.printStackTrace();
						}			
	    		}
	    		//top_to_buttom
	    		for(int j=1;j<=10;j++) {
						Image image;
						try {
							image = ImageIO.read(new File(
									"Fishing_Man/Fishing_Man/fish"+conversion(i)+"/top_to_buttom/"+"fish"+conversion(i)+"_"+conversion(j)+".png"));
							fish.getTop_to_buttom().add(image);
						} catch (IOException e) {
							e.printStackTrace();
						}				
	    		}
	    		int size=2;
	    		if(i>=8)
	    			size=4;
	    		//left_to_right_catch
	    		for(int j=1;j<=size;j++) {
						Image image;
						try {
							image = ImageIO.read(new File(
									"Fishing_Man/Fishing_Man/fish"+conversion(i)+"/left_to_right/"+"fish"+conversion(i)+"_catch_"+conversion(j)+".png"));
							fish.getLeft_to_right_catch().add(image);
						} catch (IOException e) {
							System.out.println("1");
							e.printStackTrace();
						}			
	    		}
	    		//right_to_left_catch
	    		for(int j=1;j<=size;j++) {
						Image image;
						try {
							image = ImageIO.read(new File(
									"Fishing_Man/Fishing_Man/fish"+conversion(i)+"/right_to_left/"+"fish"+conversion(i)+"_catch_"+conversion(j)+".png"));
							fish.getRight_to_left_catch().add(image);	
						} catch (IOException e) {
							System.out.println("2");
							e.printStackTrace();
						}			
	    		}
	    		//top_to_buttom_catch
	    		for(int j=1;j<=size;j++) {
						Image image;
						try {
							image = ImageIO.read(new File(
									"Fishing_Man/Fishing_Man/fish"+conversion(i)+"/top_to_buttom/"+"fish"+conversion(i)+"_catch_"+conversion(j)+".png"));
							fish.getTop_to_buttom_catch().add(image);
						} catch (IOException e) {
							e.printStackTrace();
						}				
	    		}
	    		fishes.add(fish);
	    	}
	    	//图片读取测试
	    	/*for(int i=0;i<fishes.size();i++) {
	    		System.out.println("Left:"+fishes.get(i).getLeft_to_right_catch().size());
	    		System.out.println("Right:"+fishes.get(i).getRight_to_left_catch().size());
	    		System.out.println("Top:"+fishes.get(i).getTop_to_buttom_catch().size());
	    	}*/
		}
	    /*
	     * (non-Javadoc)
	     * @see javax.swing.JComponent#paint(java.awt.Graphics)
	     */
		@Override
		public void paint(Graphics g) {
			System.out.println();
			//super.paint(g);
			//让背景图片自适应窗口大小
			System.out.println("屏幕有多少鱼:"+inFishes.size());
			if(bg_flag==0)
			{
				if(!bgm_flag)
				{
					bgm.setFlag(true);
					bgm.loop();
					bgm_flag=true;
				}
					
				g.drawImage(bg_loginImage, 0, 0, this.getWidth(),this.getHeight(),this);
				g.drawImage(bg_login_startImage, 100, -300, this);
				//System.out.println(this.getWidth()+" "+this.getHeight());
			}
			else if(bg_flag==1)
			{
				if(!bgm_flag)
				{
					bgm.setFlag(true);
					bgm.loop();
					bgm_flag=true;
				}
				g.drawImage(bgImage, 0, 0,this.getWidth(),this.getHeight(),this);
				//System.out.println("鱼几条："+inFishes.size());
				for(int i=0;i<inFishes.size();i++)
				{	
					InFish inFish=inFishes.get(i);
					Image image;
					if(inFish.getDir()==1)
						image=inFish.getLeft_to_right().get(inFish.getIndex());
					else if(inFish.getDir()==2)
						image=inFish.getRight_to_left().get(inFish.getIndex());
					else
						image=inFish.getTop_to_buttom().get(inFish.getIndex());
					g.drawImage(image, inFish.getX(), inFish.getY(),this);
					if(inFish.getDir()==1)
					{
						inFish.setX(inFish.getX()+inFish.getSpeed());
					}
					else if(inFish.getDir()==2)
					{
						inFish.setX(inFish.getX()-inFish.getSpeed());
					}
					else {
							inFish.setY(inFish.getY()+inFish.getSpeed());
					}
					
					System.out.println("屏幕有多少鱼:"+inFishes.size());
				}
				for(int i=0;i<inFishes.size();i++)
				{	
					//判断鱼有没有出边界、出边界删除该条鱼
					InFish inFish=inFishes.get(i);
					if(judge(inFish)) {
						inFish.setFlag(false);
						inFishes.remove(i);							
						fishKinds[(int) inFish.getId()]--;
						
						InFish fish=getRandomfish();
						new Thread(fish).start();//启动线程、鱼自行运动
						fish.setFlag(true);
						inFishes.add(fish);//加入鱼的list
						fishKinds[(int) fish.getId()]++;
					}
				}
				for(int i=0;i<CatchFishes.size();i++) {
					InFish inFish=CatchFishes.get(i);
					Image image;
					if(inFish.getDir()==1) {
						image=inFish.getLeft_to_right_catch().get(inFish.getIndex());
					}					
					else if(inFish.getDir()==2) {
						image=inFish.getRight_to_left_catch().get(inFish.getIndex());
					}	
					else {
						image=inFish.getTop_to_buttom_catch().get(inFish.getIndex());
					}		
					g.drawImage(image, inFish.getX(), inFish.getY(),this);
					//System.out.println("ssssssss:"+inFish.getIndex()+"sss:"+inFish.getRight_to_left_catch().size());
					if(inFish.getIndex()==inFish.getRight_to_left_catch().size()-1) {
						CatchFishes.remove(i);
						inFish.setFlag(false);
					}
				}		
				Image image = Toolkit.getDefaultToolkit().createImage(new MemoryImageSource(0, 0, new int[0], 0, 0));
				setCursor(Toolkit.getDefaultToolkit().createCustomCursor(image,new Point(0, 0), null));
				/*System.out.println(mouseX+"........."+mouseY);
				System.out.println(Net.getWidth(null)+"........."+Net.getHeight(null));*/
				g.drawImage(Net, mouseX-Net.getWidth(null)/2, mouseY-Net.getHeight(null)/2, this);
				Graphics2D g2=(Graphics2D) g;
				g2.setColor(Color.RED);
				g2.setFont(new Font("方正粗金陵", Font.BOLD, 20));
				g2.drawString("当前剩余子弹数"+gold_num.toString(), this.getWidth()-200, this.getHeight()-50);
				g2.drawString("当前分数："+have_score.toString(), this.getWidth()-200, this.getHeight()-30);
			}
			else if(bg_flag==3)
			{
				if(have_score>max_score)
					flag_3=true;
				Graphics2D g2=(Graphics2D) g;
				g2.setColor(Color.RED);
				g2.setFont(new Font("方正粗金陵", Font.BOLD, 40));
				g.drawImage(bg_gameover, 0, 0,this.getWidth(),this.getHeight(),this);
				if(flag_3)
				{
					max_score=have_score;
					g2.drawString("恭喜取得历史最高成绩"+max_score.toString(), this.getWidth()/2-200, this.getHeight()/2-100);
				}
				else
				{
					g2.drawString("差一丢丢就突破了自我了呢！\n成绩为："+have_score.toString(), this.getWidth()/2-200, this.getHeight()/2-100);
				}
				g.drawString("按空格再来一盘", this.getWidth()/2-200, this.getHeight()/2+200);
			}
		}
		//转化函数、读取图片时调用
		public String conversion(int n) {
			String ret=""+n;
			if(n<10)
				ret="0"+ret;
			return ret;
			
		}
		@Override
		public void run() {
			while(true) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}			
				repaint();
			}
		}
		public boolean judge(InFish fish) {
			//得到屏幕的尺寸 
			//从左往右游动
			if(fish.getDir()==1) {
				if(fish.getX()>=this.getWidth())
					return true;
			}else if(fish.getDir()==2) {
				if(fish.getX()<=-1*fish.getRight_to_left().get(0).getWidth(null))
					return true;
			}else {
				if(fish.getY()>=this.getHeight())
					return true;
			}			
			return false;	
		}
		public boolean judgeKinds(int id) {
			if(fishKinds[id]>=3&&id==9)
				return false;
			if(fishKinds[id]>=5&&id==10)
				return false;
			return true;
		}
		public InFish getRandomfish() {		
			//产生随机数 int number = random.nextInt(END - START + 1) + START;
			Random random=new Random();			
			int num=random.nextInt(fishes.size())+0;
			int dir=random.nextInt(3)+0;
			int speed=retSpeed(num);
			InFish addFish=new InFish();
			addFish.setDir(dir);
			addFish.setSpeed(speed);
			addFish.setId(num);
			//得到屏幕的尺寸 
			if(dir==1)
			{	
				addFish.setHeight(fishes.get(num).getLeft_to_right().get(0).getHeight(null));
				addFish.setWidth(fishes.get(num).getLeft_to_right().get(0).getWidth(null));
				//
				addFish.setLeft_to_right(fishes.get(num).getLeft_to_right());
				addFish.setLeft_to_right_catch(fishes.get(num).getLeft_to_right_catch());
				addFish.setRight_to_left(fishes.get(num).getRight_to_left());
				addFish.setRight_to_left_catch(fishes.get(num).getRight_to_left_catch());
				addFish.setTop_to_buttom(fishes.get(num).getTop_to_buttom());
				addFish.setTop_to_buttom_catch(fishes.get(num).getTop_to_buttom_catch());
				//
				addFish.setY(random.nextInt(768)+0);
				addFish.setX(-1*addFish.getWidth());
				
			}else if(dir==2) {
				addFish.setHeight(fishes.get(num).getRight_to_left().get(0).getHeight(null));
				addFish.setWidth(fishes.get(num).getRight_to_left().get(0).getWidth(null));
				//
				addFish.setLeft_to_right(fishes.get(num).getLeft_to_right());
				addFish.setLeft_to_right_catch(fishes.get(num).getLeft_to_right_catch());
				addFish.setRight_to_left(fishes.get(num).getRight_to_left());
				addFish.setRight_to_left_catch(fishes.get(num).getRight_to_left_catch());
				addFish.setTop_to_buttom(fishes.get(num).getTop_to_buttom());
				addFish.setTop_to_buttom_catch(fishes.get(num).getTop_to_buttom_catch());
				//
				addFish.setY(random.nextInt(768)+0);
				addFish.setX(1300);
			}
			else {
				addFish.setHeight(fishes.get(num).getTop_to_buttom().get(0).getHeight(null));
				addFish.setWidth(fishes.get(num).getTop_to_buttom().get(0).getWidth(null));
				//
				addFish.setLeft_to_right(fishes.get(num).getLeft_to_right());
				addFish.setLeft_to_right_catch(fishes.get(num).getLeft_to_right_catch());
				addFish.setRight_to_left(fishes.get(num).getRight_to_left());
				addFish.setRight_to_left_catch(fishes.get(num).getRight_to_left_catch());
				addFish.setTop_to_buttom(fishes.get(num).getTop_to_buttom());
				addFish.setTop_to_buttom_catch(fishes.get(num).getTop_to_buttom_catch());
				//
				addFish.setX(random.nextInt(1300)+0);
				addFish.setY(-1*addFish.getHeight());
			}	
			return addFish;			
		}
		public int  retSpeed(int id) {
			switch(id){
		    case 0:
		        return new Random().nextInt(12)+8;
			case 1:
				return new Random().nextInt(12)+8;
			case 2:
				return new Random().nextInt(12)+10;
			case 3:
				return new Random().nextInt(8)+4;
			case 4:
				return new Random().nextInt(6)+2;
			case 5:
				return new Random().nextInt(9)+7;
			case 6:
				return new Random().nextInt(9)+5;
			case 7:
				return new Random().nextInt(9)+5;
			case 8:
				return 3;
			case 9:
				return new Random().nextInt(6)+5;
			case 10:
			    return 2;
			case 11:
			    return 4;        
			}
			return 2;		
		}
		@Override
		public void mouseClicked(MouseEvent e) {
			
		}
		public void catchFish() {
			for(int i=0;i<inFishes.size();i++){
				InFish inFish=inFishes.get(i);
				if(mouseX>=inFish.getX()&&mouseX<=inFish.getX()+inFish.getWidth()&&mouseY>=inFish.getY()&&mouseY<=inFish.getY()+inFish.getHeight())
				{	
					if(judgeCatch(inFish))
					{	
						inFish.setCatch(true);
						inFish.setIndex(0);
						CatchFishes.add(inFish);
						gold_num+=fishscore.get((int) inFish.getId());
						have_score+=fishscore.get((int) inFish.getId());
						inFishes.remove(i);
						InFish fish=getRandomfish();
						new Thread(fish).start();//启动线程、鱼自行运动
						fish.setFlag(true);
						inFishes.add(fish);//加入鱼的list
						fishKinds[(int) fish.getId()]++;
					}							
				}
			}
			repaint();	
		}
		public boolean judgeCatch(InFish fish) {
			int gailv=(int) fish.getId();
			Random random=new Random();	
			//总共十一种鱼三个为一组，概率分别为 1/2，1/4，1/6，1/10
			if(gailv/3==0)
			{	
				int num=random.nextInt(2)+0;
				if(num==1)
				{
					return true;
				}
			}else if (gailv/3==1){
				int num=random.nextInt(4)+0;
				if(num==1)
				{
					return true;
				}
			}
			else if (gailv/3==2){
				int num=random.nextInt(6)+0;
				if(num==1)
				{
					return true;
				}
			}else {
				int num=random.nextInt(10)+0;
				if(num==1)
				{
					return true;
				}
			}
			return false;		
		}
		//游戏完成结束线程
		public void Destory()
		{
			for(int i=0;i<inFishes.size();i++)
			{
				InFish fish =inFishes.get(i);
				fish.setFlag(false);
			}
			inFishes.clear();
			bg_flag=3;
		}
		@SuppressWarnings("deprecation")
		@Override
		public void mousePressed(MouseEvent e) {
			//判断是否开始
			if(bg_flag==0)
			{
				if(e.getX()>=920&&e.getX()<=1170&&e.getY()<=490&&e.getX()>=400)
				{
					bg_flag=1;
					bgm_flag=false;
					bgm.setFlag(false);
					bgm.stop();
					bgm=new MySound("bgm_game.mp3");
					bgm.setFlag(false);
					repaint();
				}
			}
			//判断抓鱼
			else if(bg_flag==1)
			{
				if(gold_num>=3)
				{
					gold_num-=3;
					//System.out.println("抓鱼");
					catchFish();
				}
				else
				{
					gold_num=0;
					JOptionPane.showMessageDialog(null, "子弹已耗尽，快来查看您的成绩吧！", "游戏结束", JOptionPane.INFORMATION_MESSAGE);
					Destory();
				}
			}
			//System.out.println("抓鱼！");
		}
		@Override
		public void mouseReleased(MouseEvent e) {		
		}
		@Override
		public void mouseEntered(MouseEvent e) {		
		}
		@Override
		public void mouseExited(MouseEvent e) {	
		}
		@Override
		public void mouseDragged(MouseEvent e) {
		}
		@Override
		public void mouseMoved(MouseEvent e) {
			//获取鼠标的坐标
			mouseX=e.getX();
			mouseY=e.getY();
		}
		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			if(e.getKeyCode()==KeyEvent.VK_SPACE&&bg_flag==3)
			{
				bg_flag=1;
				again();
			}
		}
		@Override
		public void keyReleased(KeyEvent e) {		
		}
}
