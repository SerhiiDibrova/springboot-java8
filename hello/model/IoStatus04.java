package hello.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class IoStatus04 {
    @JsonProperty("firstCharacter")
    @NotNull
    @Size(min = 1, max = 1)
    private String firstCharacter;

    @JsonProperty("lastTwoCharacters")
    @NotNull
    @Size(min = 2, max = 2)
    private String lastTwoCharacters;

    @JsonProperty("formattedStatus")
    @NotNull
    private String formattedStatus;

    public IoStatus04() {}

    public IoStatus04(String firstCharacter, String lastTwoCharacters, String formattedStatus) {
        this.firstCharacter = firstCharacter;
        this.lastTwoCharacters = lastTwoCharacters;
        this.formattedStatus = formattedStatus;
    }

    public String getFirstCharacter() {
        return firstCharacter;
    }

    public void setFirstCharacter(String firstCharacter) {
        this.firstCharacter = firstCharacter;
    }

    public String getLastTwoCharacters() {
        return lastTwoCharacters;
    }

    public void setLastTwoCharacters(String lastTwoCharacters) {
        this.lastTwoCharacters = lastTwoCharacters;
    }

    public String getFormattedStatus() {
        return formattedStatus;
    }

    public void setFormattedStatus(String formattedStatus) {
        this.formattedStatus = formattedStatus;
    }

    public String formatIoStatus() {
        if (firstCharacter != null && lastTwoCharacters != null && formattedStatus != null) {
            return firstCharacter + " - " + lastTwoCharacters + ": " + formattedStatus;
        } else {
            return null;
        }
    }
}