package Serialize;

import Model.Organisation;
import com.google.gson.Gson;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class JsonSerialize  implements OrganisationSerialize{
    @Override
    public void serialize(Organisation organisation, String path) throws IOException {
        Gson gson = new Gson();
        File file = new File(path);
        FileWriter fl = new FileWriter(file);
        fl.write(gson.toJson(organisation));
        fl.close();
    }

    @Override
    public Organisation deserialize(String path) throws Exception {
        return new Gson().fromJson(new FileReader(path), Organisation.class);
    }
}