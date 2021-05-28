package org.example.smoke;

import org.testng.annotations.Test;

public class Test1 extends BaseTest
{
    @Test(priority = 1)
    public void TitleTest() {
        landingPage.SignUP();
    }

    @Test(priority = 2)
    public void SignUpTest()
    {
        //landingPage.SignUP();
        register.RegisterCRM("sushobhanworld@gmail.com", "9731950640");
    }
}
