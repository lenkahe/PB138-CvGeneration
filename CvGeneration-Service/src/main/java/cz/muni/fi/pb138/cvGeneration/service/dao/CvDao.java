package cz.muni.fi.pb138.cvGeneration.service.dao;

import org.xmldb.api.modules.XMLResource;

import java.io.File;

/**
 * Data access object for CV.
 *
 * @author Lenka Heldova
 */
public interface CvDao {

    /**
     * Returns xml from the database.
     * @param name file name
     * @return
     */
    XMLResource getResource(String name);

    /**
     * Saves resource to the database.
     * @param name file to save
     * @return saved file
     */
    XMLResource saveResource(File name);


}
