lazy val root = project.in(file("."))
  .enablePlugins(ScalaJSPlugin)

name := "scalajs-notifyjs"

crossScalaVersions := {
  val allVersions = Seq("2.12.10", "2.11.12", "2.13.1")
  if (scalaJSVersion.startsWith("0.6."))
    allVersions
  else
    allVersions.filter(!_.startsWith("2.11."))
}

scalaVersion := "2.13.1"

organization := "com.github.nondeterministic"

name := "Scala.js notifyjs"
normalizedName := "scalajs-notifyjs"

version := "0.2.0"

libraryDependencies += "be.doeraene" %%% "scalajs-jquery" % "1.0.0"

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

// useGpg := true

isSnapshot := false
