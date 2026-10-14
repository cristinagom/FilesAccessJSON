package org.iesteis;

import org.iesteis.model.Response;
import tools.jackson.databind.ObjectMapper;

import java.io.File;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        ObjectMapper mapper = new ObjectMapper();
        Response r = mapper.readValue(new File("data/response.json"), Response.class);
        //Response r2 = mapper.readValue(, Response.class);
        r.getCharacters().forEach(c -> System.out.println(c.getName()));

    }
}
