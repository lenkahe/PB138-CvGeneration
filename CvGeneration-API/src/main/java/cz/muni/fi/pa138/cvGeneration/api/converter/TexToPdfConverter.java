package cz.muni.fi.pa138.cvGeneration.api.converter;

import java.io.File;

/**
 * Class used for creating PDF output from tex file by using installed pdflatex.
 * Path to latex binaries must be set through constructor.
 *
 * @author Lenka Heldova
 */
public interface TexToPdfConverter {

    /**
     * @param latexFile path to .tex file without extension .tex
     * @return absolute path to output PDF file. (Pdf file is created to the same directory as .tex file)
     */
    String createPDF(File latexFile);
}
