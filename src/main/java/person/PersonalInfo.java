package person;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonalInfo {

    private String name;

    public PersonalInfo(String name){
        this.name = name;
    }


}
