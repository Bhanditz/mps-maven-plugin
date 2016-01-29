package org.jetbrains.mps.tool.builder;

/*Generated by MPS */

import jetbrains.mps.tool.common.ScriptProperties;
import org.apache.log4j.Level;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Script {
  private final Set<File> myModels = new LinkedHashSet<File>();
  private final Set<File> myModules = new LinkedHashSet<File>();
  private final Set<File> myExcludedFromDiff = new LinkedHashSet<File>();
  private final Map<File, List<String>> myMPSProjects = new LinkedHashMap<File, List<String>>();
  private boolean myFailOnError = true;
  private final Map<String, String> myMacro = new LinkedHashMap<String, String>();
  private Level myLogLevel = Level.INFO;
  private final Map<String, String> myProperties = new LinkedHashMap<String, String>();
  private final List<String> myParameters = new ArrayList<String>();
  private boolean myLoadBootstrapLibraries = true;
  private final Map<List<String>, Boolean> myChunks = new LinkedHashMap<List<String>, Boolean>();
  private final List<String> myLibraryJars = new ArrayList<String>();
  public Script() {
  }
  public void addModuleFile(File file) {
    assert file.exists() && !(file.isDirectory()) : "bad file: " + file.toString();
    myModules.add(file);
  }
  public void addModelFile(File file) {
    assert file.exists() && !(file.isDirectory()) : "bad file: " + file.toString();
    myModels.add(file);
  }
  public void excludeFileFromDiff(File file) {
    assert file.exists() && !(file.isDirectory());
    myExcludedFromDiff.add(file);
  }
  public void addProjectFile(File projectFile) {
    assert projectFile.exists() && projectFile.isFile();
    if (!(myMPSProjects.containsKey(projectFile))) {
      myMPSProjects.put(projectFile, new ArrayList<String>());
    }
  }
  public void addProjectFile(File projectFile, String... property) {
    assert projectFile.exists() && projectFile.isFile();
    List<String> projectProperties = myMPSProjects.get(projectFile);
    if (projectProperties == null) {
      projectProperties = new ArrayList<String>();
      myMPSProjects.put(projectFile, projectProperties);
    }
    projectProperties.addAll(Arrays.asList(property));
  }
  public void addChunk(List<String> modules, boolean isBootstrap) {
    myChunks.put(modules, isBootstrap);
  }
  public void addLibraryJar(String libraryJar) {
    myLibraryJars.add(libraryJar);
  }

  public Set<File> getModels() {
    return Collections.unmodifiableSet(myModels);
  }
  public void updateModels(Set<File> models) {
    myModels.addAll(models);
  }
  public Set<File> getExcludedFromDiffFiles() {
    return Collections.unmodifiableSet(myExcludedFromDiff);
  }
  public void updateExcludedFromDiffFiles(Set<File> excluded) {
    myExcludedFromDiff.addAll(excluded);
  }
  public Set<File> getModules() {
    return Collections.unmodifiableSet(myModules);
  }
  public void updateModules(Set<File> modules) {
    myModules.addAll(modules);
  }
  public Map<File, List<String>> getMPSProjectFiles() {
    return Collections.unmodifiableMap(myMPSProjects);
  }
  public void updateMPSProjectFiles(Map<File, List<String>> mpsProjects) {
    myMPSProjects.putAll(mpsProjects);
  }
  public boolean getFailOnError() {
    return myFailOnError;
  }
  public void updateFailOnError(boolean showError) {
    myFailOnError = showError;
  }
  public Map<String, String> getProperties() {
    return Collections.unmodifiableMap(myProperties);
  }
  public void updateProperties(Map<String, String> properties) {
    myProperties.putAll(properties);
  }

  public void addMacro(String name, String value) {
    myMacro.put(name, value);
  }
  public Map<String, String> getMacro() {
    return Collections.unmodifiableMap(myMacro);
  }
  public void updateMacro(Map<String, String> macro) {
    myMacro.putAll(macro);
  }
  public void updateLogLevel(Level level) {
    myLogLevel = level;
  }
  public Level getLogLevel() {
    return myLogLevel;
  }
  public void addParameter(String parameter) {
    myParameters.add(parameter);
  }
  public List<String> getParameters() {
    return myParameters;
  }
  public void updateParameters(List<String> parameters) {
    myParameters.addAll(parameters);
  }
  public boolean isLoadBootstrapLibraries() {
    return myLoadBootstrapLibraries;
  }
  public void setLoadBootstrapLibraries(boolean load) {
    myLoadBootstrapLibraries = load;
  }
  public Map<List<String>, Boolean> getChunks() {
    return Collections.unmodifiableMap(myChunks);
  }
  public void updateChunks(Map<List<String>, Boolean> chunks) {
    myChunks.putAll(chunks);
  }
  public List<String> getLibraryJars() {
    return Collections.unmodifiableList(myLibraryJars);
  }
  public void updateLibraryJars(List<String> libraryJars) {
    myLibraryJars.addAll(libraryJars);
  }
  public void cloneTo(Object dest) {
    // TODO get rid of generic cloneTo 
    Class<? extends Script> srcClass = this.getClass();
    Class<? extends Object> destClass = dest.getClass();
    Method[] srcMethods = srcClass.getMethods();
    for (Method srcMethod : srcMethods) {
      String srcMethodName = srcMethod.getName();
      if (srcMethodName.startsWith("get")) {
        String dstMethodName = srcMethodName.replace("get", "update");
        try {
          Method destMethod = destClass.getMethod(dstMethodName, srcMethod.getReturnType());
          destMethod.invoke(dest, srcMethod.invoke(this));
        } catch (NoSuchMethodException e) {
          //  doing nothing 
        } catch (InvocationTargetException e) {
          throw new IllegalArgumentException("cannot clone", e);
        } catch (IllegalAccessException e) {
          throw new IllegalArgumentException("cannot clone", e);
        }
      }
    }
  }

  public void putProperty(String name, String value) {
    myProperties.put(name, value);
  }
  public String getProperty(String name) {
    return myProperties.get(name);
  }
  public void addPerfomanceReport(String s) {
    String reports = myProperties.get(ScriptProperties.GENERATE_PERFORMANCE_REPORT);
    if (reports == null) {
      reports = "";
    }
    if (!(reports.isEmpty())) {
      reports += ",";
    }
    reports += s;
    myProperties.put(ScriptProperties.GENERATE_PERFORMANCE_REPORT, reports);
  }

}