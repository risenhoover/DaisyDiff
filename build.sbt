// DaisyDiff build file
// w. p. risenhoover

lazy val root = (project in file("."))
  .settings(
    name := "DaisyDiff",
    scalaVersion := "2.12.7",
    version := "1.0-SNAPSHOT"
  )
  .settings(
        publishArtifact in (Compile, packageDoc) := false,
        publishArtifact in packageDoc := false,
        sources in (Compile,doc) := Seq.empty
    )

// skip javadoc on stage
// https://www.scala-sbt.org/sbt-native-packager/formats/universal.html
mappings in (Compile, packageDoc) := Seq()

resolvers += "LifeRay Public" at "https://repository.liferay.com/nexus/content/repositories/public/"

// https://mvnrepository.com/artifact/nekohtml/nekohtml
libraryDependencies += "nekohtml" % "nekohtml" % "1.9.6.2"
// https://mvnrepository.com/artifact/org.eclipse/org.eclipse.core.runtime
libraryDependencies += "org.eclipse" % "org.eclipse.core.runtime" % "3.3.100.v20070530"
// https://mvnrepository.com/artifact/org.eclipse.equinox/app
libraryDependencies += "org.eclipse.equinox" % "app" % "1.0.0-v20070606"
libraryDependencies += "xerces" % "xercesImpl" % "2.9.1"

// https://mvnrepository.com/artifact/junit/junit
libraryDependencies += "junit" % "junit" % "4.12" % Test
