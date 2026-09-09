/*
 * Copyright (C) 2026 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package doclava;

import com.google.clearsilver.jsilver.JSilver;
import com.google.clearsilver.jsilver.data.Data;
import com.google.clearsilver.jsilver.resourceloader.FileSystemResourceLoader;

import junit.framework.TestCase;

import java.io.File;

/**
 * Unit tests verifying that Doclava's since_tags macro renders the expected HTML for various
 * API levels and SDK extension versions.
 */
public class ApiVersionRenderingTest extends TestCase {

  private static final String TEMPLATE_CONTENT =
      "<?cs include:\"macros.cs\" ?><?cs call:since_tags(obj) ?>";

  private JSilver jSilver;

  @Override
  protected void setUp() throws Exception {
    super.setUp();
    File templateDir = new File("external/doclava/res/assets/templates");
    if (!templateDir.exists()) {
      templateDir = new File("res/assets/templates");
    }
    assertTrue(
        "Templates directory not found. Expected at external/doclava/res/assets/templates or res/assets/templates",
        templateDir.exists());
    jSilver = new JSilver(new FileSystemResourceLoader(templateDir.getAbsolutePath()));
  }

  private String renderSince(String since, String sdkExtSince) {
    Data data = jSilver.createData();
    data.setValue("reference.apilevels", "true");
    data.setValue("toroot", "/");
    if (since != null) {
      data.setValue("obj.since", since);
    }
    if (sdkExtSince != null) {
      data.setValue("obj.sdkextsince", sdkExtSince);
    }
    try {
      return jSilver.renderFromContent(TEMPLATE_CONTENT, data).trim();
    } catch (Exception e) {
      throw new RuntimeException("Failed to render Doclava template", e);
    }
  }

  public void testUnfinalizedApi() {
    String rendered = renderSince("10000", null);
    assertEquals(
        "<a href=\"/guide/topics/manifest/uses-sdk-element.html#ApiLevels\">API under development</a>",
        rendered);
  }

  public void testUnfinalizedApi_WithSdkExtension() {
    String rendered = renderSince("10000", "R Extensions 4");
    assertEquals("Added in <a href=\"/sdkExtensions\">R Extensions 4</a>", rendered);
  }

  public void testFinalizedApil() {
    String rendered = renderSince("35", null);
    assertEquals(
        "Added in <a href=\"/guide/topics/manifest/uses-sdk-element.html#ApiLevels\">API level 35</a>",
        rendered);
  }

  public void testFinalizedApi_WithSdkExtension() {
    String rendered = renderSince("35", "R Extensions 4");
    assertEquals(
        "Added in <a href=\"/guide/topics/manifest/uses-sdk-element.html#ApiLevels\">API level 35</a>"
            + "<br/>Also in <a href=\"/sdkExtensions\">R Extensions 4</a>",
        rendered);
  }

  public void testFinalizedMinorApi() {
    String rendered = renderSince("36.1", null);
    assertEquals(
        "Added in <a href=\"/topic/libraries/support-library/revisions.html\">version 36.1</a>",
        rendered);
  }

  public void testLegacyPreviewCodename() {
    String rendered = renderSince("VanillaIceCream", null);
    assertEquals(
        "<a data-version-added=\"VanillaIceCream\" href=\"/preview/\">"
            + "<b>Added in Android VanillaIceCream</b></a>",
        rendered);
  }

  public void testSdkExtensionOnly() {
    String rendered = renderSince(null, "R Extensions 4");
    assertEquals("Added in <a href=\"/sdkExtensions\">R Extensions 4</a>", rendered);
  }

  public static void main(String[] args) {
    junit.textui.TestRunner.run(ApiVersionRenderingTest.class);
  }
}
