package mainPackage;

public abstract class Cube extends ImageJPanel {
		private static final long serialVersionUID = 1L;
		private static String imgSrc ;
		public Cube() {
			super(imgSrc);
		}
		public Cube(String imgSrc) {
			super(imgSrc);
		}
		public Cube(int x, int y, int width, int height) {
			super(imgSrc);
			setBounds(x, y, width, height);
		}
		
		
		
	 
}
