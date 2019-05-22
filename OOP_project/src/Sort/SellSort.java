package Sort;

public class SellSort extends Sort {
	private static final long serialVersionUID = 1L;
	
	public SellSort(String imgSrc) {
		super(imgSrc);
	}
	
	public void Sort(Thread thread) {
		int h = DomList.size()/2;
		while (h>0) {
			for (int i = 0; i < DomList.size(); i++) {
				CauGio(500);
				setIDominoLayout(DomList.get(i));
				CauGio(500);
				Boolean check = true;
				for (int j = i; j > h-1 && check ; j=j-h) {
					setJ1DominoLayout(DomList.get(j));
					setJ1DominoLayout(DomList.get(j-h));
					if(DomList.get(j).getValue() < DomList.get(j-h).getValue()) {
						swap(j, j-h);
						if (pause) thread.suspend();
					}
					else {
						check =false;
					}
					CauGio(500);
					setDefaultDominoLayout(DomList.get(j));
					setDefaultDominoLayout(DomList.get(j-h));
					
				}
				setDefaultDominoLayout(DomList.get(i));
			}
			h=h/2;
		}
		javax.swing.JOptionPane.showMessageDialog(null, "Short END");
	}
}
