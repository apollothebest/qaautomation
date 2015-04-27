/**
 * Created by apollo on 27.04.2015.
 */
import org.openqa.selenium.By;

public interface Locators {
        By LOGIN = By.id("mailbox_login");
        By PASSWORD = By.id("mailbox_password");
        By LOGOUT = By.id("PH_logoutLink");
        By MBPASSWORD = By.id("mailbox__password");
        By AUTHBUTTON = By.id("mailbox__auth__button");
        By LOGOUTLINK = By.id("PH_logoutLink");
}
