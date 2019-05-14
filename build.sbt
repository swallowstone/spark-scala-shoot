name := "spark-scala-shoot"

version := "0.1"

scalaVersion := "2.11.12"

val sparkVersion = "2.2.0"

val prodLibs = Seq(
  "org.apache.spark" %% "spark-core" % sparkVersion,
  "org.apache.spark" %% "spark-sql" % sparkVersion // required for SparkSession
)

val scalaTestVersion = "3.0.5"

val testLibs = Seq(
  "org.scalatest" %% "scalatest" % scalaTestVersion % Test,
  "org.scalactic" %% "scalactic" % scalaTestVersion % Test
)

parallelExecution in Test := false

lazy val root = (project in file("."))
  .configs(IntegrationTest)
  .settings(
    Defaults.itSettings,
    libraryDependencies ++= prodLibs ++ testLibs
  )