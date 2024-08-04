package pacifico.mvm.constraints.validators;
import java.util.HashSet;
import java.util.Set;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import pacifico.mvm.constraints.Username;

/**
* @author Matheus Pacifico
*/
public class UsernameValidator implements ConstraintValidator<Username, CharSequence> {
	
	//Violation messages
	private static final String BLANK_USERNAME = "username cannot be blank.";
	private static final String CHAR_NOT_ALLOWED = "username can only use lowercase letters, numbers, underscores and periods.";
	private static final String TOO_LONG = "username can be a maximum of 30 characters.";
	private static final String CONSECUTIVE_PERIODS = "username cannot have more than one period in a row.";
	private static final String START_WITH_PERIOD = "username cannot start with a period.";
	private static final String END_WITH_PERIOD = "username cannot end with a period.";
	
	private static final Set<String> RESERVED_WORDS;
	
	private boolean checkReservedWord;

    @Override
    public void initialize(Username annotation) {
    	this.checkReservedWord = annotation.checkReservedWord();
	}
    
	@Override
	public boolean isValid(CharSequence value, ConstraintValidatorContext context) {
		if (value == null || value.isEmpty()) {
			buildConstraintViolationWithTemplate(context, BLANK_USERNAME);
			 return false;
		} else if (value.length() > 30) {
			buildConstraintViolationWithTemplate(context, TOO_LONG);
		}
		return !(containsNotAllowedCharacter(value, context) || (checkReservedWord && isReservedWord(value, context)));
	}

	public static boolean containsNotAllowedCharacter(CharSequence str, ConstraintValidatorContext context) {
		if (theFirstCharacterIsADotOrIsNotAllowed(str.charAt(0), context)) {
			return true; 
		}
		boolean thisCharIsPrecededByDot = false;
		int strLenght = str.length();
		for (int i = 1; i < strLenght; i++) {
			int ch = str.charAt(i);
			if (isAllowedAndNotADot(ch)) {
				thisCharIsPrecededByDot = false;
			} else if (ch == '.') {
				if (thisCharIsPrecededByDot) {
					buildConstraintViolationWithTemplate(context, CONSECUTIVE_PERIODS);
					return true; 
				}
				thisCharIsPrecededByDot = true;
			} else {
				buildConstraintViolationWithTemplate(context, CHAR_NOT_ALLOWED);
				return true;
			}
		}
		if (thisCharIsPrecededByDot) {
			buildConstraintViolationWithTemplate(context, END_WITH_PERIOD);
		}
		return thisCharIsPrecededByDot;
	}
	
	private static boolean theFirstCharacterIsADotOrIsNotAllowed(int ch, ConstraintValidatorContext context) {
		if (ch == '.') {
			buildConstraintViolationWithTemplate(context, START_WITH_PERIOD);
			return true;
		} else if(!isAllowedAndNotADot(ch)) {
			buildConstraintViolationWithTemplate(context, CHAR_NOT_ALLOWED);
			return true;
		}
		return false;
	}
	
	private static void buildConstraintViolationWithTemplate(ConstraintValidatorContext context, String message) {
		context.buildConstraintViolationWithTemplate(message)
		.addConstraintViolation()
		.disableDefaultConstraintViolation();
	}
	
	private static boolean isAllowedAndNotADot(int ch) {
		return ((ch >= 'a' && ch <= 'z') || (ch == '_') 
				|| (ch >= '0' && ch <= '9')); 
	}
	
	public static boolean isAllowed(int ch) {
		return ((ch >= 'a' && ch <= 'z') || (ch == '_') 
				|| (ch >= '0' && ch <= '9') || (ch == '.')); 
	}
	
	public static boolean isReservedWord(CharSequence value, ConstraintValidatorContext context) {
		return RESERVED_WORDS.contains(value.toString());
	}
	
	static {
		RESERVED_WORDS = new HashSet<>(Set.of(
			"about",
			"account",
			"accounts",
			"activate",
			"activity",
			"ad",
			"adm",
			"admin",
			"advertising",
			"analysis",
			"analytics",
			"anon",
			"anonymous",
			"api",
			"app",
			"apps",
			"archive",
			"archives",
			"article",
			"auth",
			"authentication",
			"backup",
			"banner",
			"banners",
			"beta",
			"bin",
			"collection",
			"collections",
			"comment",
			"comments",
			"credential",
			"credentials",
			"dislike",
			"dislikes",
			"facebook",
			"follow",
			"followed",
			"followeds",
			"follower",
			"followers",
			"following",
			"follows",
			"hashtag",
			"hashtags",
			"help",
			"home",
			"instagram",
			"like",
			"likes",
			"list",
			"lists",
			"login",
			"p",
			"place",
			"places",
			"post",
			"posts",
			"privacy",
			"profile",
			"profiles",
			"rate",
			"rates",
			"rating",
			"react",
			"reacts",
			"reaction",
			"reactions",
			"save",
			"saved",
			"saves",
			"support",
			"tag",
			"tags",
			"threads",
			"trailblaze",
			"twitter",
			"user",
			"users",
			"new",
			"x")
		);
	}

}
