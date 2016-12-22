import scalariform.formatter.preferences._
import com.typesafe.sbt.SbtScalariform
import com.typesafe.sbt.SbtScalariform.ScalariformKeys

name := "akka-http-jsonapi-example"
organization := "io.bitflips"
version := "0.1"
scalaVersion := "2.11.8"

resolvers ++= Seq(Resolver.sonatypeRepo("public"))

scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8")

assemblyJarName in assembly := "akka-http-jsonapi-example.jar"

libraryDependencies ++= {
  val akkaVersion           = "2.4.8"
  val akkaHttpVersion       = "10.0.0"
  val scalaTestVersion      = "3.0.0"
  val logbackClassicVersion = "1.1.6"

  Seq(
    "com.typesafe.akka" %% "akka-actor" % akkaVersion,
    "com.typesafe.akka" %% "akka-stream" % akkaVersion,
    "com.typesafe.akka" %% "akka-slf4j" % akkaVersion,
    "com.typesafe.akka" %% "akka-http-core" % akkaHttpVersion,
    "com.typesafe.akka" %% "akka-http" % akkaHttpVersion,
    "com.typesafe.akka" %% "akka-http-testkit" % akkaHttpVersion,
    "com.typesafe.akka" %% "akka-http-spray-json" % akkaHttpVersion,
    "org.scalatest"     %% "scalatest" % scalaTestVersion % "test",
    "joda-time"         %  "joda-time" % "2.9.6",
    "org.joda"          %  "joda-convert" % "1.2",
    "ch.qos.logback"    %  "logback-classic" % logbackClassicVersion,
    "org.zalando"       %% "scala-jsonapi" % "0.6.1"
  )
}

fork in run := true
fork in test := true

SbtScalariform.scalariformSettings

ScalariformKeys.preferences := ScalariformKeys.preferences.value
  .setPreference(AlignSingleLineCaseStatements, true)
  .setPreference(DoubleIndentClassDeclaration, true)
  .setPreference(SpacesAroundMultiImports, false)
  .setPreference(CompactControlReadability, false)
