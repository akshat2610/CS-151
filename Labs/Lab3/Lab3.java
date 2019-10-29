import java.awt.*;

public class Lab3{
	public static void dump_array(Object[] arr){
		for (int i = 0; i < arr.length; i++) System.out.println(arr[i].toString());
	}
	public static void main(String[] array){
		Object[] arr = new Object[]{"Something", 8, new Rectangle(0,0,20, 20)};
		dump_array(arr);
	}
}