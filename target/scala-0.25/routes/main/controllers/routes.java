// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/lucas/Documents/HTWG/Master/MDSD/MDSD/conf/routes
// @DATE:Tue Jun 30 10:03:24 CEST 2020

package controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.ReverseAssets Assets = new controllers.ReverseAssets(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseController Controller = new controllers.ReverseController(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.javascript.ReverseAssets Assets = new controllers.javascript.ReverseAssets(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseController Controller = new controllers.javascript.ReverseController(RoutesPrefix.byNamePrefix());
  }

}
