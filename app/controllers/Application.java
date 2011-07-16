package controllers;

import models.Shout;
import play.cache.Cache;
import play.data.validation.Valid;
import play.mvc.Controller;

import java.util.List;
import java.util.Random;

public class Application extends Controller {

    public static final String NEW_SHOUT = "newShout";

    public static void index() {
        long shoutCount = Shout.count();
        if (shoutCount > 0) {
            int random = new Random().nextInt((int) shoutCount);
            List<Shout> shouts = Shout.all().from(random).fetch(1);
            if (shouts.size() > 0) {
                Shout shout = shouts.get(0);
                render(shout);
            }
        }
        create();
    }

    public static void show(long id) {
        Shout shout = Shout.<Shout>findById(id);
        if (shout != null) {
            boolean newShout = false;
            if (Cache.get(NEW_SHOUT) != null && (Boolean) Cache.get(NEW_SHOUT)) {
                newShout = true;
                Cache.delete(NEW_SHOUT);
            }
            render("/Application/index.html", shout, newShout);
        }
        index();
    }

    public static void update(long id, Shout shout) {
        Shout orgShout = Shout.<Shout>findById(id);
        if (orgShout != null && orgShout.echo == null) {
            orgShout.echo = shout.echo;
            orgShout.save();
        }
        show(id);
    }

    public static void create() {
        render();
    }

    public static void add(@Valid Shout shout) {
        if (validation.hasErrors()) {
            validation.keep();
            params.flash();
            create();
        }
        if (shout.id == null) {
            shout.save();
        }
        Cache.add(NEW_SHOUT, true);
        added(shout.id);
    }

    public static void added(long id) {
        render(id);
    }
}