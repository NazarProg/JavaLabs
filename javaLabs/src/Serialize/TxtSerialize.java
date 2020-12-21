package Serialize;

import Model.*;
import com.google.gson.Gson;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;

public class TxtSerialize implements OrganisationSerialize{
    @Override
    public void serialize(Organisation organisation, String path) throws IOException {
        Gson gson = new Gson();
        FileOutputStream file = new FileOutputStream(path);
        ObjectOutputStream out = new ObjectOutputStream(file);
        out.writeObject(gson.toJson(organisation));

        out.close();
        file.close();
    }

    @Override
    public Organisation deserialize(String path) throws Exception {
        FileInputStream file = new FileInputStream(path);
        ObjectInputStream in = new ObjectInputStream(file);

        String organisation = (String)in.readObject();

        in.close();
        file.close();
        return new Gson().fromJson(organisation, Organisation.class);
    }
}