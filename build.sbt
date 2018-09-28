name := "nca_testing"

version := "0.1"

scalaVersion := "2.12.6"

libraryDependencies ++= Seq(
  "org.scalactic"  %% "scalactic"  % "3.0.5"  % "test",
  "org.scalatest"  %% "scalatest"  % "3.0.5"  % "test",
  "org.scalacheck" %% "scalacheck" % "1.14.0" % "test"
)