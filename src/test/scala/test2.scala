package com.github.nondeterministic.TutorialApp

import org.scalajs.jquery.jQuery
import jQuery._
import org.scalajs.jquery._
import com.github.nondeterministic.notifyjs._
import scala.scalajs.js
import org.scalajs.jquery.JQueryStatic
import scala.scalajs.js.annotation.JSImport
import js.annotation.JSGlobal
import js.annotation._
import js._
import utest._
import org.scalajs.jquery.jQuery

object TutorialApp extends TestSuite {

  val tests = Tests{
    test("Old API"){
      val a = Notify("Warning!", "warn")
//      Notify("Error!", "error")
//      Notify("Info!", "info")
    }
    test("New API"){
val a=      Notify("Warning!", LogLevel.Warn)
//      Notify("Error!", LogLevel.Error)
//      Notify("Info!", LogLevel.Info)
    }
  }

}
