import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Test;
import org.w3c.dom.ls.LSOutput;

public class BirthDate {

    @Test
    public void fullBirthDate(char[] num) {
//        get number of digits in given number
        int len = num.length;
        if (len < 11)
        {
            System.out.println("Personal code number is too short");
            return;
        }

        if (len > 11)
        {
            System.out.println("Personal code number is too long");

        }

        // to be continued..
    }


}


//08088811146
// 3.  подать персональный код старого образца и по нему бы появилась строка в консоле с полной датой рожения, например: "Твоя дата рождения: 27 января 2020 года"