package com.github.nondeterministic.notifyjs

import org.scalajs.jquery._

import scala.scalajs.js
import js.annotation.JSGlobal
import js.annotation._
import js._

object LogLevel extends Enumeration {
  type LogLevel = Value
  val Warn, Error, Info = Value
}
import LogLevel._

@js.native
@JSGlobal("$.notify")
class notifyFn(elem: js.Any, data: js.Any, options: js.Any) extends js.Object

trait Options extends js.Object {
  val clickToHide: js.UndefOr[Boolean] = js.undefined
  val autoHide: js.UndefOr[Boolean] = js.undefined
  val autoHideDealy: js.UndefOr[Int] = js.undefined
  val arrowShow: js.UndefOr[Boolean] = js.undefined
  val arrowSize: js.UndefOr[Int] = js.undefined
  val breakNewLines: js.UndefOr[Boolean] = js.undefined
  val elementPosition: js.UndefOr[String] = js.undefined
  val globalPosition: js.UndefOr[String] = js.undefined
  val style: js.UndefOr[String] = js.undefined
  val className: js.UndefOr[String] = js.undefined
  val showAnimation: js.UndefOr[String] = js.undefined
  val showDuration: js.UndefOr[Int] = js.undefined
  val hideAnimation: js.UndefOr[String] = js.undefined
  val hideDuration: js.UndefOr[Int] = js.undefined
  val gap: js.UndefOr[Int] = js.undefined
}

object Notify {
  def apply(msg: String, logLevel: LogLevel) = {
    new notifyFn(msg, new Options { override val className = logLevel.toString.toLowerCase }, null)
  }

  @deprecated
  def apply(msg: String, logLevel: String) = new notifyFn(msg, new Options { override val className = logLevel }, null)

  def apply(msg: String, options: Options) = new notifyFn(msg, options, null)

  def apply(elem: JQuery, msg: String, options: Options) = new notifyFn(elem, msg, options)
}
