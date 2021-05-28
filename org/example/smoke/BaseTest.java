package org.example.smoke;

import org.example.init.BaseClass;
import org.example.pages.LandingPage;
import org.example.pages.Register;
import org.testng.annotations.BeforeClass;

public class BaseTest extends BaseClass
{
    LandingPage landingPage;
    Register register;
    public BaseTest()
    {
        super();
    }

    @BeforeClass(alwaysRun = true)
    public void setUp()
    {
        Initialize();
        landingPage= new LandingPage();
        register= new Register();
    }

}
