import org.junit.jupiter.api.*;

import java.util.Random;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class LcwaikikiSepetTest extends BaseTest{

    HomePage homePage;
    LoginPage loginPage;
    ProductPage productPage;
    ProductDetailPage productDetailPage;
    CartPage cartPage;

    @Test
    @Order(1)
    public  void homeControl() throws InterruptedException {
        Thread.sleep(2000);
        homePage = new HomePage(driver);
        Assertions.assertEquals(homePage.homePageControl(),"https://www.lcwaikiki.com/tr-TR/TR", "Anasayfada degilsiniz.");
    }

    @Test
    @Order(2)
    public void login_control() throws InterruptedException {
        Thread.sleep(2000);
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        homePage.loginClick();
        loginPage.login();
        Assertions.assertEquals("Hesabım", loginPage.LoginPageControl(), "Uye girisi yapilamadi.");
    }

    @Test
    @Order(3)
    public void urun_ara() throws InterruptedException {
        Thread.sleep(2000);
        homePage = new HomePage(driver);
        productPage = new ProductPage(driver);
        homePage.searchBox().search("Pantolon");
        Assertions.assertTrue(productPage.ProductPageControl(), "Urun sayfasinda degilsiniz.");
    }

    @Test
    @Order(4)
    public void urun_sec() throws InterruptedException {
        Thread.sleep(2000);
        productPage = new ProductPage(driver);
        productDetailPage = new ProductDetailPage(driver);
        productPage.daha_fazla_gor();
        Random r=new Random();
        int a=r.nextInt(productPage.productListSize);
        productPage.productSelect(a);
        Assertions.assertTrue(productDetailPage.ProductDetailPageControl(), "Urun detay sayfasinda degilsiniz.");
    }

    @Test
    @Order(5)
    public void sepete_ekle() throws InterruptedException {
        Thread.sleep(2000);
        homePage = new HomePage(driver);
        productDetailPage = new ProductDetailPage(driver);
        productDetailPage.addToCart();
        Thread.sleep(2000);
        Assertions.assertEquals("1", homePage.ProductCountControl(), "Sepete urun eklenemedi.");
    }

    @Test
    @Order(6)
    public void sepet_control() throws InterruptedException {
        Thread.sleep(2000);
        homePage = new HomePage(driver);
        productDetailPage = new ProductDetailPage(driver);
        cartPage = new CartPage(driver);
        homePage.goToCart();
        Assertions.assertEquals(ProductDetailPage.productDetailPrice, cartPage.cartPriceLocator(), "Sepetteki urun fiyati farkli.");
    }

    @Test
    @Order(7)
    public void sepette_urun_arttirma() throws InterruptedException {
        Thread.sleep(2000);
        cartPage = new CartPage(driver);
        cartPage.countUpProduct();
        Assertions.assertEquals("2",cartPage.CartCountControl(), "Sepette urun adedi artmadi.");
    }

    @Test
    @Order(8)
    public void sepet_bosalt() throws InterruptedException {
        Thread.sleep(2000);
        cartPage = new CartPage(driver);
        cartPage.emptyToCart();
        Thread.sleep(2000);
        Assertions.assertTrue(cartPage.CartIsEmpty(), "Sepette urun kaldi.");
    }











}
