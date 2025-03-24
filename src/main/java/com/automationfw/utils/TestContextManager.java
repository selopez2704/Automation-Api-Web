package com.automationfw.utils;

import com.automationfw.context.TestContext;
import lombok.experimental.UtilityClass;

@UtilityClass
public class TestContextManager {

  public static final ThreadLocal<TestContext> testContextThreadLocal = new ThreadLocal<>();

  public static TestContext getTestContext() {
    if (testContextThreadLocal.get() == null) {
      testContextThreadLocal.set(new TestContext());
    }
    return testContextThreadLocal.get();
  }
}
