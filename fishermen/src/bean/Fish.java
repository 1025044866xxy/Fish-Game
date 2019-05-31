package bean;
/**
 * 
 * @author Azhu
 *
 */
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

public class Fish extends Thread{
	private List<Image>  left_to_right;
	private List<Image> right_to_left;
	private List<Image> top_to_buttom;
	private List<Image>  left_to_right_catch;
	private List<Image> right_to_left_catch;
	private List<Image> top_to_buttom_catch;
	public Fish() {
		super();
		left_to_right=new ArrayList<Image>();
		right_to_left=new ArrayList<Image>();
		top_to_buttom=new ArrayList<Image>();
		left_to_right_catch=new ArrayList<Image>();
		right_to_left_catch=new ArrayList<Image>();
		top_to_buttom_catch=new ArrayList<Image>();
	}
	
	public List<Image> getLeft_to_right() {
		return left_to_right;
	}
	public void setLeft_to_right(List<Image> left_to_right) {
		this.left_to_right = left_to_right;
	}
	public List<Image> getRight_to_left() {
		return right_to_left;
	}
	public void setRight_to_left(List<Image> right_to_left) {
		this.right_to_left = right_to_left;
	}
	public List<Image> getTop_to_buttom() {
		return top_to_buttom;
	}
	public void setTop_to_buttom(List<Image> top_to_buttom) {
		this.top_to_buttom = top_to_buttom;
	}	
	public List<Image> getLeft_to_right_catch() {
		return left_to_right_catch;
	}
	public void setLeft_to_right_catch(List<Image> left_to_right_catch) {
		this.left_to_right_catch = left_to_right_catch;
	}
	public List<Image> getRight_to_left_catch() {
		return right_to_left_catch;
	}
	public void setRight_to_left_catch(List<Image> right_to_left_catch) {
		this.right_to_left_catch = right_to_left_catch;
	}
	public List<Image> getTop_to_buttom_catch() {
		return top_to_buttom_catch;
	}
	public void setTop_to_buttom_catch(List<Image> top_to_buttom_catch) {
		this.top_to_buttom_catch = top_to_buttom_catch;
	}
	
	

}
