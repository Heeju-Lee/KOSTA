package web.servlet.controller;

//결과페이지의 이름과 이동방법을 저장하는 클래스 (+바인딩된 객체도 담을 수 있음)
public class ModelAndView {
	private String path;// 결과페이지 정보
	private boolean isRedirect;// 이동방식(기본값이 forward이기 때문에)

	public ModelAndView() {
	}
	public ModelAndView(String path, boolean isRedirect) {
		this.path = path;
		this.isRedirect = isRedirect;
	}
	public ModelAndView(String path) {
		this.path = path;
	}
	public String getPath() {
		return path;
	}
	public boolean isRedirect() {
		return isRedirect;
	}
}
