package Sort;

public class InsertionSort extends Sort  {
	private static final long serialVersionUID = 1L;
	public InsertionSort(String imgSrc) {
		super(imgSrc);
	}
	public void Sort(Thread thread) {
		CauGio(1000);
		for(int i=0 ;i < DomList.size();i++) {
			setIDominoLayout(DomList.get(i));
			CauGio(1000);
			for(int j = i ; j > 0 && DomList.get(j).getValue() < DomList.get(j-1).getValue() ; j--) {
				setJDominoLayout(DomList.get(j));
				CauGio(500);
				setJ1DominoLayout(DomList.get(j-1));
				swap(j, j-1);
				setDefaultDominoLayout(DomList.get(j));
				setDefaultDominoLayout(DomList.get(j-1));
				if(i==j) setIDominoLayout(DomList.get(j));
				if(pause) thread.suspend();
			}
			setDefaultDominoLayout(DomList.get(i));
		}
		javax.swing.JOptionPane.showMessageDialog(null, "Short END");
	}
}
