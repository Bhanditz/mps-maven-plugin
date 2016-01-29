package org.jetbrains.mps.tool.builder;

/*Generated by MPS */


/**
 * Facility to pass generator parameters from ant task to actual worker via script
 */
public final class GeneratorProperties {
  private static final String TRANSFORM_IN_PLACE = "in-place";
  private static final String THREAD_COUNT = "parallel.threads";
  private static final String NO_WARNINGS = "noWarnings";
  private static final String STRICT_MODE = "STRICT_MODE";
  private static final String PARALLEL_MODE = "PARALLEL_MODE";
  /**
   * Counterpart for IGenerationSettings#createStaticReferences()
   */
  private static final String USE_STATIC_REFS = "use-static-refs";

  private Script myScript;

  public GeneratorProperties(Script script) {
    myScript = script;
  }
  public GeneratorProperties setStrictMode(boolean strictMode) {
    myScript.putProperty(STRICT_MODE, Boolean.toString(strictMode));
    return this;
  }
  public boolean isStrictMode() {
    return Boolean.parseBoolean(myScript.getProperty(STRICT_MODE));
  }
  public GeneratorProperties setParallelMode(boolean parallelMode) {
    myScript.putProperty(PARALLEL_MODE, Boolean.toString(parallelMode));
    return this;
  }
  public boolean isParallelMode() {
    return Boolean.parseBoolean(myScript.getProperty(PARALLEL_MODE));
  }
  public GeneratorProperties setParallelThreads(int threadsCount) {
    myScript.putProperty(THREAD_COUNT, Integer.toString(threadsCount));
    return this;
  }
  public int getParallelThreads() {
    try {
      return Integer.parseInt(myScript.getProperty(THREAD_COUNT));
    } catch (NumberFormatException ex) {
      return 2;
    }
  }
  public GeneratorProperties setInplaceTransform(boolean inplaceEnabled) {
    myScript.putProperty(TRANSFORM_IN_PLACE, Boolean.toString(inplaceEnabled));
    return this;
  }
  public boolean isInplaceTransform() {
    return Boolean.parseBoolean(myScript.getProperty(TRANSFORM_IN_PLACE));
  }
  public GeneratorProperties setHideWarnings(boolean enabled) {
    myScript.putProperty(NO_WARNINGS, Boolean.toString(enabled));
    return this;
  }
  public boolean isHideWarnings() {
    return Boolean.parseBoolean(myScript.getProperty(NO_WARNINGS));
  }
  public GeneratorProperties setCreateStaticRefs(boolean useStaticFefs) {
    myScript.putProperty(USE_STATIC_REFS, Boolean.toString(useStaticFefs));
    return this;
  }
  public boolean isCreateStaticRefs() {
    return Boolean.parseBoolean(myScript.getProperty(USE_STATIC_REFS));
  }
}
