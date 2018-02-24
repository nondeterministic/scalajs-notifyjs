lazy val root = project.in(file(".")).
	enablePlugins(ScalaJSPlugin)

name := "scalajs-notifyjs"
scalaVersion := "2.12.3" // or any other Scala version >= 2.10.2

organization := "org.multics.baueran"

name := "Scala.js notifyjs"

normalizedName := "scalajs-notifyjs"

version := "0.1-SNAPSHOT"

libraryDependencies += "be.doeraene" %%% "scalajs-jquery" % "0.9.2"
