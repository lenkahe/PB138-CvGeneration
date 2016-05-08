package cz.muni.fi.pb138.cvGeneration.service.dao;

import cz.muni.fi.pb138.cvGeneration.service.exception.DataAccessCvException;
import org.exist.xmldb.EXistResource;
import org.springframework.stereotype.Component;
import org.xmldb.api.DatabaseManager;
import org.xmldb.api.base.*;
import org.xmldb.api.modules.XMLResource;

import javax.xml.transform.OutputKeys;
import java.io.File;

/**
 * Data access object for CV.
 *
 * @author Lenka Heldova
 */
@Component
public class CvDaoImpl implements CvDao {

    private static String URI = "xmldb:exist://localhost:8080/exist/xmlrpc/db/cv";
    final String driver = "org.exist.xmldb.DatabaseImpl";

    @Override
    public XMLResource getResource(String name) {
        Collection collection = null;
        XMLResource resource = null;

        initDatabase();
        try {
            // get the collection
            collection = DatabaseManager.getCollection(URI);
            collection.setProperty(OutputKeys.INDENT, "no");
            resource = (XMLResource) collection.getResource(name);

            return resource;

        } catch (XMLDBException e) {
           throw new DataAccessCvException("Exception was thrown while getting resource", e);
        } finally {
            cleanUp(resource, collection);
        }
    }

    @Override
    public XMLResource saveResource(File file) {
        initDatabase();
        Collection collection = null;
        XMLResource resource = null;
        try {
            collection = DatabaseManager.getCollection(URI);

            // create new XMLResource; an id will be assigned to the new resource
            resource = (XMLResource)collection.createResource(null, "XMLResource");

            resource.setContent(file);
            collection.storeResource(resource);
            return resource;
        } catch (XMLDBException e) {
            throw new DataAccessCvException("Exception was thrown while getting resource", e);
        } finally {
           cleanUp(resource, collection);
        }
    }



    private void initDatabase() {
        try {
            // initialize database driver
            Class cl = Class.forName(driver);
            Database database = (Database) cl.newInstance();
            database.setProperty("create-database", "true");
            DatabaseManager.registerDatabase(database);
        } catch (IllegalAccessException | InstantiationException | XMLDBException | ClassNotFoundException e) {
            throw new DataAccessCvException("Exception was thrown while database initialization.", e);
        }
    }

    private void cleanUp(Resource resource, Collection collection){
        if (resource != null) {
            try {
                ((EXistResource) resource).freeResources();
            } catch (XMLDBException xe) {
                throw new DataAccessCvException("Cannot clean up resource!", xe);
            }
        }

        if (collection != null) {
            try {
                collection.close();
            } catch (XMLDBException xe) {
                throw new DataAccessCvException("Cannot clean up collection!", xe);
            }
        }
    }
}


