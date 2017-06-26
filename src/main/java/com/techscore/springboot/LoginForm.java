package com.techscore.springboot;

import java.io.Serializable;

import javax.servlet.ServletRegistration;

import org.hibernate.validator.constraints.NotBlank;

import javassist.SerialVersionUID;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


/*
 * フォームオブジェクトはJavaBeanとして作成する。
 * Spring Frameworkでは、HTML formから送信されたリクエストパラメータ(文字列)を、
 * フォームオブジェクトに定義されている型に変換してからバインドする機能を提供しているため、 
 * フォームオブジェクトに定義するフィールドの型は、java.lang.Stringだけではなく、任意の型で定義することができる。
 */


/*
 * Formクラスではlombokを利用するため、クラスに@Dataを付す。
 * @Data でクラスをアノテートすることで、 getter, setter, toString などのメソッドが自動生成されている。
 */

@Data
public class LoginForm implements Serializable{
	
	/*
	 * フォームオブジェクトをセッションスコープで管理する場合だが、使用するスコープに関係なく
	 * Serializableを実装しておく。
	 */
	private static final long SerialVersionUID = 1L;
	
	/*
	 *　フォームオブジェクトには画面に表示のみ行う項目は保持せず、
	 *　HTML formの項目のみ保持することを推奨する。
	 * フォームオブジェクトに画面表示のみ行う項目の値を設定した場合、
	 * フォームオブジェクトをHTTPセッションオブジェクトに格納する際にメモリを多く消費する事になり、メモリ枯渇の原因になる可能性がある。
	 * 画面表示のみの項目は、
	 * Entityなどのドメイン層のオブジェクトをリクエストスコープに追加(Model.addAttribute)することで
	 * HTML(JSP)にデータを渡すことを推奨する。 
	 */
	@NotBlank
	private String id;
	
	@NotBlank
	private String password;
	
}
	