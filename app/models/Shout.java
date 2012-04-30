package models;

import controllers.CRUD;
import play.data.validation.MaxSize;
import play.data.validation.Required;
import play.db.jpa.GenericModel;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * A shout in the pit.
 */
@Entity
@Table(name = "shout")
public class Shout extends GenericModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public Long getId() {
        return id;
    }

    @Override
    public Object _key() {
        return getId();
    }

    @Required(message = "Give us a holler!")
    @MaxSize(value = 60, message = "Shout man, don't give us no fucking novel!")
    public String echo;

    @CRUD.Hidden
    public Date created;
    private static final String DATE_FORMAT = "yy-MM-dd HH:mm";

    @Override
    public String toString() {
        return echo + " [" + id + "]";
    }

    @PrePersist
    protected void postCreate() {
        created = new Date();
    }

    public String createdFormatted() {
        return new SimpleDateFormat(DATE_FORMAT).format(created);
    }
}
