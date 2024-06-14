package org.example.demospringbootapi.utils.validations.password;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.passay.*;

import java.util.Arrays;

public class PasswordConstraintValidator implements ConstraintValidator<ValidPassword, String> {

    @Override
    public void initialize(ValidPassword arg0){}

    @Override
    public boolean isValid(String password, ConstraintValidatorContext context){ //Devuelve true o false si pasa o no pasa la validacion
        PasswordValidator validator = new PasswordValidator(Arrays.asList(
                new LengthRule(8, 30),
                // at least one upper-case character
                new CharacterRule(EnglishCharacterData.UpperCase, 1),
//                new UppercaseCharacterRule(1),
                // at least one lower-case character
                //new CharacterRule(EnglishCharacterData.LowerCase, 1),

                // at least one digit character
                new CharacterRule(EnglishCharacterData.Digit, 1),
//                new DigitCharacterRule(1),
                // at least one symbol (special character)
                new CharacterRule(EnglishCharacterData.Special, 1),
//                new SpecialCharacterRule(1),

                // define some illegal sequences that will fail when >= 5 chars long
                // alphabetical is of the form 'abcde', numerical is '34567', qwery is 'asdfg'
                // the false parameter indicates that wrapped sequences are allowed; e.g. 'xyzabc'
                new IllegalSequenceRule(EnglishSequenceData.Alphabetical, 3, false),
                new IllegalSequenceRule(EnglishSequenceData.Numerical, 3, false),
                new IllegalSequenceRule(EnglishSequenceData.USQwerty, 3, false),
//                new NumericalSequenceRule(3, false),
//                new AlphabeticalSequenceRule(3,false),

                new WhitespaceRule()));
        RuleResult result = validator.validate(new PasswordData(password));
        if (result.isValid()){
            return true;
        }
        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate(
                String.join(",", validator.getMessages(result)))
                        .addConstraintViolation();
        return false;
    }
}
