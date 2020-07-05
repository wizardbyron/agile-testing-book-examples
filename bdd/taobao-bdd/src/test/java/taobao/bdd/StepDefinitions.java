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

    @当("打开浏览器并输入 http:\\/\\/www.taobao.com 的时候")
    public void 打开浏览器并输入_http_www_taobao_com_的时候() {
        this.driver.get("http://www.taobao.com");
    }
    @那么("我可以进入淘宝网首页")
    public void 我可以进入淘宝网首页() {
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
    }
}