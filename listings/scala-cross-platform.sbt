import sbtcrossproject.CrossPlugin.autoImport.crossProject

lazy val root = project(file("."))
    .crossProject(JSPlatform, JVMPlatform, NativePlatform)
    .settings(
      name := "project-name",
      scalaVersion := "3.2.1",
    )
