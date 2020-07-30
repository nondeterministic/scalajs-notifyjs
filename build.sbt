lazy val root = project.in(file("."))
  .enablePlugins(ScalaJSPlugin,JSDependenciesPlugin)

name := "scalajs-notifyjs"

crossScalaVersions in ThisBuild := {
  val allVersions = Seq("2.12.10", "2.11.12", "2.10.7", "2.13.1")
  if (scalaJSVersion.startsWith("0.6."))
    allVersions
  else
    allVersions.filter(!_.startsWith("2.10."))
}

scalaVersion := "2.13.1"

organization := "com.github.nondeterministic"

name := "Scala.js notifyjs"
normalizedName := "scalajs-notifyjs"

version := "0.2.0"

libraryDependencies += "be.doeraene" %%% "scalajs-jquery" % "1.0.0"
libraryDependencies += "com.lihaoyi" %%% "utest" % "0.7.4" % "test"

testFrameworks += new TestFramework("utest.runner.Framework")

jsDependencies += "org.webjars" % "jquery"   % "2.2.4" / "2.2.4/jquery.js"
jsDependencies += "org.webjars" % "notifyjs" % "0.4.2" / "0.4.2/notify.js"

// POM settings for Sonatype
homepage := Some(url("https://github.com/nondeterministic/scalajs-notifyjs"))

scmInfo := Some(ScmInfo(url("https://github.com/nondeterministic/scalajs-notifyjs"),
                            "git@github.com:nondeterministic/scalajs-notifyjs.git"))
			    
developers := List(Developer("nondeterministic",
                             "Andreas Bauer",
                             "baueran@gmail.com",
                             url("https://github.com/nondeterministic")))
			     
licenses += ("MIT License", url("http://www.opensource.org/licenses/mit-license.php"))

publishMavenStyle := true

publishTo := {
  val nexus = "https://oss.sonatype.org/"
  if (isSnapshot.value)
    Some("snapshots" at nexus + "content/repositories/snapshots")
  else
    Some("releases"  at nexus + "service/local/staging/deploy/maven2")
}

useGpg := true

isSnapshot := false
