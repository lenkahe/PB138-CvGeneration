package cz.muni.fi.pb138.cvGeneration.service.converter;

import cz.muni.fi.pa138.cvGeneration.api.converter.TexToPdfConverter;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementation for TexToPdfConverter.
 *
 * @author Lenka Heldova
 */
@Component
public class TexToPdfConverterImpl implements TexToPdfConverter{

    String pathToLatexBin = "C:\\Users\\User\\AppData\\Local\\Programs\\MiKTeX 2.9\\miktex\\bin\\x64\\";

    @Override
    public String createPDF(File latexFile) {
        String result = "";

        //set command for .tex to .dvi conversion
        List<String> dviParams = new ArrayList<>();
        dviParams.add(pathToLatexBin + "latex");
        dviParams.add(latexFile.getAbsolutePath());

        //set command for .dvi to .pdf conversion
        List<String> pdfParams = new ArrayList<>();
        pdfParams.add(pathToLatexBin + "dvipdfm");
        pdfParams.add(latexFile.getAbsolutePath());

        ProcessBuilder pb = new ProcessBuilder();
        pb.directory(latexFile.getParentFile());
        pb.redirectErrorStream(true);

        try {
            //start latex
            pb.command(dviParams);
            Process dviProcess = pb.start();
            while(dviProcess.isAlive()){
                //have to wait until process finishes
            }

            //start dvipdfm
            pb.command(pdfParams);
            Process pdfProces = pb.start();
            while(pdfProces.isAlive()){
                //have to wait until process finishes
            }

            //set path of resulting pdf
            result = latexFile.getAbsolutePath() + ".pdf";
        } catch (IOException ex) {
            System.err.println("Can not create PDF file from " + latexFile.getName() + ".tex due to error: " + ex.getMessage());

        } finally {
            //cleanup

            //delete intermediate .dvi, .aux, .log, .tex  and .out files
            File dvi = new File(latexFile.getAbsolutePath() + ".dvi");
            System.out.println(dvi.delete());
            File aux = new File(latexFile.getAbsolutePath() + ".aux");
            System.out.println(aux.delete());
            File log = new File(latexFile.getAbsolutePath() + ".log");
            log.delete();
            File out = new File(latexFile.getAbsolutePath() + ".out");
            out.delete();
            File tex = new File(latexFile.getAbsolutePath() + ".tex");
            tex.delete();
        }

        return result;
    }
}

