package com.runner;

import com.tests.basicResponse;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.SuiteDisplayName;
import org.junit.runner.RunWith;


@RunWith(JUnitPlatform.class)
@SuiteDisplayName("Smoke Suite")
@SelectPackages({"com.basePage", "com.pojo", "com.utilities", "com.tests"})
@SelectClasses( {basicResponse.class} )
@IncludeTags({"smoke", "regression"})

public class baseRunner {
}
