package controllers;

import play.mvc.With;

/**
 * CRUD page for the shouts in the pit.
 */
@With(Secure.class)
@Check("admin")
public class Shouts extends CRUD {
}
