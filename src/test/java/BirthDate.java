import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.layout.PatternMatch;
import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class BirthDate {
    private final Logger LOGGER = LogManager.getLogger(BirthDate.class);


    @Test
    public void checkLength() {

        String personalCode = "300111-01146";


        if (personalCode.length() < 12) {
            LOGGER.info("Ты ввёл менее 12 знаков");
            return;
        }

        if (personalCode.length() > 12) {
            LOGGER.info("Ты ввёл более 12 знаков");
            return;
        }

        String pattern = "\\d{6}-\\d{5}";
        Pattern codePattern = Pattern.compile(pattern);
        Matcher codeMatcher = codePattern.matcher(personalCode);

        if (codeMatcher.find()) {
        } else {
            LOGGER.info("Неверный формат кода!");
            return;
        }


        String day = personalCode.substring(0, 2).replaceAll("0", "");
        String month = personalCode.substring(2, 4).replaceAll("0", "");
        String year = personalCode.substring(4, 6);
        String century = personalCode.substring(7, 8);


        int dayInt = Integer.parseInt(day);
        int monthInt = Integer.parseInt(month);
        int yearInt = Integer.parseInt(year);
        int centuryInt = Integer.parseInt(century);

        if (dayInt > 31 | dayInt < 1) {
            LOGGER.info("Некорректное число");
            return;
        }
        if (monthInt > 12 | monthInt < 1) {
            LOGGER.info("Некорректный месяц");
            return;
        }
        if (centuryInt > 1) {
            LOGGER.info("Ты терминатор из будущего?");
            return;
        }
        if (centuryInt < 1) {
            LOGGER.info("Так долго не живут!");
            return;
        }

        if (monthInt == 2 && dayInt > 29) {
            LOGGER.info("Слишком долгий февраль");
            return;
        }


        switch (monthInt) {
            case 1:
                month = "января";
                break;
            case 2:
                month = "февраля";
                break;
            case 3:
                month = "марта";
                break;
            case 4:
                month = "апреля";
                break;
            case 5:
                month = "мая";
                break;
            case 6:
                month = "июня";
                break;
            case 7:
                month = "июля";
                break;
            case 8:
                month = "августа";
                break;
            case 9:
                month = "сентября";
                break;
            case 10:
                month = "октября";
                break;
            case 11:
                month = "ноября";
                break;
            case 12:
                month = "декабря";
                break;
        }

        if (centuryInt == 0) {
            year = "18" + year;
        }
        if (centuryInt == 1) {
            year = "19" + year;
        }
        if (centuryInt == 2) {
            year = "20" + year;
        }

        LOGGER.info("Твоя дата рождения : " + day + " " + month + " " + year + " года");

    }


}



