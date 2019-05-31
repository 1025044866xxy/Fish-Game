package bean;
import java.util.logging.*;
import javazoom.jl.decoder.*;
import javazoom.jl.player.*;
 
public class MySound extends Thread {
 
    private Player player;
    private String musicName;
    private boolean flag;
 
    //加载音乐
    public MySound(String musicName) {
        this.musicName = musicName;
    }
 
    //播放音乐
    public void play() {
        try {//音频文件要和这个类在同一个包里面
        	new Player(getClass().getResourceAsStream(musicName)).play();
        	
        } catch (JavaLayerException ex) {
            Logger.getLogger(MySound.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 
    //循环播放音乐
    public void loop() {
        this.start();
    }
 
    @Override
    public void run() {
        while (isFlag()) {
            try {
                new Player(getClass().getResourceAsStream(musicName)).play();
            } catch (JavaLayerException ex) {
                Logger.getLogger(MySound.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
 
} 
