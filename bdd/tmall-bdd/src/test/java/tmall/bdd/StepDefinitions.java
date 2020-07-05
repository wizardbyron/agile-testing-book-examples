package tmall.bdd;

import io.cucumber.java.zh_cn.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class StepDefinitions {
    WebDriver driver = new FirefoxDriver();

    @假定("我没有打开浏览器")
    public void 我没有打开浏览器() {

    }

    @当("打开浏览器并输入{string}的时候")
    public void 打开浏览器并输入_的时候(String url) {
        driver.get(url);
    }

    @那么("我可以进入天猫首页")
    public void 我可以进入天猫首页() {
        当前网址以_作为开头("https://www.tmall.com");
        this.driver.quit();
    }

    @那么("当前网址以{string}作为开头")
    public void 当前网址以_作为开头(String url) {
        String currentURL = this.driver.getCurrentUrl();
        assert(currentURL).startsWith(url);
    }


}
