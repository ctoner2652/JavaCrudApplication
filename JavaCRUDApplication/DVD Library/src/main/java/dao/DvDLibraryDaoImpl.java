package dao;

import dto.DvD;

import java.io.*;
import java.util.*;

public class DvDLibraryDaoImpl implements DvDLibraryDao{
    private static final String DVDFILE = "dvdfile.txt";
    private static final String DELIMITER = "::";

    public DvD addDvD(String title, DvD dvD) throws DvDLibraryDaoException {
        DvD newDvD = dvds.put(title,dvD);
        writeFile();
        return newDvD;
    }

    public DvD removeDvD(String title) throws DvDLibraryDaoException{
        DvD removedDvD = dvds.remove(title) ;
        writeFile();
        return  removedDvD;
    }

    public DvD editDvD(String title, DvD dvd) throws DvDLibraryDaoException{
        writeFile();
        dvds.replace(title, dvd);

        return dvds.get(title);
    }

    public List<DvD> getAllDvD() throws DvDLibraryDaoException {
        loadFile();
        return new ArrayList<DvD>(dvds.values());
    }

    public DvD getDvD(String title) throws DvDLibraryDaoException {
        loadFile();

        return dvds.get(title);
    }

    public Map<String, DvD> dvds = new HashMap<String, DvD>();

    public void loadFile() throws DvDLibraryDaoException{
        Scanner sc;
        try{
            sc = new Scanner(new BufferedReader(new FileReader(DVDFILE)));

        }catch(FileNotFoundException e){
            throw new DvDLibraryDaoException("Unable to load data");
        }
        String currentLine;
        String[] currentTokens;

        while(sc.hasNextLine()){
            currentLine = sc.nextLine();
            currentTokens = currentLine.split(DELIMITER);

            DvD dvd = new DvD(currentTokens[0]);
            dvd.setReleaseDate(currentTokens[1]);
            dvd.setRating(currentTokens[2]);
            dvd.setDirectorName(currentTokens[3]);
            dvd.setStudio(currentTokens[4]);
            dvd.setPersonalRating(currentTokens[5]);
            dvds.put(dvd.getTitle(), dvd);

        }
        sc.close();
    }

    public void writeFile() throws DvDLibraryDaoException{
        PrintWriter push;
        try{
            push = new PrintWriter(new FileWriter(DVDFILE));

        }catch(IOException e){
            throw new DvDLibraryDaoException("Could not load data", e);

        }

        for(DvD dvd : dvds.values()){
            push.println(dvd.getTitle()+  DELIMITER + dvd.getReleaseDate() + DELIMITER
            + dvd.getRating() + DELIMITER + dvd.getDirectorName() + DELIMITER + dvd.getStudio() + DELIMITER + dvd.getPersonalRating());
            push.flush();
        }
        push.close();
    }

}
