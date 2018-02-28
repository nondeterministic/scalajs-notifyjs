lazy val root = project.in(file(".")).
	enablePlugins(ScalaJSPlugin)

name := "scalajs-notifyjs"
scalaVersion := "2.12.3" // or any other Scala version >= 2.10.2

organization := "com.github.nondeterministic"

name := "Scala.js notifyjs"
normalizedName := "scalajs-notifyjs"

version := "0.1.1"

libraryDependencies += "be.doeraene" %%% "scalajs-jquery" % "0.9.2"

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

scalacOptions += "-P:scalajs:sjsDefinedByDefault"
