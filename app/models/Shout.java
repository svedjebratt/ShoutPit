package models;

import play.data.validation.MaxSize;
import play.data.validation.Required;
import play.db.jpa.Model;

import javax.persistence.Entity;

/**
 * A shout in the pit.
 */
@Entity
public class Shout extends Model {

    @Required(message = "Give us a holler!")
    @MaxSize(value = 60, message = "Shout man, don't give us no fucking novel!")
    public String echo;

    @Override
    public String toString() {
        return echo + " [" + id + "]";
    }
}
