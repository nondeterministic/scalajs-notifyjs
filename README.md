# scalajs-notifyjs
A minimalistic Scala.js type facade for [Notify.js](https://notifyjs.com/).

## Installation
**I haven't uploaded this to any central repository yet!** So your best bet to get 
this type facade working is by checking out this repository and do the following steps:

* `cd scalajs-notifyjs/`
* `sbt publish-local`

This will normally install the type facade/library inside `$HOME/.ivy2/`.
Then, inside the project, which you want to use scalajs-notifyjs in, add the following
to your `build.sbt`:

    libraryDependencies += "org.multics.baueran" %%% "scalajs-notifyjs" % "0.1-SNAPSHOT"

You also must make sure that the project, which you want to use scalajs-notifyjs in, has
the corresponding JavaScript libraries available. To this end, you can either include
them manually in your .html files, or add the following to your `build.sbt`:

    jsDependencies += "org.webjars" % "jquery"   % "2.2.4" / "2.2.4/jquery.js"
    jsDependencies += "org.webjars" % "notifyjs" % "0.4.2" / "0.4.2/notify.js"

## Usage
Currently, there are basically three different use cases supported, all of which are demonstrated in the piece of code below.

    import org.scalajs.jquery.jQuery
    import org.multics.baueran.notifyjs._

    object TutorialApp {
      def main(args: Array[String]): Unit = {
        val myHtml = div(id:="pos-demo", p("Message!"))
        jQuery("body").append(myHtml.render)

        // Some ordinary notifications:
        // Corresponds to the following JavaScript call:
        // $.notify("Warning!", "warn");
	    Notify("Warning!", "warn")
	    Notify("Error!", "error")
        Notify("Info!", "info")
	  
        // A bit of customisation:
	    Notify("I'm a lefty!", new Options { override val globalPosition = "left" })

        // Positioning relative to an HTML-element:
        // Corresponds to the following JavaScript call:
        // $('#pos-demo').notify('Near Message!', { position:'bottom', className:'info', autoHide:false });
	    Notify(jQuery("#pos-demo"), 
	          "I'm a relativist!", 
	          new Options { override val className = "info";
	                        override val globalPosition = "bottom";
	                        override val autoHide = false})
      }
    }
