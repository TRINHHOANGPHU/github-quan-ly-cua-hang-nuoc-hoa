package generalRules;

import java.awt.Font;

public enum fontChuDe {
	FONT_TITLE(new Font("Times New Roman", Font.ITALIC, 30)),
	FONT_TITLE_SELECTED_MENU_LEFT(new Font("Times New Roman", Font.BOLD, 40)),
	FONT_MENU_LEFT(new Font("Arial", 0, 15)),
	FONT_MENU_LEFT_2(new Font("Arial", Font.BOLD, 18)),
	FONT_TITLE_BORDER(new Font("Arial", Font.BOLD, 15));
	
	private Font font;
	fontChuDe(Font font) {
		this.font = font;
	}
	
	public Font getFont() {
		return this.font;
	}
}
