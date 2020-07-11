package tmall.bdd;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.zh_cn.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.List;


public class StepDefinitions {
    WebDriver driver;

    @假定("我没有打开浏览器")
    public void 我没有打开浏览器() {
    }

    @当("打开浏览器并输入{string}的时候")
    public void 打开浏览器并输入_的时候(String url) {
        this.driver.get(url);
    }

    @那么("我可以进入天猫首页")
    public void 我可以进入天猫首页() {
        当前网址以_作为开头("https://www.tmall.com");
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

    @当("我在搜索框输入{string}")
    public void 我在搜索框输入(String keyword) {
        this.driver.findElement(By.id("mq")).sendKeys(keyword);
    }

    @当("点击\"搜索\"按钮后")
    public void 点击_搜索_按钮后() {
        this.driver.findElement(By.cssSelector("div.mallSearch-input.clearfix")).findElement(By.tagName("Button")).click();
    }

    @那么("我应该在搜索结果页看到含有{string}为名称的商品")
    public void 我应该在搜索结果页看到含有_为名称的商品(String keyword) {
        List<WebElement> titles = this.driver.findElements(By.className("productTitle"));
        Boolean result = false; //默认为失败
        for (WebElement t : titles) {
            if (t.getText().contains(keyword)){
                result = true;
                break; // 找到一个就算成功
            }
        }
        assert(result);
    }

    @Before()
    public void openBrowser(){
        FirefoxOptions options = new FirefoxOptions();
        options.setHeadless(true);
        this.driver = new FirefoxDriver(options);
    }

    @After()
    public void closeBrowser() {
        driver.quit();
    }
}
