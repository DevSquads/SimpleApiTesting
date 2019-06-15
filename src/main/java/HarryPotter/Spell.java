package HarryPotter;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang.builder.EqualsBuilder;

public class Spell {
    @JsonProperty("_id")
    private String _id;

    @JsonProperty("spell")
    private String spell;

    @JsonProperty("type")
    private String type ;

    @JsonProperty("effect")
    private String effect ;

    public Spell(){

    }
    public Spell(String _id, String spell, String type, String effect){
        this._id = _id;
        this.spell = spell;
        this.type = type;
        this.effect = effect;
    }
    public String get_id() {
        return _id;
    }
    public void set_id(String _id) {
        this._id = _id;
    }

    public String getSpell() {
        return spell;
    }

    public void setSpell(String spell) {
        this.spell = spell;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Spell student = (Spell) o;

        return new EqualsBuilder()
                .append(_id, student._id)
                .append(spell, student.spell)
                .append(type, student.type)
                .append(effect, student.effect)
                .isEquals();
    }
}
