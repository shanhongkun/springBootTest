/**
 * 
 */
package com.techscore.springboot;


import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * @author Me
 *
 */

/*
 * @Componentにより自動スキャンされDIコンテナに登録される。
 */

/*
 * 相関チェックおよび業務ロジックチェックを実装する。
 * 業務ロジックチェックに関して、当該チェックは必ず当該クラスに実装し、業務ロジックは
 * サービスに実装すること。
 * 
 */
@Component
public class HelloFormValidator implements Validator{
	
	/*
	 * チェック対象のクラスを指定する。
	 */
    public boolean supports(Class<?> clazz) {
        return HelloForm.class.isAssignableFrom(clazz); 
    }

    @Override
    public void validate(Object target, Errors errors) {
    	
    	/*
    	 * アノテーションでのエラーがある場合に処理することができる。
    	 */
    	if (errors.hasFieldErrors("pass")) {
    		return;
    	}
    	
    	/*
    	 * チェックロジックを実装する。
    	 */
        HelloForm form = (HelloForm) target;
        String password = form.getPass();
        String confirmPassword = form.getPassConfirm();

        if (password == null || confirmPassword == null) {
            return;
        }
        
        /*
         * 第一引数に対象のフィールド名を、第二引数にエラーメッセージのキーを設定する。
         */
        if (!password.equals(confirmPassword)) {
            errors.rejectValue("passConfirm","passConfirmError");
        }
        
    }
	
}
