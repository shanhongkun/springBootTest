package com.techscore.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/*
 * @Controllerによりコンポーネントスキャンされ、DIコンテナに登録される。
 */
@Controller
/*
 * @RequestMapping()　によりそれぞれのハンドラーメソッドのベースパスを指定する。
 */
public class LoginController {

	/*
	 * 相関チェック用のバリデータークラスをインジェクションする。
	 */
//	@Autowired
//	HelloFormValidator HelloFormValidator;
	
	/*
	 * @ModelAttributeを付与することで、Handlerメソッドが実行されるたびに実行され
	 * 返却したオブジェクトがModelに格納される仕組みになっている。
	 */
	@ModelAttribute 
	public LoginForm setUpLoginForm() {
		return new LoginForm();
	}
	
	/*
	 * @InitBinderは初期化のタイミングで実行される。
	 * WebDataBinderに追加することでバリデーターが実行される。
	 */
//	@InitBinder
//	 public void initBinder(WebDataBinder binder) {
//	binder.addValidators(HelloFormValidator); 
//	}
	
	/*
	 * path="" により、リクエストパスを指定する。
	 * method=　ではRequestMethod.GET　または　RequestMethod.POSTを指定する。
	 * 検索画面での検索条件のリクエストではGETを、入力項目のサブミットの場合ではPOSTを指定する。
	 */
	
	/*
	 * Viewにてフォームオブジェクトとのバインディングをしている場合は
	 * 引数にそのフォームオブジェクトを定義する。
	 */
	@RequestMapping(path="/", method=RequestMethod.GET)
	public String index(LoginForm form){
		
		return "login";
	}
	
	@RequestMapping(path="login", method=RequestMethod.POST)
	
	/*
	 * @Validated LoginForm form
	 * HTML formから送信されたリクエストパラメータは、フォームオブジェクトにバインドし、
	 * Controllerのハンドラメソッドの引数に渡すことができる。
	 * @Validated　にて入力チェックを行う。
	 */
	
	/*
	 * BindingResult result を上記の直後にBindingResultを定義する。
	 * エラー情報が格納される。
	 */
	public String send( 
		@Validated LoginForm form,
		BindingResult result) {
		
		return "login";
		
	}
	


}
