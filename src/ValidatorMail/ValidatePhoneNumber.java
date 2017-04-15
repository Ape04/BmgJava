/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//       '/^[0-9]{8}$/'
package ValidatorMail;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Haroun
 */
public class ValidatePhoneNumber {

    public static boolean ValidatePhoneNumber(String email) {
        boolean status2 = false;
        String PHONE_PATTERN = "/^[0-9]{8}$/";
        Pattern pattern = Pattern.compile(PHONE_PATTERN);
        Matcher matcher = pattern.matcher(email);
        if (matcher.matches()) {
            status2 = true;
        } else {
            status2 = false;
        }
        return status2;
    }
}
