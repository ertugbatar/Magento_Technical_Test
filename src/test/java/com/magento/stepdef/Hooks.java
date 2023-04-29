package com.magento.stepdef;

import com.magento.utilities.Driver;
import org.junit.After;
import org.junit.Before;

import java.util.concurrent.TimeUnit;

public class Hooks {


    @Before()
    public void setUp() {
        // we put a logic that should apply to every scenario
        Driver.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @After()
    public void tearDown() {
        // only takes a screenshot if the scenario fails

        Driver.closeDriver();
    }

}
