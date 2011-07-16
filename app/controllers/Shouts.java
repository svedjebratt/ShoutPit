package controllers;

import play.mvc.With;

/**
 * CRUD page for the shouts in the pit.
 */
@With(Secure.class)
public class Shouts extends CRUD {
}
