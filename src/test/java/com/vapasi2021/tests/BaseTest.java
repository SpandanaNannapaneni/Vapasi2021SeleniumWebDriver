package com.vapasi2021.tests;

import com.vapasi2021.helpers.Driver;
import com.vapasi2021.pages.LoginPage;

public class BaseTest extends Driver {

    LoginPage loginPage = new LoginPage(driver);
}
