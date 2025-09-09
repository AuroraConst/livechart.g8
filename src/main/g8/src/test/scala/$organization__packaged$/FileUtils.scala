package $organization$

import scala.scalajs.js
import scala.scalajs.js.annotation.*
import scala.util.Try

import scala.scalajs.js.Dynamic.global



@js.native
@JSImport("process", JSImport.Namespace)
private object Process extends js.Object {
  def cwd(): String = js.native
}


/**
  * FileReader object to read files from the file system and creates a string dsl for platorm independent paths
  */

object FileUtils:
  def platform =  if (!js.isUndefined(global.process)) {
      global.process.platform.asInstanceOf[String]
    } else {
      "unknown"
    }
  val separator = platform match {
    case "win32" => "\\"
    case _ => "/"
  }

  extension (spath:String)
    def /(path: String): String = spath + separator + path



  def cwd = Process.cwd()
  def testResourcePath = cwd / "src" / "test" / "resources"
  def testAuroraFiles = testResourcePath / "aurora" //aurora files will be placed here for testing
  def testIssueFiles = testResourcePath / "aurora" / "issues"
  def testClinicalsFiles = testResourcePath / "aurora" / "clinicals"
  def testOrdersFiles = testResourcePath / "aurora" / "orders"
  def testHelloFile = testResourcePath / "hello.txt"
  def testQUFiles = testResourcePath / "aurora" / "qu"
  
end FileUtils