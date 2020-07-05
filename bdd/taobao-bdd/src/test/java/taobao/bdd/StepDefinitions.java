package taobao.bdd;

import io.cucumber.java.zh_cn.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.*;

public class StepDefinitions {
    WebDriver driver = new FirefoxDriver();

    @假定("我没有打开浏览器")
    public void 我没有打开浏览器() {
        // Write code here that turns the phrase above into concrete actions
     //   throw new io.cucumber.java.PendingException();
    }

    @当("打开浏览器并输入{string}的时候")
    public void 打开浏览器并输入_的时候(String url) {
        this.driver.get(url);
    }

    @那么("浏览器的标签包含{string}")
    public void 浏览器的标签包含(String title) {
        String pageTitle = this.driver.getTitle();
        assert(pageTitle).contains(title);
    }

    @那么("当前网址以{string}作为开头")
    public void 当前网址以_作为开头(String url) {
        String currentURL = this.driver.getCurrentUrl();
        assert(currentURL).startsWith(url);
    }

    @那么("关闭浏览器")
    public void 关闭浏览器(){
        this.driver.quit();
    }

}
