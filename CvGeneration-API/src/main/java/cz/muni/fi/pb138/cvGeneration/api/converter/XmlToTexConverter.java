package cz.muni.fi.pb138.cvGeneration.api.converter;

import java.io.File;

/**
 * This class converts .xml file to .tex file.
 *
 * @author Lenka Heldova
 */
public interface XmlToTexConverter {

    /**
     * Method converts .xml file to .tex file.
     * @param xmlFile
     * @return texFile
     */
    File convertToTex(File xmlFile);
}
