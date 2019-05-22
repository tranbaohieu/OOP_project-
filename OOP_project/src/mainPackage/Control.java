package mainPackage;

public interface Control {
	void init(int n);
	void start(Thread thread);
	void pause();
	void resume(Thread thread);
	void next(Thread thread);
}
