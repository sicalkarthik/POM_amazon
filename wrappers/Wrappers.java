package wrappers;

public interface Wrappers {
	public void invokeApp(String browser, String url);

	public void clickByXPath(String XPath);

	public void enterByXPath(String XPath, String data);

	public void closeAllBrowsers();

	public void loadObjects();

	public void switchtoLastWindow();

	public void getTextByXPath(String XPath);

	public void mouseOver(String XPath);

	public void selectVisibleTextByXPath(String text, String XPath);
	
	public void switchtoParentWindow();
	
	public void threadSleep(long time);
}
