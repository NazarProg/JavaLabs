package Serialize;

import Model.Organisation;

import java.io.IOException;

public interface OrganisationSerialize {
    void serialize(Organisation organisation, String path) throws IOException;

    Organisation deserialize(String path) throws Exception;
}
