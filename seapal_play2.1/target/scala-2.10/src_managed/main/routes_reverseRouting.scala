// @SOURCE:/home/stefano/Dokumente/Programming/Web/Seapal2/seapal_play2.1/conf/routes
// @HASH:2d0429b43a11661642778876c4e8d2ae1bd5c3cb
// @DATE:Sun Jun 16 22:37:04 CEST 2013

import Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.j._
import java.net.URLEncoder

import play.api.mvc._


import Router.queryString


// @LINE:31
// @LINE:28
// @LINE:27
// @LINE:26
// @LINE:25
// @LINE:24
// @LINE:23
// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
package controllers {

// @LINE:12
class ReverseLegal {
    

// @LINE:12
def index(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "legal.html")
}
                                                
    
}
                          

// @LINE:31
class ReverseAssets {
    

// @LINE:31
def at(file:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[PathBindable[String]].unbind("file", file))
}
                                                
    
}
                          

// @LINE:13
class ReverseImpressum {
    

// @LINE:13
def index(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "impressum.html")
}
                                                
    
}
                          

// @LINE:9
class ReverseAbout {
    

// @LINE:9
def index(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "about.html")
}
                                                
    
}
                          

// @LINE:8
class ReverseContact {
    

// @LINE:8
def index(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "contact.html")
}
                                                
    
}
                          

// @LINE:27
class ReverseWaypoint {
    

// @LINE:27
def index(wnr:Int): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "app_waypoint.html" + queryString(List(Some(implicitly[QueryStringBindable[Int]].unbind("wnr", wnr)))))
}
                                                
    
}
                          

// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:19
class ReverseTrip {
    

// @LINE:19
def index(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "app_trip.html")
}
                                                

// @LINE:20
def load(tnr:Int): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "app_trip_load.html" + queryString(List(Some(implicitly[QueryStringBindable[Int]].unbind("tnr", tnr)))))
}
                                                

// @LINE:22
def delete(tnr:Int): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "app_trip_delete.html" + queryString(List(Some(implicitly[QueryStringBindable[Int]].unbind("tnr", tnr)))))
}
                                                

// @LINE:21
def insert(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "app_trip_insert.html")
}
                                                
    
}
                          

// @LINE:11
class ReverseScreenshots {
    

// @LINE:11
def index(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "screenshots.html")
}
                                                
    
}
                          

// @LINE:14
class ReverseMap {
    

// @LINE:14
def index(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "app_map.html")
}
                                                
    
}
                          

// @LINE:26
// @LINE:25
// @LINE:24
// @LINE:23
class ReverseTripinfo {
    

// @LINE:24
def load(wnr:Int): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "app_tripinfo_load.html" + queryString(List(Some(implicitly[QueryStringBindable[Int]].unbind("wnr", wnr)))))
}
                                                

// @LINE:26
def delete(wnr:Int): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "app_tripinfo_delete.html" + queryString(List(Some(implicitly[QueryStringBindable[Int]].unbind("wnr", wnr)))))
}
                                                

// @LINE:23
def index(tnr:Int): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "app_tripinfo.html" + queryString(List(Some(implicitly[QueryStringBindable[Int]].unbind("tnr", tnr)))))
}
                                                

// @LINE:25
def insert(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "app_tripinfo_insert.html")
}
                                                
    
}
                          

// @LINE:18
// @LINE:17
// @LINE:16
// @LINE:15
class ReverseBoatinfo {
    

// @LINE:15
def index(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "app_boatinfo.html")
}
                                                

// @LINE:16
def load(bnr:Int): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "app_boatinfo_load.html" + queryString(List(Some(implicitly[QueryStringBindable[Int]].unbind("bnr", bnr)))))
}
                                                

// @LINE:18
def delete(bnr:Int): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "app_boatinfo_delete.html" + queryString(List(Some(implicitly[QueryStringBindable[Int]].unbind("bnr", bnr)))))
}
                                                

// @LINE:17
def insert(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "app_boatinfo_insert.html")
}
                                                
    
}
                          

// @LINE:10
class ReverseUserguide {
    

// @LINE:10
def index(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "userguide.html")
}
                                                
    
}
                          

// @LINE:28
class ReverseShipSimulator {
    

// @LINE:28
def websocket(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "websocket")
}
                                                
    
}
                          

// @LINE:7
// @LINE:6
class ReverseIndex {
    

// @LINE:7
// @LINE:6
def index(): Call = {
   () match {
// @LINE:6
case () if true => Call("GET", _prefix)
                                                        
// @LINE:7
case () if true => Call("GET", _prefix + { _defaultPrefix } + "index.html")
                                                        
   }
}
                                                
    
}
                          
}
                  


// @LINE:31
// @LINE:28
// @LINE:27
// @LINE:26
// @LINE:25
// @LINE:24
// @LINE:23
// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
package controllers.javascript {

// @LINE:12
class ReverseLegal {
    

// @LINE:12
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Legal.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "legal.html"})
      }
   """
)
                        
    
}
              

// @LINE:31
class ReverseAssets {
    

// @LINE:31
def at : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Assets.at",
   """
      function(file) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
   """
)
                        
    
}
              

// @LINE:13
class ReverseImpressum {
    

// @LINE:13
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Impressum.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "impressum.html"})
      }
   """
)
                        
    
}
              

// @LINE:9
class ReverseAbout {
    

// @LINE:9
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.About.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "about.html"})
      }
   """
)
                        
    
}
              

// @LINE:8
class ReverseContact {
    

// @LINE:8
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Contact.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "contact.html"})
      }
   """
)
                        
    
}
              

// @LINE:27
class ReverseWaypoint {
    

// @LINE:27
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Waypoint.index",
   """
      function(wnr) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "app_waypoint.html" + _qS([(""" + implicitly[QueryStringBindable[Int]].javascriptUnbind + """)("wnr", wnr)])})
      }
   """
)
                        
    
}
              

// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:19
class ReverseTrip {
    

// @LINE:19
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Trip.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "app_trip.html"})
      }
   """
)
                        

// @LINE:20
def load : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Trip.load",
   """
      function(tnr) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "app_trip_load.html" + _qS([(""" + implicitly[QueryStringBindable[Int]].javascriptUnbind + """)("tnr", tnr)])})
      }
   """
)
                        

// @LINE:22
def delete : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Trip.delete",
   """
      function(tnr) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "app_trip_delete.html" + _qS([(""" + implicitly[QueryStringBindable[Int]].javascriptUnbind + """)("tnr", tnr)])})
      }
   """
)
                        

// @LINE:21
def insert : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Trip.insert",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "app_trip_insert.html"})
      }
   """
)
                        
    
}
              

// @LINE:11
class ReverseScreenshots {
    

// @LINE:11
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Screenshots.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "screenshots.html"})
      }
   """
)
                        
    
}
              

// @LINE:14
class ReverseMap {
    

// @LINE:14
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Map.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "app_map.html"})
      }
   """
)
                        
    
}
              

// @LINE:26
// @LINE:25
// @LINE:24
// @LINE:23
class ReverseTripinfo {
    

// @LINE:24
def load : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Tripinfo.load",
   """
      function(wnr) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "app_tripinfo_load.html" + _qS([(""" + implicitly[QueryStringBindable[Int]].javascriptUnbind + """)("wnr", wnr)])})
      }
   """
)
                        

// @LINE:26
def delete : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Tripinfo.delete",
   """
      function(wnr) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "app_tripinfo_delete.html" + _qS([(""" + implicitly[QueryStringBindable[Int]].javascriptUnbind + """)("wnr", wnr)])})
      }
   """
)
                        

// @LINE:23
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Tripinfo.index",
   """
      function(tnr) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "app_tripinfo.html" + _qS([(""" + implicitly[QueryStringBindable[Int]].javascriptUnbind + """)("tnr", tnr)])})
      }
   """
)
                        

// @LINE:25
def insert : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Tripinfo.insert",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "app_tripinfo_insert.html"})
      }
   """
)
                        
    
}
              

// @LINE:18
// @LINE:17
// @LINE:16
// @LINE:15
class ReverseBoatinfo {
    

// @LINE:15
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Boatinfo.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "app_boatinfo.html"})
      }
   """
)
                        

// @LINE:16
def load : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Boatinfo.load",
   """
      function(bnr) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "app_boatinfo_load.html" + _qS([(""" + implicitly[QueryStringBindable[Int]].javascriptUnbind + """)("bnr", bnr)])})
      }
   """
)
                        

// @LINE:18
def delete : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Boatinfo.delete",
   """
      function(bnr) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "app_boatinfo_delete.html" + _qS([(""" + implicitly[QueryStringBindable[Int]].javascriptUnbind + """)("bnr", bnr)])})
      }
   """
)
                        

// @LINE:17
def insert : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Boatinfo.insert",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "app_boatinfo_insert.html"})
      }
   """
)
                        
    
}
              

// @LINE:10
class ReverseUserguide {
    

// @LINE:10
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Userguide.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "userguide.html"})
      }
   """
)
                        
    
}
              

// @LINE:28
class ReverseShipSimulator {
    

// @LINE:28
def websocket : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ShipSimulator.websocket",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "websocket"})
      }
   """
)
                        
    
}
              

// @LINE:7
// @LINE:6
class ReverseIndex {
    

// @LINE:7
// @LINE:6
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Index.index",
   """
      function() {
      if (true) {
      return _wA({method:"GET", url:"""" + _prefix + """"})
      }
      if (true) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "index.html"})
      }
      }
   """
)
                        
    
}
              
}
        


// @LINE:31
// @LINE:28
// @LINE:27
// @LINE:26
// @LINE:25
// @LINE:24
// @LINE:23
// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
package controllers.ref {

// @LINE:12
class ReverseLegal {
    

// @LINE:12
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Legal.index(), HandlerDef(this, "controllers.Legal", "index", Seq(), "GET", """""", _prefix + """legal.html""")
)
                      
    
}
                          

// @LINE:31
class ReverseAssets {
    

// @LINE:31
def at(path:String, file:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]), "GET", """ Map static resources from the /public folder to the /assets URL path""", _prefix + """assets/$file<.+>""")
)
                      
    
}
                          

// @LINE:13
class ReverseImpressum {
    

// @LINE:13
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Impressum.index(), HandlerDef(this, "controllers.Impressum", "index", Seq(), "GET", """""", _prefix + """impressum.html""")
)
                      
    
}
                          

// @LINE:9
class ReverseAbout {
    

// @LINE:9
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.About.index(), HandlerDef(this, "controllers.About", "index", Seq(), "GET", """""", _prefix + """about.html""")
)
                      
    
}
                          

// @LINE:8
class ReverseContact {
    

// @LINE:8
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Contact.index(), HandlerDef(this, "controllers.Contact", "index", Seq(), "GET", """""", _prefix + """contact.html""")
)
                      
    
}
                          

// @LINE:27
class ReverseWaypoint {
    

// @LINE:27
def index(wnr:Int): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Waypoint.index(wnr), HandlerDef(this, "controllers.Waypoint", "index", Seq(classOf[Int]), "GET", """""", _prefix + """app_waypoint.html""")
)
                      
    
}
                          

// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:19
class ReverseTrip {
    

// @LINE:19
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Trip.index(), HandlerDef(this, "controllers.Trip", "index", Seq(), "GET", """""", _prefix + """app_trip.html""")
)
                      

// @LINE:20
def load(tnr:Int): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Trip.load(tnr), HandlerDef(this, "controllers.Trip", "load", Seq(classOf[Int]), "GET", """""", _prefix + """app_trip_load.html""")
)
                      

// @LINE:22
def delete(tnr:Int): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Trip.delete(tnr), HandlerDef(this, "controllers.Trip", "delete", Seq(classOf[Int]), "GET", """""", _prefix + """app_trip_delete.html""")
)
                      

// @LINE:21
def insert(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Trip.insert(), HandlerDef(this, "controllers.Trip", "insert", Seq(), "POST", """""", _prefix + """app_trip_insert.html""")
)
                      
    
}
                          

// @LINE:11
class ReverseScreenshots {
    

// @LINE:11
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Screenshots.index(), HandlerDef(this, "controllers.Screenshots", "index", Seq(), "GET", """""", _prefix + """screenshots.html""")
)
                      
    
}
                          

// @LINE:14
class ReverseMap {
    

// @LINE:14
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Map.index(), HandlerDef(this, "controllers.Map", "index", Seq(), "GET", """""", _prefix + """app_map.html""")
)
                      
    
}
                          

// @LINE:26
// @LINE:25
// @LINE:24
// @LINE:23
class ReverseTripinfo {
    

// @LINE:24
def load(wnr:Int): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Tripinfo.load(wnr), HandlerDef(this, "controllers.Tripinfo", "load", Seq(classOf[Int]), "GET", """""", _prefix + """app_tripinfo_load.html""")
)
                      

// @LINE:26
def delete(wnr:Int): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Tripinfo.delete(wnr), HandlerDef(this, "controllers.Tripinfo", "delete", Seq(classOf[Int]), "GET", """""", _prefix + """app_tripinfo_delete.html""")
)
                      

// @LINE:23
def index(tnr:Int): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Tripinfo.index(tnr), HandlerDef(this, "controllers.Tripinfo", "index", Seq(classOf[Int]), "GET", """""", _prefix + """app_tripinfo.html""")
)
                      

// @LINE:25
def insert(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Tripinfo.insert(), HandlerDef(this, "controllers.Tripinfo", "insert", Seq(), "POST", """""", _prefix + """app_tripinfo_insert.html""")
)
                      
    
}
                          

// @LINE:18
// @LINE:17
// @LINE:16
// @LINE:15
class ReverseBoatinfo {
    

// @LINE:15
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Boatinfo.index(), HandlerDef(this, "controllers.Boatinfo", "index", Seq(), "GET", """""", _prefix + """app_boatinfo.html""")
)
                      

// @LINE:16
def load(bnr:Int): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Boatinfo.load(bnr), HandlerDef(this, "controllers.Boatinfo", "load", Seq(classOf[Int]), "GET", """""", _prefix + """app_boatinfo_load.html""")
)
                      

// @LINE:18
def delete(bnr:Int): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Boatinfo.delete(bnr), HandlerDef(this, "controllers.Boatinfo", "delete", Seq(classOf[Int]), "GET", """""", _prefix + """app_boatinfo_delete.html""")
)
                      

// @LINE:17
def insert(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Boatinfo.insert(), HandlerDef(this, "controllers.Boatinfo", "insert", Seq(), "POST", """""", _prefix + """app_boatinfo_insert.html""")
)
                      
    
}
                          

// @LINE:10
class ReverseUserguide {
    

// @LINE:10
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Userguide.index(), HandlerDef(this, "controllers.Userguide", "index", Seq(), "GET", """""", _prefix + """userguide.html""")
)
                      
    
}
                          

// @LINE:28
class ReverseShipSimulator {
    

// @LINE:28
def websocket(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.ShipSimulator.websocket(), HandlerDef(this, "controllers.ShipSimulator", "websocket", Seq(), "GET", """""", _prefix + """websocket""")
)
                      
    
}
                          

// @LINE:7
// @LINE:6
class ReverseIndex {
    

// @LINE:6
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Index.index(), HandlerDef(this, "controllers.Index", "index", Seq(), "GET", """ Home page""", _prefix + """""")
)
                      
    
}
                          
}
                  
      