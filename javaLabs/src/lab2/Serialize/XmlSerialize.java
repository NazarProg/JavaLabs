package lab2.Serialize;

import Model.Organisation;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.*;

public class XmlSerialize implements OrganisationSerialize {
    @Override
    public void serialize(Organisation organisation, String path)  throws IOException {
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.writeValue(new File("organisation.xml"), organisation);
    }

    @Override
    public Organisation deserialize(String path) throws Exception {
        File file = new File("organisation.xml");
        XmlMapper xmlMapper = new XmlMapper();
        String xml = inputStreamToString(new FileInputStream(file));
        Organisation organisation = xmlMapper.readValue(xml, Organisation.class);
        return organisation;
    }

    private String inputStreamToString(InputStream is) throws IOException {
        StringBuilder sb = new StringBuilder();
        String line;
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        br.close();
        return sb.toString();
    }
}