name := "Scala Numbers DSL"

version := "0.1"

scalaVersion := "2.10.2"

net.virtualvoid.sbt.graph.Plugin.graphSettings

resolvers ++= Seq(
      "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/"
)

libraryDependencies ++= Seq(
  "org.scalaz"     %% "scalaz-core" % "7.0.0",
  "org.scalaz"     %% "scalaz-typelevel" % "7.0.0",
  "org.spire-math" %% "spire" % "0.5.0" exclude("org.scala-lang", "scala-reflect"),
  "org.scalatest"  %% "scalatest" % "2.0.M5b" % "test",
  "org.scala-lang" %  "scala-reflect" % "2.10.2",
  "org.scala-lang" %  "scala-actors" % "2.10.2" % "test"
)