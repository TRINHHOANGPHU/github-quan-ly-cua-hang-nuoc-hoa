package generalRules;

import java.awt.Image;

public class xuLyAnh {

	public xuLyAnh() {
		
	}
	
	public static xuLyAnh getInstance() {
		return new xuLyAnh();
	}
	
	//lấy kích thước ảnh
	public static Image icon_Header(Image image) {
		Image i = image.getScaledInstance(50, 50, Image.SCALE_AREA_AVERAGING);
		return i;
	}
	
	public static Image icon_MenuLeft(Image image) {
		Image i = image.getScaledInstance(35, 35, Image.SCALE_AREA_AVERAGING);
		return i;
	}
	
	public static Image icon_MenuLeft_2(Image image) {
		Image i = image.getScaledInstance(45, 45, Image.SCALE_AREA_AVERAGING);
		return i;
	}
	
	public static Image icon_MenuLeft_Image_Purfome(Image image) {
		Image i = image.getScaledInstance(125, 125, Image.SCALE_AREA_AVERAGING);
		return i;
	}
	
	// lấy nguồn ảnh
	public String getResource_Image(String image) {
		String s = this.getClass().getClassLoader().getResource("img/").getPath() + image;
		return s;
	}
}
