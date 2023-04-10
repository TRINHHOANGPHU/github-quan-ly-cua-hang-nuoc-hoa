package generalRules;

public enum mauChuDe {
	BLUE("#C67EE1"),
	SEA_BLUE("#92B9E3"),
	SKIN("#FFC4A4"),
	PINK("#FBA2D0"),
	COLOR_BACKGROUND_TITLE("#2f3e46"),
	COLOR_BACKGROUND_MENU_LEFT("#354f52"),
	COLOR_BACKGROUND_MENU_LEFT_2("#46676B"),
	COLOR_BACKGROUND_IMAGE("#52796f"),
	COLOR_TITLE("#FFF3B0"),
	COLOR_FONT_MENU_LEFT("#ffffff"),
	COLOR_BACKGROUND_INPUT_CONTENT("#edf2fb");
	
	private String maMau;
	
	mauChuDe(String maMau) {
		this.maMau = maMau;
	}
	public String getMaMau() {
		return this.maMau;
	}
	
	
}
