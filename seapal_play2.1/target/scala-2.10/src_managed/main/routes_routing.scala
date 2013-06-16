// @SOURCE:/home/stefano/Dokumente/Programming/Web/Seapal2/seapal_play2.1/conf/routes
// @HASH:2d0429b43a11661642778876c4e8d2ae1bd5c3cb
// @DATE:Sun Jun 16 22:37:04 CEST 2013


import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._


import Router.queryString

object Routes extends Router.Routes {

private var _prefix = "/"

def setPrefix(prefix: String) {
  _prefix = prefix  
  List[(String,Routes)]().foreach {
    case (p, router) => router.setPrefix(prefix + (if(prefix.endsWith("/")) "" else "/") + p)
  }
}

def prefix = _prefix

lazy val defaultPrefix = { if(Routes.prefix.endsWith("/")) "" else "/" } 


// @LINE:6
private[this] lazy val controllers_Index_index0 = Route("GET", PathPattern(List(StaticPart(Routes.prefix))))
        

// @LINE:7
private[this] lazy val controllers_Index_index1 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("index.html"))))
        

// @LINE:8
private[this] lazy val controllers_Contact_index2 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("contact.html"))))
        

// @LINE:9
private[this] lazy val controllers_About_index3 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("about.html"))))
        

// @LINE:10
private[this] lazy val controllers_Userguide_index4 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("userguide.html"))))
        

// @LINE:11
private[this] lazy val controllers_Screenshots_index5 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("screenshots.html"))))
        

// @LINE:12
private[this] lazy val controllers_Legal_index6 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("legal.html"))))
        

// @LINE:13
private[this] lazy val controllers_Impressum_index7 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("impressum.html"))))
        

// @LINE:14
private[this] lazy val controllers_Map_index8 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("app_map.html"))))
        

// @LINE:15
private[this] lazy val controllers_Boatinfo_index9 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("app_boatinfo.html"))))
        

// @LINE:16
private[this] lazy val controllers_Boatinfo_load10 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("app_boatinfo_load.html"))))
        

// @LINE:17
private[this] lazy val controllers_Boatinfo_insert11 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("app_boatinfo_insert.html"))))
        

// @LINE:18
private[this] lazy val controllers_Boatinfo_delete12 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("app_boatinfo_delete.html"))))
        

// @LINE:19
private[this] lazy val controllers_Trip_index13 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("app_trip.html"))))
        

// @LINE:20
private[this] lazy val controllers_Trip_load14 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("app_trip_load.html"))))
        

// @LINE:21
private[this] lazy val controllers_Trip_insert15 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("app_trip_insert.html"))))
        

// @LINE:22
private[this] lazy val controllers_Trip_delete16 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("app_trip_delete.html"))))
        

// @LINE:23
private[this] lazy val controllers_Tripinfo_index17 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("app_tripinfo.html"))))
        

// @LINE:24
private[this] lazy val controllers_Tripinfo_load18 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("app_tripinfo_load.html"))))
        

// @LINE:25
private[this] lazy val controllers_Tripinfo_insert19 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("app_tripinfo_insert.html"))))
        

// @LINE:26
private[this] lazy val controllers_Tripinfo_delete20 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("app_tripinfo_delete.html"))))
        

// @LINE:27
private[this] lazy val controllers_Waypoint_index21 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("app_waypoint.html"))))
        

// @LINE:28
private[this] lazy val controllers_ShipSimulator_websocket22 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("websocket"))))
        

// @LINE:31
private[this] lazy val controllers_Assets_at23 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("assets/"),DynamicPart("file", """.+""",false))))
        
def documentation = List(("""GET""", prefix,"""controllers.Index.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """index.html""","""controllers.Index.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """contact.html""","""controllers.Contact.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """about.html""","""controllers.About.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """userguide.html""","""controllers.Userguide.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """screenshots.html""","""controllers.Screenshots.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """legal.html""","""controllers.Legal.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """impressum.html""","""controllers.Impressum.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """app_map.html""","""controllers.Map.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """app_boatinfo.html""","""controllers.Boatinfo.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """app_boatinfo_load.html""","""controllers.Boatinfo.load(bnr:Int)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """app_boatinfo_insert.html""","""controllers.Boatinfo.insert()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """app_boatinfo_delete.html""","""controllers.Boatinfo.delete(bnr:Int)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """app_trip.html""","""controllers.Trip.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """app_trip_load.html""","""controllers.Trip.load(tnr:Int)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """app_trip_insert.html""","""controllers.Trip.insert()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """app_trip_delete.html""","""controllers.Trip.delete(tnr:Int)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """app_tripinfo.html""","""controllers.Tripinfo.index(tnr:Int)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """app_tripinfo_load.html""","""controllers.Tripinfo.load(wnr:Int)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """app_tripinfo_insert.html""","""controllers.Tripinfo.insert()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """app_tripinfo_delete.html""","""controllers.Tripinfo.delete(wnr:Int)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """app_waypoint.html""","""controllers.Waypoint.index(wnr:Int)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """websocket""","""controllers.ShipSimulator.websocket"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
  case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
  case l => s ++ l.asInstanceOf[List[(String,String,String)]] 
}}
       
    
def routes:PartialFunction[RequestHeader,Handler] = {        

// @LINE:6
case controllers_Index_index0(params) => {
   call { 
        invokeHandler(controllers.Index.index(), HandlerDef(this, "controllers.Index", "index", Nil,"GET", """ Home page""", Routes.prefix + """"""))
   }
}
        

// @LINE:7
case controllers_Index_index1(params) => {
   call { 
        invokeHandler(controllers.Index.index(), HandlerDef(this, "controllers.Index", "index", Nil,"GET", """""", Routes.prefix + """index.html"""))
   }
}
        

// @LINE:8
case controllers_Contact_index2(params) => {
   call { 
        invokeHandler(controllers.Contact.index(), HandlerDef(this, "controllers.Contact", "index", Nil,"GET", """""", Routes.prefix + """contact.html"""))
   }
}
        

// @LINE:9
case controllers_About_index3(params) => {
   call { 
        invokeHandler(controllers.About.index(), HandlerDef(this, "controllers.About", "index", Nil,"GET", """""", Routes.prefix + """about.html"""))
   }
}
        

// @LINE:10
case controllers_Userguide_index4(params) => {
   call { 
        invokeHandler(controllers.Userguide.index(), HandlerDef(this, "controllers.Userguide", "index", Nil,"GET", """""", Routes.prefix + """userguide.html"""))
   }
}
        

// @LINE:11
case controllers_Screenshots_index5(params) => {
   call { 
        invokeHandler(controllers.Screenshots.index(), HandlerDef(this, "controllers.Screenshots", "index", Nil,"GET", """""", Routes.prefix + """screenshots.html"""))
   }
}
        

// @LINE:12
case controllers_Legal_index6(params) => {
   call { 
        invokeHandler(controllers.Legal.index(), HandlerDef(this, "controllers.Legal", "index", Nil,"GET", """""", Routes.prefix + """legal.html"""))
   }
}
        

// @LINE:13
case controllers_Impressum_index7(params) => {
   call { 
        invokeHandler(controllers.Impressum.index(), HandlerDef(this, "controllers.Impressum", "index", Nil,"GET", """""", Routes.prefix + """impressum.html"""))
   }
}
        

// @LINE:14
case controllers_Map_index8(params) => {
   call { 
        invokeHandler(controllers.Map.index(), HandlerDef(this, "controllers.Map", "index", Nil,"GET", """""", Routes.prefix + """app_map.html"""))
   }
}
        

// @LINE:15
case controllers_Boatinfo_index9(params) => {
   call { 
        invokeHandler(controllers.Boatinfo.index(), HandlerDef(this, "controllers.Boatinfo", "index", Nil,"GET", """""", Routes.prefix + """app_boatinfo.html"""))
   }
}
        

// @LINE:16
case controllers_Boatinfo_load10(params) => {
   call(params.fromQuery[Int]("bnr", None)) { (bnr) =>
        invokeHandler(controllers.Boatinfo.load(bnr), HandlerDef(this, "controllers.Boatinfo", "load", Seq(classOf[Int]),"GET", """""", Routes.prefix + """app_boatinfo_load.html"""))
   }
}
        

// @LINE:17
case controllers_Boatinfo_insert11(params) => {
   call { 
        invokeHandler(controllers.Boatinfo.insert(), HandlerDef(this, "controllers.Boatinfo", "insert", Nil,"POST", """""", Routes.prefix + """app_boatinfo_insert.html"""))
   }
}
        

// @LINE:18
case controllers_Boatinfo_delete12(params) => {
   call(params.fromQuery[Int]("bnr", None)) { (bnr) =>
        invokeHandler(controllers.Boatinfo.delete(bnr), HandlerDef(this, "controllers.Boatinfo", "delete", Seq(classOf[Int]),"GET", """""", Routes.prefix + """app_boatinfo_delete.html"""))
   }
}
        

// @LINE:19
case controllers_Trip_index13(params) => {
   call { 
        invokeHandler(controllers.Trip.index(), HandlerDef(this, "controllers.Trip", "index", Nil,"GET", """""", Routes.prefix + """app_trip.html"""))
   }
}
        

// @LINE:20
case controllers_Trip_load14(params) => {
   call(params.fromQuery[Int]("tnr", None)) { (tnr) =>
        invokeHandler(controllers.Trip.load(tnr), HandlerDef(this, "controllers.Trip", "load", Seq(classOf[Int]),"GET", """""", Routes.prefix + """app_trip_load.html"""))
   }
}
        

// @LINE:21
case controllers_Trip_insert15(params) => {
   call { 
        invokeHandler(controllers.Trip.insert(), HandlerDef(this, "controllers.Trip", "insert", Nil,"POST", """""", Routes.prefix + """app_trip_insert.html"""))
   }
}
        

// @LINE:22
case controllers_Trip_delete16(params) => {
   call(params.fromQuery[Int]("tnr", None)) { (tnr) =>
        invokeHandler(controllers.Trip.delete(tnr), HandlerDef(this, "controllers.Trip", "delete", Seq(classOf[Int]),"GET", """""", Routes.prefix + """app_trip_delete.html"""))
   }
}
        

// @LINE:23
case controllers_Tripinfo_index17(params) => {
   call(params.fromQuery[Int]("tnr", None)) { (tnr) =>
        invokeHandler(controllers.Tripinfo.index(tnr), HandlerDef(this, "controllers.Tripinfo", "index", Seq(classOf[Int]),"GET", """""", Routes.prefix + """app_tripinfo.html"""))
   }
}
        

// @LINE:24
case controllers_Tripinfo_load18(params) => {
   call(params.fromQuery[Int]("wnr", None)) { (wnr) =>
        invokeHandler(controllers.Tripinfo.load(wnr), HandlerDef(this, "controllers.Tripinfo", "load", Seq(classOf[Int]),"GET", """""", Routes.prefix + """app_tripinfo_load.html"""))
   }
}
        

// @LINE:25
case controllers_Tripinfo_insert19(params) => {
   call { 
        invokeHandler(controllers.Tripinfo.insert(), HandlerDef(this, "controllers.Tripinfo", "insert", Nil,"POST", """""", Routes.prefix + """app_tripinfo_insert.html"""))
   }
}
        

// @LINE:26
case controllers_Tripinfo_delete20(params) => {
   call(params.fromQuery[Int]("wnr", None)) { (wnr) =>
        invokeHandler(controllers.Tripinfo.delete(wnr), HandlerDef(this, "controllers.Tripinfo", "delete", Seq(classOf[Int]),"GET", """""", Routes.prefix + """app_tripinfo_delete.html"""))
   }
}
        

// @LINE:27
case controllers_Waypoint_index21(params) => {
   call(params.fromQuery[Int]("wnr", None)) { (wnr) =>
        invokeHandler(controllers.Waypoint.index(wnr), HandlerDef(this, "controllers.Waypoint", "index", Seq(classOf[Int]),"GET", """""", Routes.prefix + """app_waypoint.html"""))
   }
}
        

// @LINE:28
case controllers_ShipSimulator_websocket22(params) => {
   call { 
        invokeHandler(controllers.ShipSimulator.websocket, HandlerDef(this, "controllers.ShipSimulator", "websocket", Nil,"GET", """""", Routes.prefix + """websocket"""))
   }
}
        

// @LINE:31
case controllers_Assets_at23(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        invokeHandler(controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]),"GET", """ Map static resources from the /public folder to the /assets URL path""", Routes.prefix + """assets/$file<.+>"""))
   }
}
        
}
    
}
        