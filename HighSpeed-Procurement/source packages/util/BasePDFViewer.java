package util;

import org.jpedal.PdfDecoder;
import org.jpedal.examples.viewer.commands.OpenFile;
import org.jpedal.exception.PdfException;
import org.jpedal.objects.PdfPageData;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import org.jpedal.*;

/**
 * <h2><b>BaseViewer</b></h2>
 * <br>
 * <p>If you are compiling, you will need to download all the examples source files from :
 * <a href="http://www.idrsolutions.com/how-to-view-pdf-files-in-java/">How to View PDF File in Java.</a></p>
 * <br>
 * <p><b>Run directly from jar with java -cp jpedal.jar org/jpedal/examples/baseviewer/BaseViewer</b></p>
 * <br>
 * <p>There are plenty of tutorials on how to configure the Viewer on our website <a href="http://www.idrsolutions.com/java-pdf-library-support/">Support Section.</a></p>
 * <br>
 * <p><a href="http://www.idrsolutions.com/java-pdf-library-support/http://www.idrsolutions.com/java-pdf-library-support/">For more help and tutorials, visit our websites Support Section.</a></p>
 */
public class BasePDFViewer {

    /**
     * Enum to control how we fit the content to the page.
     * <p>
     * AUTO will automatically fit the content to the stage depending on its orientation
     * WIDTH will fit the content to the stage width depending on its orientation
     * HEIGHT will fit the content to the stage height depending on its orientation
     */
    public enum FitToPage {
        AUTO, WIDTH, HEIGHT
    }

    private final JFrame mainFrame = new JFrame("Base Viewer - " + PdfDecoder.version);

    private JScrollPane scrollPdf = new JScrollPane();

    private final JPanel insets = new JPanel();

    final PdfDecoder pdf = new PdfDecoder();
    private int currentPage = 1;
    private float scale = 1.0f;

    private final float[] scalings = {0.01f, 0.1f, 0.25f, 0.5f, 0.75f, 1.0f, 1.25f, 1.5f, 2.0f, 4.0f, 7.5f, 10.0f};

    private static final int insetV = 25;

    private static final int insetH = 25;
    private String filename;
    private int currentScaling;

    private final JPanel top = new JPanel();

    private final JToolBar toolBar = new JToolBar("Tool Bar");
    private final JButton open = new JButton("Open");
    private final JButton back = new JButton("Back");
    private final JButton forward = new JButton("Forward");
    private final JButton zoomIn = new JButton("Zoom in");
    private final JButton zoomOut = new JButton("Zoom out");
    private final JButton fitWidth = new JButton("Fit to Width");
    private final JButton fitHeight = new JButton("Fit to Height");
    private final JButton fitPage = new JButton("Fit to Page");

    private final JLabel pageCounter = new JLabel("Page 0 of 0");

    /**
     * @param args is of type String[]
     */
    @SuppressWarnings("unused")
    public static void main(final String[] args) {

        final int argLength = args.length;

        switch (argLength) {
            case 0:
                new BasePDFViewer();
                break;

            case 1:
                new BasePDFViewer(args[0]);
                break;

            default:
                System.out.println("You need 0 or 1 parameters");
                break;
        }
    }

    public BasePDFViewer(final String value) {
        this.filename = value;
        init();


    }

    public BasePDFViewer() {

        init();

    }


    private void init() {

        PdfDecoder.init(true);

        setupListeners();

        createGUI();

        mainFrame.setVisible(true);
    }

    private void setupListeners() {
        open.addActionListener(arg0 -> openFile());

        back.addActionListener(arg0 -> {
            if (currentPage > 1) {
                currentPage--;
            }

            decodePage();
        });

        forward.addActionListener(arg0 -> {
            if (currentPage < pdf.getPageCount()) {
                currentPage++;
            }

            decodePage();
        });

        currentScaling = 5;

        zoomIn.addActionListener(arg0 -> {
            //zoom in
            System.out.println("Zoom in");

            if (currentScaling < scalings.length - 1) {

                currentScaling = closestIndex(scale, scalings);

                if (scale >= scalings[closestIndex(scale, scalings)]) {

                    currentScaling++;

                }

                System.out.println("Current Scale ======= " + currentScaling);

                scale = scalings[currentScaling];

            }

            pdf.setPageParameters(scale, currentPage);

            pdf.updateUI();

            System.out.println("Scaling =========== " + pdf.getScaling());
        });

        zoomOut.addActionListener(arg0 -> {
            //zoom out
            System.out.println("Zoom out");

            if (currentScaling > 0) {

                currentScaling = closestIndex(scale, scalings);

                if (scale <= scalings[closestIndex(scale, scalings)]) {

                    currentScaling--;

                }

                System.out.println("Current Scale ======= " + currentScaling);

                scale = scalings[currentScaling];

            }

            pdf.setPageParameters(scale, currentPage);

            pdf.updateUI();

            System.out.println("Scaling =========== " + pdf.getScaling());
        });

        fitWidth.addActionListener(arg0 -> {
            // Fit to height
            System.out.println("Fit to Width");

            fitToX(FitToPage.WIDTH);

        });

        fitHeight.addActionListener(arg0 -> {
            // Fit to height
            System.out.println("Fit to Height");

            fitToX(FitToPage.HEIGHT);

        });

        fitPage.addActionListener(arg0 -> {
            // Fit to height
            System.out.println("Fit to Page");

            fitToX(FitToPage.AUTO);

        });

        mainFrame.addComponentListener(new ComponentListener() {

            @Override
            public void componentResized(final ComponentEvent e) {
            }

            @Override
            public void componentMoved(final ComponentEvent e) {
            }

            @Override
            public void componentShown(final ComponentEvent e) {
            }

            @Override
            public void componentHidden(final ComponentEvent e) {
            }

        });

        mainFrame.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(final WindowEvent e) {
                if (filename != null) {
                    try {
                        pdf.openPdfFile(filename);
                        decodePage();
                    } catch (final PdfException ex) {
                        ex.printStackTrace();
                    }
                } else {
                    openFile();
                }

            }

            @Override
            public void windowIconified(final WindowEvent e) {
            }

            @Override
            public void windowDeiconified(final WindowEvent e) {
            }

            @Override
            public void windowDeactivated(final WindowEvent e) {
            }

            @Override
            public void windowClosing(final WindowEvent e) {
            }

            @Override
            public void windowClosed(final WindowEvent e) {
            }

            @Override
            public void windowActivated(final WindowEvent e) {
            }
        });
    }

    private void createGUI() {
        toolBar.add(open);
        toolBar.add(back);
        toolBar.add(forward);
        toolBar.add(zoomIn);
        toolBar.add(zoomOut);
        toolBar.add(fitWidth);
        toolBar.add(fitHeight);
        toolBar.add(fitPage);
        toolBar.setFloatable(false);

        top.setLayout(new GridLayout(1, 1));
        top.add(toolBar);
        ((FlowLayout) insets.getLayout()).setVgap(0);
        ((FlowLayout) insets.getLayout()).setHgap(0);
        insets.add(pdf);
        if (insetV > 0 || insetH > 0) {

            insets.setBorder(new EmptyBorder(insetH, insetV, insetH, insetV));

        }
        scrollPdf = new JScrollPane(insets);
        scrollPdf.getVerticalScrollBar().setUnitIncrement(32);
        scrollPdf.getHorizontalScrollBar().setUnitIncrement(32);

        mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        mainFrame.getContentPane().add(top, BorderLayout.NORTH);
//        mainFrame.getContentPane().add(pdf, BorderLayout.CENTER);
        mainFrame.getContentPane().add(scrollPdf, BorderLayout.CENTER);
        mainFrame.getContentPane().add(pageCounter, BorderLayout.SOUTH);
        mainFrame.setSize(800, 600);
        //make viewer open in the center of the screen
        mainFrame.setLocationRelativeTo(null);

    }

    private void openFile() {
        try {

            final File f = OpenFile.showFileDialog(mainFrame, null, null, true);
          
            if (f != null) {

                pdf.openPdfFile(f.getAbsolutePath());

                decodePage();

                fitToX(FitToPage.AUTO);
            }
        } catch (final PdfException e) {
            e.printStackTrace();
        }

    }

    private void fitToX(final FitToPage fitToPage) {

        //Handle how we fit the content to the page
        switch (fitToPage) {

            case AUTO:
                if (pdf.getPDFWidth() < pdf.getPDFHeight()) {
                    fitToX(FitToPage.HEIGHT);
                } else {
                    fitToX(FitToPage.WIDTH);
                }

                break;

            case WIDTH:
                final float pageW = pdf.getPdfPageData().getCropBoxWidth2D(currentPage);
                scale = ((float) (scrollPdf.getViewportBorderBounds().getWidth() - insetV - insetV) / pageW);
                System.out.println("SCALE ==== " + scale);
                pdf.setPageParameters(scale, currentPage);

                break;

            case HEIGHT:
                final float pageH = pdf.getPdfPageData().getCropBoxHeight2D(currentPage);
                scale = ((float) (scrollPdf.getViewportBorderBounds().getHeight() - insetH - insetH) / pageH);
                pdf.setPageParameters(scale, currentPage);

                break;

        }

        pdf.updateUI();
    }

    private static int closestIndex(final float scale, final float[] scalings) {
        float currentMinDiff = Float.MAX_VALUE;
        int closest = 0;

        for (int i = 0; i < scalings.length - 1; i++) {

            final float diff = Math.abs(scalings[i] - scale);

            if (diff < currentMinDiff) {
                currentMinDiff = diff;
                closest = i;
            }

        }
        return closest;
    }


    private void decodePage() {
        try {
            pageCounter.setText("Page " + currentPage + " of " + pdf.getPageCount());

            final PdfPageData pageData = pdf.getPdfPageData();
            final int inset = 10;
            final int cw;
            final int ch;
            final int rotation = pageData.getRotation(currentPage);
            if (rotation == 90 || rotation == 270) {
                cw = pageData.getCropBoxHeight(currentPage);
                ch = pageData.getCropBoxWidth(currentPage);
            } else {
                cw = pageData.getCropBoxWidth(currentPage);
                ch = pageData.getCropBoxHeight(currentPage);
            }

            //define pdf view width and height
            final float width = (pdf.getWidth() - inset - inset);
            final float height = (pdf.getHeight() - inset - inset);

            if ((width > 0) && (height > 0)) {
                final float x_factor;
                final float y_factor;
                x_factor = width / cw;
                y_factor = height / ch;

                if (x_factor < y_factor) {
                    scale = x_factor;
                } else {
                    scale = y_factor;
                }
            }
            pdf.setPageParameters(scale, currentPage);
            pdf.decodePage(currentPage);

            //wait to ensure decoded
            pdf.waitForDecodingToFinish();

            pdf.invalidate();
            pdf.updateUI();
            pdf.validate();

        } catch (final Exception e) {
            e.printStackTrace();
        }
    }
}