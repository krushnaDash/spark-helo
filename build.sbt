
ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.12.12"

lazy val root = (project in file("."))
  .settings(
    name := "spark-hello"
  )

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-sql" % "2.4.0" ,
  "org.apache.spark" %% "spark-core" % "2.4.0" ,
   "org.apache.spark" % "spark-streaming_2.12" % "3.3.2"
)