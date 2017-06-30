package view;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.io.File;

/**
 * Created by Administrator on 2017/6/30 0030.
 */
public class MyChooseFile  extends JFileChooser{

    public MyChooseFile() {
        setAcceptAllFileFilterUsed(false);
        addFilter();
        setFileSelectionMode(FILES_AND_DIRECTORIES);
    }

    public MyChooseFile(String dirBk) {
        super(dirBk);
    }

    private void addFilter() {
        this.addChoosableFileFilter(new MyFileFilter(new String[] { ".BMP" },
                "BMP (*.BMP)"));
        this.addChoosableFileFilter(new MyFileFilter(new String[] { ".JPG",
                ".JPEG", ".JPE", ".JFIF" },
                "JPEG (*.JPG;*.JPEG;*.JPE;*.JFIF)"));
        this.addChoosableFileFilter(new MyFileFilter(new String[] { ".GIF" },
                "GIF (*.GIF)"));
        this.addChoosableFileFilter(new MyFileFilter(new String[] { ".TIF",
                ".TIFF" }, "TIFF (*.TIF;*.TIFF)"));
        this.addChoosableFileFilter(new MyFileFilter(new String[] { ".PNG" },
                "PNG (*.PNG)"));
        this.addChoosableFileFilter(new MyFileFilter(new String[] { ".ICO" },
                "ICO (*.ICO)"));
        this.addChoosableFileFilter(new MyFileFilter(new String[] { ".BMP",
                ".JPG", ".JPEG", ".JPE", ".JFIF", ".GIF", ".TIF", ".TIFF",
                ".PNG", ".ICO" }, "所有图形文件"));
    }

    class MyFileFilter  extends FileFilter{
        private  String [] suffarr;
        private  String description;

        public MyFileFilter(String[] suffarr, String description) {
            this.suffarr = suffarr;
            this.description = description;
        }

        @Override
        public boolean accept(File f) {
            if (f.isDirectory()) {
                return true;
            }
            for (int i = 0; i < suffarr.length; i++) {
                if (f.getName().toUpperCase().endsWith(suffarr[i])) {
                    return true;
                }
            }
            return false;
        }
        @Override
        public String getDescription() {
            return description;
        }
    }
}
