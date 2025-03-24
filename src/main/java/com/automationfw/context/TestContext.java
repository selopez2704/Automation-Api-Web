package com.automationfw.context;

import java.util.HashMap;
import java.util.Map;

public class TestContext {
  private Map<String, Object> contextMap;

  public TestContext() {
    contextMap = new HashMap<>();
  }

  public void set(String key, Object value) {
    contextMap.put(key, value);
  }

  public Object get(String key) {
    return contextMap.get(key);
  }
}
